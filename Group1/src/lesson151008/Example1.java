package lesson151008;

public class Example1 {
	
	static class MyThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class Task implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.err.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		new MyThread().start();
		new Thread(new Task()).start();
		new Task().run();
		
	}

}
