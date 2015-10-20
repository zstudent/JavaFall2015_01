package lesson151020;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatImpl implements Chat {
	
	List<SocketHandler> clients = new LinkedList<>();
	
	BlockingQueue<String> messages = new LinkedBlockingQueue<>();

	public ChatImpl() {
		ChatServer.service.execute(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						String message = messages.take();
						broadcast(message);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	@Override
	public void received(SocketHandler exclude, String line) {
			messages.offer(exclude + " > " + line);
	}

	private void broadcast(final String line) {
		System.out.println(" >> " + line);
		for (final SocketHandler socketHandler : clients) {
			ChatServer.service.execute(new Runnable() {
				@Override
				public void run() {
					socketHandler.send(line);
				}
			});
		}
	}

	@Override
	public void register(SocketHandler client) {
		clients.add(client);
	}
}