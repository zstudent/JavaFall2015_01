package lesson150922.inheritance.vs.composition;

public class D extends A implements Changeable {

	public D(int initialState) {
		super(initialState);
	}
	
	@Override
	public void change() {
		state /= 2;
		System.out.println("D");
	}

}
