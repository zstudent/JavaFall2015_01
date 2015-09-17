package lesson150915;

import java.util.Date;

public class PassLinkByValue {

	public static void main(String[] args) {
		
		Date date = new Date();
		
		System.out.println(date.getDate());
		
		process(date);
		
		System.out.println(date.getDate());
		
	}

	private static void process(Date date) {
		date.setDate(12);
	}
	
}
