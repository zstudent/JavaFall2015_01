package lesson151029;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lesson151008.Utils;

public class UseRunners {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		CountDownLatch latch = new CountDownLatch(3);
		
		executorService.execute(new Runner(latch));
		executorService.execute(new Runner(latch));
		executorService.execute(new Runner(latch));
		executorService.execute(new Runner(latch));
		
		Utils.pause(1000);
		System.out.println("Ready...");
		latch.countDown();
		Utils.pause(1000);
		System.out.println("Steady...");
		latch.countDown();
		Utils.pause(1000);
		System.out.println("Go!!!");
		latch.countDown();
		
	}
	
}
