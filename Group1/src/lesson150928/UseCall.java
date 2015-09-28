package lesson150928;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UseCall {
	
	public static void main(String[] args) {
		
//		Call call = new Call();
//		call.city = "Moscow";
//		call.time = new Time();
		
		List<Call> calls = new LinkedList<>();
		
		calls.add(Call.register("Samara", 11, 49));
		calls.add(Call.register("Moscow", 10, 30));
		calls.add(Call.register("Samara", 1, 20));
		calls.add(Call.register("New-York", 2, 00));
		calls.add(Call.register("Minsk", 9, 10));
		calls.add(Call.register("Moscow", 19, 30));
		calls.add(Call.register("Minsk", 23, 40));
		calls.add(Call.register("Vladivostok", 16, 40));
		calls.add(Call.register("Samara", 21, 50));

		Collections.sort(calls);
		
		System.out.println(calls);
		
		Collections.sort(calls, Call.CITY_COMPARATOR);
		
		System.out.println(calls);
	}

}
