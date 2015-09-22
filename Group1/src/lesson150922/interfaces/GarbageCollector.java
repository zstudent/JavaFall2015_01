package lesson150922.interfaces;

public class GarbageCollector {

	public static void main(String[] args) {
		
		Car car = new Car();
		Table table = new Table();
		
		Crashable[] things = {car, table};
		
		collect(things);
		
	}

	private static void collect(Crashable[] things) {
		for (Crashable crashable : things) {
			crashable.crash();
		}
	}
	
}
