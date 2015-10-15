package lesson151015;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
	
	void a() {
		synchronized (this) {
			synchronized (this) {
				System.out.println("inside b");
			}
		}
	}
	
	void c() {
		ReentrantLock lock = new ReentrantLock();
		
		lock.lock();
		try {
			lock.lock();
			try {
				System.out.println("here! " + lock.getHoldCount());
			} finally {
				lock.unlock();
			}
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		
		Reentrant reentrant = new Reentrant();
		
		reentrant.a();
		reentrant.c();
		
	}

}
