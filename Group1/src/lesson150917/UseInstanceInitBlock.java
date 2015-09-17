package lesson150917;

import java.util.ArrayList;
import java.util.List;

public class UseInstanceInitBlock {

	public static void main(String[] args) {
		
		String[] words = {"one", "two", "three"};
		
		List<String> wordList = new ArrayList<>();
		wordList.add("one");
		wordList.add("two");
		wordList.add("three");

		List<String> wordList2 = new ArrayList<String>() {{
				add("one");
				add("two");
				add("three");
			}};
		
		
		
	}
	
}
