package lesson151029;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lesson151008.Utils;

public class SemaphoreExample {
	
	static Random random = new Random();
	
	static class Skater implements Runnable {

		private Semaphore sem;

		public Skater(Semaphore sem) {
			this.sem = sem;
		}

		@Override
		public void run() {
			System.out.println("starts");
			Utils.pause(random.nextInt(5000) + 5000);
			System.out.println("finishes");
			sem.release();
		}
		
	}
	
	public static void main(String[] args) {
		
		Semaphore sem = new Semaphore(5);
		
		ExecutorService ex = Executors.newCachedThreadPool();
		
		while (true) {
			sem.acquireUninterruptibly();
			ex.execute(new Skater(sem));
		}
		
	}
	

}
