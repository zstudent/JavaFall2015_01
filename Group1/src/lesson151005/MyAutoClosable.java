package lesson151005;

public class MyAutoClosable {

	static class Resource implements AutoCloseable {
		@Override
		public void close() {
			System.out.println("closing " + this);
		}
	}
	
	public static void main(String[] args) {
		
		try (Resource resource = new Resource()) {
			System.out.println("working with " + resource);
		}
		
		
	}

}
