package lesson151015;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueWithLock<T> {
	
	private Queue<T> queue = new LinkedList<>();
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	private int capacity;
	
	public BlockingQueueWithLock(int capacity) {
		this.capacity = capacity;
	}
	
	public T take() {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notEmpty.awaitUninterruptibly();
			}
			notFull.signal();
			return queue.poll();
		} finally {
			lock.unlock();
		}
	}

	public void put(T item) {
		lock.lock();
		try {
			while (queue.size() == capacity) {
				notFull.awaitUninterruptibly();
			}
			queue.offer(item);
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public int size() {
		return queue.size();
	}
	
	
	
	
	
	
	
	
	
	
	
}
