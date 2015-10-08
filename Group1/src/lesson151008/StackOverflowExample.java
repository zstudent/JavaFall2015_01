package lesson151008;

public class StackOverflowExample {
	
	public static void main(String[] args) {
		
		a();
		
	}

	private static void a() {
		int x = 0;
		a();
	}

}
