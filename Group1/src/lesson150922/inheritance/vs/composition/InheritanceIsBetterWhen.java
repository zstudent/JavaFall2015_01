package lesson150922.inheritance.vs.composition;

public class InheritanceIsBetterWhen {
	
	static class A implements M {
		
		@Override
		public void m1() {};
		@Override
		public void m2() {};
		@Override
		public void m3() {};
		@Override
		public void m4() {};
		@Override
		public void m5() {};
		@Override
		public void m6() {};
		
	}
	
	static class B extends A {
		
	}
	
	static class C implements M {
		M m;
		
		C(M m) { this.m = m;}

		@Override
		public void m1() {
			m.m1();
		}

		@Override
		public void m2() {
			m.m2();
		}

		@Override
		public void m3() {
			m.m3();
		}

		@Override
		public void m4() {
			m.m4();
		}

		@Override
		public void m5() {
			m.m5();
		}

		@Override
		public void m6() {
			m.m6();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		M m;
		
		m = new B();
		
		m.m1();
		m.m2();
		m.m3();
		m.m4();
		m.m5();
		m.m6();
		
		m = new C(m);
	}

}
