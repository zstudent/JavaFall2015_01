package lesson150921;

public class InheritanceMethods2 {
	
	static class A {
		
		int calc() {
			return 2*2;
		}
	}
	
	static class B extends A {
		
		
	}
	
	static class C extends B {
		
		@Override
		int calc() {
			return super.calc();
		}
		
	}
	
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.calc());
	} 

}
