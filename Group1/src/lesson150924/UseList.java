package lesson150924;

public class UseList {

	public static void main(String[] args) {
	
		MyList<String> list = new MyList<>();
		
		list.add("One");
		list.add("Two");
		list.add("Three");
//		list.add(10); ERROR!
		
		System.out.println(list);
	}
	
}
