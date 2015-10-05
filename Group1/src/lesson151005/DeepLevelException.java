package lesson151005;

import java.util.Random;

public class DeepLevelException {

	public static void main(String[] args) {
		
		boss();
		
	}

	private static void boss() {
		try {
			zam();
		} catch (Exception e) {
			System.out.println("отказать");
		}
	}

	private static void zam() throws Exception {
		try {
			helper();
		} catch (Exception e) {
			if (e.getMessage().equals("haha")) {
				System.out.println("прекратить шуточки!");
				return;
			}
			throw e;
		}
	}

	private static void helper() throws Exception {
		intern();
	}

	private static void intern() throws Exception {
		tmp();
	}

	private static void tmp() throws Exception {
		Random random = new Random();
		int x = random.nextInt();
		throw x % 2 == 0? new Exception("got bug!") : new Exception("haha");
	}

	
	
	
	
	
	
	
	
	
}
