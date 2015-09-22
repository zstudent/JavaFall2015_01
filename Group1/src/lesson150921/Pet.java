package lesson150921;


public class Pet {
	
	public void feed() {
		System.out.println("Pet is not hungry now");
	}
	
	public void walk() {
		System.out.println("You walked with your pet");
	}
	
	public void play() {
		System.out.println("Played with pet");
	}

	
	public final void care() {  // pet = cat
		feed();
		walk();
		play();
		
		special();
		
	}

	public void special() {
	}
	

}
