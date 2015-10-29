package lesson151029;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class UseStandardLogging {
	
	static Logger logger = Logger.getLogger("myTest");

	static class Task implements Runnable {

		Random rand = new Random();
		int count;

		@Override
		public void run() {
			long start = System.nanoTime();
			while (count < 100_000_000) {
				count++;
				if (count % 1_000_000 == 0) {
					logger.info(String.valueOf(count));
				}
			}
			long stop = System.nanoTime();

			System.out.println("Elasped : " + (stop - start));

		}

	}
	

	public static void main(String[] args) {
		
//		logger.setLevel(Level.SEVERE);
		
		try {
			logger.addHandler(new FileHandler());
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

		
		System.out.println("start");
		new Task().run();

	}

}
