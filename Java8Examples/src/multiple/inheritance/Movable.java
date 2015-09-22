package multiple.inheritance;

public interface Movable {

	int getX();

	int setX(int x);

	default void moveBy(int shift) {
		setX(getX() + shift);
	}

}
