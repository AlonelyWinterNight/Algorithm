class List {
	private static class Node {
		private double item;
		private Node next;

		public Node(double item, Node next) {
			this.item = item;
			this.next = next;
		}

		public Node(double item) {
			this(item, null);
		}

		public String toString() {
			return Double.toString(item);
		}
	}

	private Node head;

	public void insertLast(double item) {
		if (head == null) {
			head = new Node(item);
		} else {
			Node prev = null;
			Node curr = head;
			while (curr != null) {
				prev = curr;
				curr = curr.next;
			}
			Node newNode = new Node(item);
			newNode.next = curr;
			if (prev == null) {
				head = newNode;
			} else {
				prev.next = newNode;
			}
		}
	}

	public void insertInSortedOrder(double item) {
		if (head == null) {
			head = new Node(item);
		} else {
			Node prev = null;
			Node curr = head;
			while (curr != null) {
				if (curr.item >= item) {
					break;
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
			Node newNode = new Node(item);
			newNode.next = curr;
			if (prev == null) {
				head = newNode;
			} else {
				prev.next = newNode;
			}
		}
	}
	
	public void print() {
		System.out.printf("%-40s", this.toString());
		System.out.printf("Æò±Õ : " + "%-15s", this.computeAverage());
		System.out.printf("ÃÖ´ë : " + "%-15s", this.findMax());
	}

	public String toString() {
		Node scan = head;
		StringBuilder s = new StringBuilder();
		while (scan != null) {
			s.append(scan.toString() + " ");
			scan = scan.next;
		}
		return s.toString();
	}
	
	public double computeAverage() {
		Node scan = head;
		double result = 0.0;
		int i = 0;
		while (scan != null) {
			result += scan.item;
			scan = scan.next;
			i++;
		}
		result = Math.round((result / i) * 100) / 100.0;
		return result;
	}

	public double findMax() {
		Node scan = head;
		double result = 0.0;
		result = scan.item;
		while (scan != null) {
			if (scan.item > result) {
				result = scan.item;
				scan = scan.next;
			} else {
				scan = scan.next;
			}
		}
		return result;
	}
}
