package lesson151013;

import lesson151008.Utils;

public class WakeupCheck {

	public static void main(String[] args) {

		final Object starter = "starter";

		class Runner implements Runnable {

			boolean started;

			@Override
			public void run() {
				synchronized (starter) {
					while (!started) {
						System.out.println(Thread.currentThread()
								+ "waiting for signal");
						try {
							starter.wait(); // starter is free now!
						} catch (InterruptedException e) {
							System.err.println("woke up, but are we started?");
						}
					}
				}

				System.out.println("running!");
			}

			public void start() {
				synchronized (starter) {
					started = true;
					starter.notify();
				}
			}

		}

		Runner runner = new Runner();

		Thread thread = new Thread(runner);
		thread.start();

		Utils.pause(3000);

		thread.interrupt();
		Utils.pause(3000);
		
		runner.start();

	}

}
