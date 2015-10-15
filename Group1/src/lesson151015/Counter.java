package lesson151015;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	
	private int count;
	
//	private Object lock = new Object();
	private Lock lock = new ReentrantLock();
	
	public void inc() {
//		synchronized (lock) {
//			count++;
//		}
		
		lock.lock();   // lock
		try {
			count++;  // do work
		} finally {
			lock.unlock();  // unlock
		}
		
	}
	
	public int get() {
//		synchronized (lock) {
//			return count;
//		}
		lock.lock();
		try {
			return count;
		} finally {
			lock.unlock();
		}
	}
	

}
