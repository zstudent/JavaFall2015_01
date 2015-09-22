package lesson150922.inheritance.vs.composition;

public class E extends A implements Changeable {

	public E(int initialState) {
		super(initialState);
	}
	
	@Override
	public void change() {
		state = (int) Math.pow(state, 2);
		System.out.println("E");
	}
	
}
