package lesson151008;

public class StacktraceDemo {
	
	public static void main(String[] args) {
		
		a();
		
	}

	private static void a() {
		int x = 0;
		b();
	}

	private static void b() {
		int y = 10;
		c();
	}

	private static void c() {
		int k = 20;
		d();
	}

	private static void d() {
		int v = 30;
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread);
		for (StackTraceElement el : currentThread.getStackTrace()) {
			System.out.println(el.getClassName() + " "
					+ el.getMethodName() + " : " + el.getLineNumber());
		}
	}

}
