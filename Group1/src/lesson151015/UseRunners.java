package lesson151015;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lesson151008.Utils;

public class UseRunners {

	public static void main(String[] args) {
		
		System.out.println("start");
		
		Lock lock = new ReentrantLock(true);
		Condition condition = lock.newCondition();
		
		lock.lock();
		
		try {
			Runner runner1 = new Runner(lock, condition);
			Runner runner2 = new Runner(lock, condition);
			Runner runner3 = new Runner(lock, condition);
			
			Thread thread1 = new Thread(runner1, "Runner1");
			Thread thread2 = new Thread(runner2, "Runner2");
			Thread thread3 = new Thread(runner3, "Runner3");
			
			thread1.start();
			thread2.start();
			thread3.start();
			
			Utils.pause(3000);
			
		} finally {
			lock.unlock();
		}
		
		lock.lock();
		
		try {
			condition.signalAll();
			System.out.println("signaled");
		} finally {
			lock.unlock();
		}
		
		//
		
	}
	
}
