package lesson150928;

public class Locals {

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("Yo!");
		}

	}

	public static Runnable createTask() {
		return new Runnable() {

			@Override
			public void run() {
				System.out.println("Hi there!");
			}

		};
	}

	public static Runnable[] tasks() {

		class MyTask implements Runnable {

			private String message;

			public MyTask(String message) {
				this.message = message;
			}

			@Override
			public void run() {
				System.out.println(message);
			}

		}

		Runnable[] myTasks = { new MyTask("first"), new MyTask("second"),
				new MyTask("last") };

		return myTasks;

	}

	public static void main(String[] args) {

		createTask().run();

		new Task().run();

	}

}
