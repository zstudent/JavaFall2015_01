package lesson150922;

public class Specification {
	
	static abstract class Pet {
		
		abstract void wash();
		
	}
	
	static class Dog extends Pet {

		@Override
		void wash() {
			System.out.println("washing dog");
		}
		
	}

}
