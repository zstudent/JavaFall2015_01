package lesson151015;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class Runner implements Runnable {
	private Lock lock;
	private Condition condition;
	public Runner(Lock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}
	@Override
	public void run() {
		lock.lock();  // like synchronized (lock) {
		System.out.println(Thread.currentThread().getName());
		try {
			condition.awaitUninterruptibly();  // like wait();
			System.out.println(Thread.currentThread().getName() + " awaken");
		} finally {
			lock.unlock();  // like }
		}
	}
}