package lesson151015;

import lesson151008.Utils;

public class SyncProblems {

	public static void main(String[] args) {
		
		
		final Object mutex = new Object();
		
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("running");
				synchronized (mutex) {
					System.out.println("synched in");
					try {
						mutex.wait(); // now mutex is free
					} catch (InterruptedException e) {
						System.out.println("interrupted");
					}
					System.out.println("woke up");
				}
				System.out.println("synched out");
			}
		});
		thread.start();
		
		Utils.pause(1000);
		
		synchronized (mutex) {
			thread.interrupt();
			while (true) {
				Utils.pause(1000);
			}
			
		}
		
		
	}
	
}
