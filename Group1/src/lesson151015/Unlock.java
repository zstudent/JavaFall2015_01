package lesson151015;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Unlock {

	public static void main(String[] args) {
		
		final Lock lock = new ReentrantLock();
		
		lock.lock();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.unlock();
			}
		}).start();
	}
	
}
