package lesson151008;

class Ticker implements Runnable {

	@Override
	public void run() {
		int x = 0;
		while (true) {
			System.out.println(x++);
			Utils.pause(1000);
		}
	}
	
}