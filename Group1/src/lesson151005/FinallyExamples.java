package lesson151005;

public class FinallyExamples {
	
	public static void main(String[] args) {

		System.out.println(getAge());
		
		try {
			System.out.println("вот те раз...");
			throw new RuntimeException("стоп!");
		} finally {
			System.out.println("вот те два!");
		}
		
	}

	private static int getAge() {
		try {
			return 20;
		} finally {
			return 30;
		}
		
	}

}
