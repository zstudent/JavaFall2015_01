package lesson151020;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer  {
	
	static ExecutorService service = Executors.newCachedThreadPool();
	
	private static final Chat chat = new ChatImpl();
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		try (ServerSocket ss = new ServerSocket(10000)) {
			
			while (true) {
				Socket socket = ss.accept();
				
				SocketHandler client = new SocketHandler(chat, socket);
				chat.register(client);
				service.execute(client);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
