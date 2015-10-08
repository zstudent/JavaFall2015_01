package lesson151008;

public class CommonObjects {
	
	static class Data {
		
		int x = 20;
		
	}
	
	public static void main(String[] args) {
		
		Data data = new Data();
		
		a(data);
		
	}

	private static void a(final Data d) {
		new Thread() {
			@Override
			public void run() {
				System.out.println(d.x);
			};
			
		}.start();
		
	}

}
