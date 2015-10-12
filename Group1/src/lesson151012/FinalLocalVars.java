package lesson151012;

import lesson151008.Utils;

public class FinalLocalVars {

	
	public static void main(String[] args) {
		
		final int x = 10;  // outer.x
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// int x = outer.x;
				Utils.pause(3000);
				System.out.println("x = " + x); 
			}
		}).start();
		
		System.out.println("finished");
		
		
	}
	
}
