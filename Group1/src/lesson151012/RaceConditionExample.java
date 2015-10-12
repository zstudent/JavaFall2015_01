package lesson151012;

import lesson151008.Utils;

public class RaceConditionExample {

	volatile static int count = 0;
	
	static Object mutex = new Object();
	
	static class Counter implements Runnable {

		@Override
		public void run() {
			while(true) {
				inc();
				Utils.pause(1000);
			}
		}

		private void inc() {
			synchronized (mutex) {
				int tmp = count;
				tmp = tmp + 1;
				count = tmp;
				System.out.println(count);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		
		t1.start();
		t2.start();
		
	}
	
}
