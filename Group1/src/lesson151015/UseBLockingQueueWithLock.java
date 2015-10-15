package lesson151015;

import lesson151008.Utils;

public class UseBLockingQueueWithLock {

	public static void main(String[] args) {

		final BlockingQueueWithLock<String> queue = new BlockingQueueWithLock<>(3);

		new Thread(new Runnable() {
			@Override
			public void run() {
				queue.put("one");
				System.out.println("put");
				Utils.pause(2000);
				queue.put("two");
				System.out.println("put");
				Utils.pause(2000);
				queue.put("three");
				System.out.println("put");
				Utils.pause(2000);
				queue.put("four");
				System.out.println("put");
				Utils.pause(2000);
				queue.put("five");
				System.out.println("put");
			}
		}).start();
		
		Utils.pause(10000);
		
		while(true) {
			Utils.pause(3000);
			System.out.println(queue.take());
		}
		
	}

}
