package com.epam.chat.server;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientHandler {

	private long uuid;
	private List<String> responds = new LinkedList<>();
	private Lock lock = new ReentrantLock();

	public ClientHandler(long uuid) {
		this.uuid = uuid;
	}

	public List<String> getPost() {
		lock.lock();
		try {
			String[] answers = responds.toArray(new String[0]);
			responds.clear();
			return Arrays.asList(answers);
		} finally {
			lock.unlock();
		}
	}
	
	public void addRespond(String message) {
		lock.lock();
		try {
			responds.add(message);
		} finally {
			lock.unlock();
		}
	}

}
