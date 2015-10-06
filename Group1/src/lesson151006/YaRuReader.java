package lesson151006;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class YaRuReader {
	
	public static void main(String[] args) {
		
		try {
			try (Socket socket = new Socket("ya.ru", 80)) {  // telnet ya.ru 80
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(outputStream);
				pw.println("GET / HTTP/1.0");
				pw.println();
				pw.flush(); // !!!
				InputStream inputStream = socket.getInputStream();
				Scanner scanner = new Scanner(inputStream);
				while(scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}

}
