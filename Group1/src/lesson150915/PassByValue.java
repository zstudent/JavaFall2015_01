package lesson150915;

public class PassByValue {

	
	public static void main(final String[] args) {
		
		final int x = 10;
		
		change(x);  // 10
		
		System.out.println(x);
	}

	static void change(final int x) { //  x = 10;
//		x = 20;  ERROR!
	}
	
}
