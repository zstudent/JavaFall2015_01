package lesson151013;

import java.util.Vector;

import lesson151008.Utils;

public class WrongEncapsulation {

	public static void main(String[] args) {

		final Vector<String> vector = new Vector();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					vector.addElement("one");
					System.out.println(vector);
					Utils.pause(1000);
					vector.removeElementAt(0);
					System.out.println(vector);
					Utils.pause(1000);
				}
			}
		}).start();
		
		Utils.pause(5000);
		
		synchronized (vector) {
			while ( true) {
				Utils.pause(1000);
				System.out.println("хехе");
			}
		}

	}

}
