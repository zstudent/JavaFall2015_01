package lesson150928;

public class Inners {
	
	static class A {
		
		int x = 0;
		
		class B {
			
			{
//				A.this.x = 10;
				x = 10;
			}
			
			public void change() {
//				A.this.x += 20;
				x += 20;
			}
		}
		
	}
	
	static class C {
		int x = 0;
	}
	
	static class D {
		
		private C c;

		public D(C c) {
			this.c = c;
		}
		
		public void change() {
			c.x += 20;
		}
		
	}

}
