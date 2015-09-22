package lesson150922;

public class LiskovSubstitutionPrinciple {
	
	public static void main(String[] args) {
		
		Object o = new String("Hello");
		
		System.out.println(o.toString());
		System.out.println(o.hashCode());
		
		o = new Object();
		
		System.out.println(o.toString());
		System.out.println(o.hashCode());
		
	}

}
