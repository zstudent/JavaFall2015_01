package lesson151015;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import lesson151008.Utils;

public class CachedThreadPoolExample {
	
	static class Task implements Callable<Double> {

		@Override
		public Double call() throws Exception {
			Thread.currentThread().setName(this.getClass().getCanonicalName());
			double d = 0;
			for (long i = 0; i < 1_000_000_000L; i++) {
				d += Math.pow(Math.PI, Math.E);
			}
			return d;
		}
		
	}

	
	public static void main(String[] args) {
		
		
		ExecutorService service = Executors.newCachedThreadPool(new ThreadFactory() {
			
			int count;
			
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r, "Zaal-" + (count++));
			}
		});
		
		for (int i = 0; i < 10; i++) {
			service.submit(new Task());
			Utils.pause(1000);
		}
		
		for (int i = 0; i < 10; i++) {
			service.submit(new Task());
			Utils.pause(100);
		}
		
		for (int i = 0; i < 10; i++) {
			service.submit(new Task());
			Utils.pause(1000);
		}
		
	}
	

}
