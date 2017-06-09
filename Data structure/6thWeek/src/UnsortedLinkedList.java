class UnsortedLinkedList<T> implements List<T> {
	private static class Node<T> {
		private T item;
		private Node<T> next;

		private Node() {
			next = null;
		}

		private Node(T item) {
			this.item = item;
			next = null;
		}
	}

	private Node<T> head;
	private Node<T> scanPos;
	private int size;

	public UnsortedLinkedList() {
		head = null;
		size = 0;
		scanPos = null;
	}

	public boolean isEmpty() {
		return size == 0; // if(size == 0) { return true; }
	}

	public int size() {
		return size;
	}

	public void insert(T item) {
		Node<T> newNode = new Node<T>(item);
		if (head == null) { // 아무것도 없으면
			head = newNode; // head는 newNode를 가리킴
		} else {
			newNode.next = head; // 있긴 하면 맨앞에 삽입하고
			head = newNode; // head 위치를 옮김.
		}
		size++;
	}

	public String toString() {
		Node<T> scan = head;
		StringBuilder str = new StringBuilder();
		while (scan != null) {
			str.append(scan.item + " ");
			scan = scan.next;
		}
		return str.toString();
	}

	public boolean remove(T item) {
		if (isEmpty())
			return false;
		else {
			Node<T> prev = null;
			Node<T> curr = head;
			while (curr != null) {
				if (curr.item.equals(item)) {
					break;
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
			if (curr == null) {
				return false;
			} else if (prev == null) { // 맨 앞 삭제.
				head = head.next;
			} else { // 중간,맨끝 삭제.
				prev.next = curr.next;
			}
			size--;
			return true;
		}
	}

	public boolean search(T item) {
		if (isEmpty())
			throw new java.util.NoSuchElementException("search(): list empty");
		Node<T> scan = head;
		while (scan != null) {
			if (scan.item.equals(item))
				return true;
			else
				scan = scan.next;
		}
		return false;
	}

	public void reset() {
		scanPos = head;
	}

	public boolean hasNext() {
		return scanPos != null;
	}

	public T next() {
		T item = scanPos.item;
		scanPos = scanPos.next;
		return item;
	}

	public void insert(int num, T item) {// num번째 앞에 삽입.
		Node<T> scan = head;
		Node<T> prev = null;
		Node<T> newNode = new Node<T>(item);
		for (int i = 0; i < num - 1; i++) {
			prev = scan;
			scan = scan.next;
		}
		size++;
		prev.next = newNode;
		newNode.next = scan;
	}

	public void removeAll(T item) { // 모든 item 값을 list에서 찾아 삭제.
		Node<T> scan = head;
		while (scan != null) {
			remove(item);
			scan = scan.next;
		}
	}

	public void append(T item) {
		Node<T> newNode = new Node<T>(item);
		Node<T> scan = head;
		while (scan.next != null) {
			scan = scan.next;
		}
		scan.next = newNode;
		size++;
	}

	public T retrieve(int num) { // num 번째 값을 찾아서 반환.
		T found;
		Node<T> scan = head;
		for (int i = 0; i < num - 1; i++) {
			scan = scan.next;
		}
		found = (T) scan.item;
		return found;
	}
}
