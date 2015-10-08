package lesson151008;

public class JoinExample {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(25000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		};
		
		thread.start();
		
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("finish");
	}

}
