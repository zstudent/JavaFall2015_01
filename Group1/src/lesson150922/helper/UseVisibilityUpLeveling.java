package lesson150922.helper;

import lesson150922.VisibilityUpLeveling;
import lesson150922.VisibilityUpLeveling.A;

public class UseVisibilityUpLeveling {
	
	public static class B extends A {
		
		@Override
		public void method() {
			super.method();
		}
		
	}


	
	public static void main(String[] args) {
		
		VisibilityUpLeveling.A a = new VisibilityUpLeveling.A();
//		a.method();   ERROR!
		
		B b = new B();
		
		b.method();
		
	}
	

}
