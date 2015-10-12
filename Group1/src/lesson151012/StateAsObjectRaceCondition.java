package lesson151012;

import lesson151008.Utils;

public class StateAsObjectRaceCondition {

	static class A {
		int x = 0;
		int y = 100;
	}
	
	static class B {
		
		A a = new A();
		
		synchronized public A get() {
			return a;
		}
		
		synchronized public void change(int amount) {
			System.out.println("change start");
			Utils.pause(3000);
			a.x += amount;
			Utils.pause(3000);
			a.y -= amount;
			Utils.pause(3000);
			System.out.println("change finish");
		}
		
	}
	
	public static void main(String[] args) {
		
		B b = new B();
		
		final A a = b.get();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					System.out.println("a.x = " + a.x + " a.y = " + a.y);
					Utils.pause(500);
				}
			}
		}).start();
		
		b.change(20);
		
		
		
		
	}
	
	
	
}
