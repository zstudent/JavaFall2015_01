package lesson150921;

public class InheritanceConstructor {
	
	static class A {
		
		A(int x) {
			System.out.println("x=" + x);
		}
		
	}
	
	static class B extends A {
		
		B() {
			super(0);
		}
		
	}
	
	public static void main(String[] args) {
		
		B b = new B();
//		new A();  ERROR!
	}
	

}
