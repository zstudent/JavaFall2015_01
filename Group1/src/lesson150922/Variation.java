package lesson150922;

public class Variation {
	
	static class HuntDog {
		
		public void trackFox() {
			
		}
	}
	
	static class HuntDucksDog extends HuntDog {
		
		public void trackDuck() {
			// something
			trackFox();
		}
		
		
	}

}
