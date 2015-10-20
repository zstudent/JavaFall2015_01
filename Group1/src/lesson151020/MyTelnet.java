package lesson151020;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTelnet {

	static final ExecutorService service = Executors.newCachedThreadPool();

	public static void main(String[] args) {
		System.out.println("start typing");
		try {
			try (Socket socket = new Socket("localhost", 10000)) {

				final OutputStream outputStream = socket.getOutputStream();
				service.execute(new Runnable() {
					@Override
					public void run() {
						handleOutputToServer(outputStream);
					}
				});

				try (Scanner scanner = new Scanner(socket.getInputStream())) {
					while (scanner.hasNextLine()) {
						System.out.println(scanner.nextLine());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected static void handleOutputToServer(OutputStream outputStream) {
		PrintWriter pw = new PrintWriter(outputStream);
		
		try (Scanner keyboardScanner = new Scanner(System.in)) {
			while (keyboardScanner.hasNextLine()) {
				String line = keyboardScanner.nextLine();
				pw.println(line);
				pw.flush(); // !!!
			}
		}
		

	}

}
