package lesson151027;

public class A {

	Crashable c;
	
	public A(Crashable c) {
		this.c = c;
	}
	
	public void destroy() {
		c.crash();
		c.crash();
	}
	
}
