package lesson150922;

import java.util.ArrayDeque;

public class Restriction {
	
	static class MyStack extends ArrayDeque {
		
		@Override
		public void push(Object e) {
			addLast(e);
		}
		
		@Override
		public Object pop() {
			return removeLast();
		}
		
		@Override
		public void addFirst(Object e) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public Object removeFirst() {
			throw new UnsupportedOperationException();
		}
		
	}

}
