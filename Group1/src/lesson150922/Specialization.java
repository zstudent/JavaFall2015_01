package lesson150922;

public class Specialization {
	
	static class Pet {
		
		public void feed() {
			System.out.println("feeding pet");
		}
		
	}
	
	static class Cat extends Pet {
		
		@Override
		public void feed() {
			super.feed();
			murr();
		}
		
		public void combBehindEar() {
			murr();
		}

		private void murr() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
