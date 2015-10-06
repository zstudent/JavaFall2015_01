package lesson151006;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class IOStreams {
	
	static class B implements Serializable {
		
	}
	
	static class A implements Serializable {

		private static final long serialVersionUID = 1L;
		
		String x = "Hello";
		B b = new B();
		
	}
	
	public static void main(String[] args) {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte[] byteArray = new byte[0];

		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			
			A a = new A();
			
			oos.writeObject(a);
			
			byteArray = baos.toByteArray();
			
			System.out.println(Arrays.toString(byteArray));
			System.out.println(byteArray.length);
			
			for (byte b : byteArray) {
				char c = (char) b;
				System.out.print(c);
			}
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		
		try {
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			A a = (A) ois.readObject();
			
			System.out.println(a.x);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		
		
		
		
		
		
		
		
		
		
	}

}
