package lesson151001;

import java.util.Iterator;

public class MyList<T> implements Iterable<T>{
	
	private class Node {
		T data;
		Node next;
	}

	
	Node first;
	Node current;
	
	public void add(T data) {
		Node node = new Node();
		node.data = data;
		node.next = first;
		first = node;
	}
	
	@Override
	public String toString() {
		
		String s = "[";
		
		Node temp = first;
		
		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}
		
		return s + "]";
	}

	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {
			Node current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T data = current.data;
				current = current.next;
				return data;
			}

			@Override
			public void remove() {}

		};
		
	}

}
