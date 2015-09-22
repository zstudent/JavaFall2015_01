package lesson150922.inheritance.vs.composition;

public class A {

	int state;
	
	public A() {
		this(10);
	}
	
	public A(int initialState) {
		state = initialState;
	}
	
	public void change() {
		state++;
	}

}
