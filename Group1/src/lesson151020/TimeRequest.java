package lesson151020;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TimeRequest {

	public static void main(String[] args) {

		try (Socket socket = new Socket("time-d.nist.gov", 13)) {
			InputStream inputStream = socket.getInputStream();
			try (Scanner scanner = new Scanner(inputStream)) {
				while (scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
