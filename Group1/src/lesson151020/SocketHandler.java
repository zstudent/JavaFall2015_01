package lesson151020;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SocketHandler implements Runnable {

	private Socket socket;
	private Chat chat;
	private PrintWriter printWriter;
	BlockingQueue<String> messages = new LinkedBlockingQueue<>();

	public SocketHandler(Chat chat, Socket socket) throws IOException {
		this.chat = chat;
		this.socket = socket;
		printWriter = new PrintWriter(socket.getOutputStream());
		ChatServer.service.execute(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						String message = messages.take();
						sendViaSocket(message);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	@Override
	public void run() {
		try {
			try (Scanner scanner = new Scanner(socket.getInputStream())) {
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					chat.received(this, line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String line) {
		messages.offer(line);
	}

	private void sendViaSocket(String line) {
		printWriter.println(line);
		printWriter.flush();
	}

}
