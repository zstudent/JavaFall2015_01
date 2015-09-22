package lesson150922.inheritance.vs.composition;

public class UseAB {

	public static void main(String[] args) {
		
		B b = new B();
		b.change();
		System.out.println(b.state);
		
		C c = new C();
		c.setChanger(new D(50));
		c.change();
		c.change();
		c.setChanger(new E(300));
		c.change();
	}
	
}
