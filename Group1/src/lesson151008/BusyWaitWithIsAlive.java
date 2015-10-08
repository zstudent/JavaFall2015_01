package lesson151008;

public class BusyWaitWithIsAlive {

	static class Task implements Runnable {
		@Override
		public void run() {
			Thread.currentThread().setName(Task.class.getCanonicalName());
			for (long i = 0; i < 100_000_000_000L; i++) {
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Thread t = new Thread(new Task());
		
		t.start();
		
		int c = 0;
		while (t.isAlive()) {
//			System.out.println(c++);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
		System.out.println("finish");
		
		
	}
	
}
