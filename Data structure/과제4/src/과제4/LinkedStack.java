package 과제4;

public class LinkedStack<T> implements Stack<T> {
	private class Node<T> {
		private T item;
		private Node<T> next;

		public Node(T item) {
			this.item = item;
			next = null;
		}
	}

	private Node<T> head;
	private Node<T> scan;
	private int size;

	public LinkedStack() {
		head = null;
		scan = null;
		size = 0;
	}

	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new java.util.EmptyStackException();
		} else {
			scan = head;
			head = head.next;
		}
		size--;
		return scan.item;
	}

	public T peek() {
		if (isEmpty()) {
			throw new java.util.EmptyStackException();
		} else {
			return head.item;// 가장 위, 즉 첫번째 값 return.
		}
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		scan = head;
		while (scan != null) {
			if (scan.next != null)
				s.insert(0, ", " + scan.item); // 맨 앞에 붙이기.
			else
				s.insert(0, scan.item);
			scan = scan.next;
		}
		return s.toString();
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
