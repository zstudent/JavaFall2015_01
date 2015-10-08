package lesson151008;

public class ThreadStopDemo2 {
	
	static class Task implements Runnable {

		volatile boolean stopped = false;
		
		@Override
		public void run() {
			while (!stopped) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					System.out.println("interrupted!");
				}
			}
			System.out.println("stopped!");
		}
		
	}
	
	public static void main(String[] args) {
		
		Task task = new Task();
		
		Thread thread = new Thread(task);
		thread.start();
		
		Utils.pause(5000);
		
		System.out.println("stopping");
		task.stopped = true;
		thread.interrupt();
		
	}
	

}
