package lesson150917;

public class B {
	
	public static int x = 1;
	// 1 - only once!
	
	static {
		System.out.println("static");
		x = 2;
	}
	
	
	// 5
	public B() {
		System.out.println("constructor");
	}

	
	// 3
	
	{
		System.out.println("instance");
	}
	
	
	// 2 - only once
	static {
		System.out.println("static 2");
	}

	// 4
	
	{
		System.out.println("instance 2");
	}
}
