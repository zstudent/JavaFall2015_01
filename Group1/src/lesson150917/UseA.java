package lesson150917;

public class UseA {
	
	public static void main(String[] args) {
		A.staticMethod();
		
		A a = new A();
		
		A.staticMethod(a);
		
//		a.x = 10;  ERROR
		
//		A.globalCount = 0;  ERROR
		
		A a2 = new A(90);
		
		A.printCount();
	}
}
