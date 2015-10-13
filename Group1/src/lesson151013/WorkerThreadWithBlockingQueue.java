package lesson151013;

import lesson151008.Utils;

public class WorkerThreadWithBlockingQueue {

	private final class TaskRunner implements Runnable {
		@Override
		public void run() {
			while (true) {
				tasks.take().run();
			}
		}
	}

	private Thread thread;

	private BlockingQueue<Runnable> tasks = new BlockingQueue<>();

	public WorkerThreadWithBlockingQueue() {
		thread = new Thread(new TaskRunner());
		thread.start();
	}

	public void execute(Runnable runnable) {
		tasks.put(runnable);
	}

	public static void main(String[] args) {
		System.out.println("start");

		WorkerThreadWithBlockingQueue worker = new WorkerThreadWithBlockingQueue();

		Utils.pause(3000);

		worker.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello from "
						+ Thread.currentThread().getName());
			}
		});

	}

}
