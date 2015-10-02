package lesson151001;

import java.util.Iterator;

public class UseList {
	
	public static void main(String[] args) {
		
		MyList<String> list = new MyList<String>() {{
			add("one");
			add("two");
			add("three");
		}};
		
		for (String item : list) {
			System.out.println(item);
		}
		
		Iterator<String> it = list.iterator();
		
		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}
		
		Iterator<String> it1 = list.iterator();
		System.out.println(it1.next());
		System.out.println(it1.next());
		
		Iterator<String> it2 = list.iterator();

		System.out.println(it1.next());
		
	}
	
}
