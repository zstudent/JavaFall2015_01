package lesson151008;

public class Example2 {
	
	static class Task implements Runnable {
		
		@Override
		public void run() {
			int i = 0;
			while(true) {
				i++;
				if (i % 1_000_000_000 == 0) {
					System.out.println(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new Thread(new Task()).start();
		new Thread(new Task()).start();
		new Thread(new Task()).start();
		new Thread(new Task()).start();
		
		
	}

}
