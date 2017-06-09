class UnsortedLinkedList<T extends Comparable<T>> {
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

		private Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node<T> head = null;
	private int size;
	boolean success = false;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void clear() {
		head = null;
		size = 0;
	}

	public void print() { // 재귀로 순방향 출력 구현.
		print(head);
		System.out.println();
	}

	private void print(Node<T> node) {
		if (node != null) {
			System.out.print(node.item + " ");
			print(node.next);
		}
	}

	public void insertFirst(T item) { // 맨 앞 삽입.
		head = new Node<T>(item, head);
		size++;
	}

	/******** 구현해야 할 메소드 ********/
	public T getNthItem(int nth) {
		return getNthItem(head, nth);
	}

	private T getNthItem(Node<T> node, int nth) {
		if (nth == 1)
			return node.item;
		return getNthItem(node.next, nth - 1);
	}

	public boolean search(T item) {
		Node<T> scan = head;
		if (item.compareTo(scan.item) == 0) {
			success = true;
		} else if (scan.next != null) {
			scan = scan.next;
			success = search(scan, item);
		}
		return success;
	}

	public boolean search(Node<T> scan, T item) {
		if (item.compareTo(scan.item) == 0) {
			return true;
		} else if (scan.next != null) {
			scan = scan.next;
			search(scan, item);
		}
		return false;
	}

	public void insertLast(T item) {
		Node<T> scan = head;
		if (head == null) {
			head = new Node<T>(item);
			size++;
		} else if (scan.next == null) {
			scan.next = new Node<T>(item);
			size++;
		} else {
			scan = scan.next;
			insertLast(scan, item);
		}
	}

	public void insertLast(Node<T> scan, T item) {
		if (scan.next != null) {
			scan = scan.next;
			insertLast(scan, item);
		} else {
			scan.next = new Node<T>(item);
			size++;
		}
	}

	public boolean removeFirst(T item) {
		success = false;
		Node<T> prev = null;
		success = removeFirst(prev, head, item);
		return success;
	}

	public boolean removeFirst(Node<T> prev, Node<T> node, T item) {
		if (item.compareTo(node.item) == 0) { // 찾았을 때, 삭제 진행.
			if (prev == null) { // 맨 앞 삭제.
				head = head.next;
			} else { // 중간, 맨 끝 삭제.
				prev.next = node.next;
			}
			success = true;
			size--;
		} else if (node.next != null) { // 못찾았을때, 다음으로 진행.
			prev = node;
			node = node.next;
			success = removeFirst(prev, node, item);
		}
		return success;
	}

	public boolean removeAll(T item) {
		success = false;
		Node<T> prev = null;
		success = removeAll(prev, head, item);
		return success;
	}

	public boolean removeAll(Node<T> prev, Node<T> node, T item) {
		if (item.compareTo(node.item) == 0) { // 찾았을 때 , 삭제 진행.
			if (prev == null) { // 첫번째일 때.
				head = head.next;
			} else { // 중간, 끝일 때
				prev.next = node.next;
			}
			success = true;
			size--;
			if (node.next != null) { // 찾았어도 다음으로 진행.
				if (prev == null) { // 첫번째를 삭제했을 때 prev는 여전히 null이므로.
					prev = null;
				}
				node = node.next;
				success = removeAll(prev, node, item);
			}
		} else if (node.next != null) { // 못찾았을 때, 다음으로 진행.
			prev = node;
			node = node.next;
			success = removeAll(prev, node, item);
		}
		return success;
	}

	public void reversePrint() { // 역방향 출력 재귀로 구현.
		reversePrint(head);
		System.out.println();
	}

	public void reversePrint(Node<T> node) {
		if (node != null) {
			reversePrint(node.next);
			System.out.print(node.item + " ");
		}
	}

	public UnsortedLinkedList<T> copy() {
		Node<T> scan = head;
		UnsortedLinkedList<T> temp = new UnsortedLinkedList<T>();
		if (scan != null) {
			temp.insertLast(scan.item);
			if (scan.next != null) {
				copy(scan.next, temp);
			}
		}
		return temp;
	}

	public UnsortedLinkedList<T> copy(Node<T> scan, UnsortedLinkedList<T> temp) {
		if (scan != null) {
			temp.insertLast(scan.item);
			if (scan.next != null) {
				copy(scan.next, temp);
			}
		}
		return temp;
	}
}
