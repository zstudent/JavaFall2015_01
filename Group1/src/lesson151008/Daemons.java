package lesson151008;

public class Daemons {
	
	public static void main(String[] args) {
		System.out.println("start");
		Thread thread = new Thread(new Ticker());
		thread.setDaemon(true);
		thread.start();
		
		new Thread() {
			@Override
			public void run() {
				Utils.pause(10000);
			};
			
		}.start();
		
		Utils.pause(5000);
		
		System.out.println("finish");
		
	}

}
