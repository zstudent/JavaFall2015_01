package lesson151005;

import java.util.Scanner;

public class AutoCloseExample {

	public static void main(String[] args) {
		
//		Scanner scanner = new Scanner(System.in);
//		
//		try {
//			while (scanner.hasNextLine()) {
//				System.out.println(scanner.nextLine());
//			}
//			
//		} finally {
//			scanner.close();
//		}
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
		
	}
	
}
