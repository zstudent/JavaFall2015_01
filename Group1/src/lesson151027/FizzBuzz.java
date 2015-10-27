package lesson151027;

public class FizzBuzz {

	public String check(int i) {
		String result = "";
		if (i % 3 == 0) {
			result += "fizz";
		}
		if (i % 5 == 0) {
			result += "buzz";
		}
		return result.length() == 0 ? String.valueOf(i) : result;
	}

}
