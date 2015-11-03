package com.epam.chat.server;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.gwt.dev.util.collect.HashMap;

public class Chat implements Runnable {
	
	Map<Long, ClientHandler> clients = new HashMap<>();
	private BlockingQueue<String> messages = new LinkedBlockingQueue<String>();

	public List<String> process(long uuid, String message) {
		ClientHandler clientHandler = clients.get(uuid);
		if (clientHandler == null) {
			clientHandler = new ClientHandler(uuid);
			clients.put(uuid, clientHandler);
		}
		if (!message.isEmpty()) {
			broadcast(message);
		}
		return clientHandler.getPost();
	}

	private void broadcast(String message) {
		messages.offer(message);
	}

	@Override
	public void run() {
		System.out.println("start listening for messages");
		while (true) {
			try {
				String message = messages.take();
				for (ClientHandler client : clients.values()) {
					client.addRespond(message);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
