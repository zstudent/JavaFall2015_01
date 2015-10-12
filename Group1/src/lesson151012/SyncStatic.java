package lesson151012;

public class SyncStatic {
	
	private static long count;
	
	synchronized public static long getCount() {
		return count;
	}
	
	synchronized public static void inc() {
		count++;
	}
	
	public static void inc(int amount) {
		synchronized (SyncStatic.class) {
			count += amount;
		}
	}

}
