package lesson151008;

public class ThreadStopDemo {
	
	static class Task implements Runnable {

		volatile private boolean stopped;
		
		@Override
		public void run() {
			long i = 0;
			while(!stopped) {
				i++;
				if (i % 10000 == 0) {
					Thread.yield();
				}
			}
			System.out.println(i);
		}
		
		public void stop() {
			stopped = true;
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("start");
		
		Task task = new Task();
		
		new Thread(task).start();
		
		Utils.pause(5000);
		
		task.stop();
		
		System.out.println("finish");
	}
	
	
	
	

}
