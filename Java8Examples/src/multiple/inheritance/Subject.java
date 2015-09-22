package multiple.inheritance;

public class Subject implements MoveOrSize {

	int size;
	int x;
	
	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int setX(int x) {
		return this.x = x;
	}
	
	public static void main(String[] args) {
		
		Subject s = new Subject();
		
		s.setSize(10);
		s.setX(20);
		
		s.doubleSize();
		s.moveBy(30);
		
	}

}
