package lesson150928;

import java.util.Comparator;

public class Call implements Comparable<Call>{
	
	
	static class CityComparator implements Comparator<Call> {

		@Override
		public int compare(Call o1, Call o2) {
			return o1.city.compareTo(o2.city);
		}
		
	}
	
	public static final Comparator<Call> CITY_COMPARATOR = new CityComparator();
	
	private Call() {};
	
	public static Call register(String city, int hour, int minutes) {
		Call call = new Call();
		call.city = city;
		call.time = new Time();
		call.time.hour = hour;
		call.time.minutes = minutes;
		return call;
	}
	
	private static class Time {
		int hour;
		int minutes;
	}
	
	String city;
	Time time;
	
	@Override
	public String toString() {
		return city + ", " + time.hour + ":" + time.minutes;
	}

	@Override
	public int compareTo(Call other) {
		int hourDiff = this.time.hour - other.time.hour;
		if (hourDiff != 0 ) {
			return hourDiff;
		}

		return this.time.minutes - other.time.minutes;
	}

}
