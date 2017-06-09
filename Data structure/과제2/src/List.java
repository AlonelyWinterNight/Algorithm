class List {
	private static class Node {
		private String name;
		private int seatNumber;
		private String seatSign;
		private boolean isReserved; // ������ �ƴ��� �Ǵ�.
		private Node next;

		public Node(String name, int number, String sign, Boolean tf, Node next) {
			this.name = name;
			this.seatNumber = number; // �¼� �� ��ȣ
			this.seatSign = sign; // �¼� ��ȣ
			this.isReserved = tf;
			this.next = next;
		}

		public Node(String name, int number, String sign, Boolean tf) {
			this(name, number, sign, tf, null);
		}
	}

	private Node head;

	public boolean insert(String name, int number, String sign, Boolean tf) {
		if (head == null) {
			head = new Node(name, number, sign, tf);
			return true;
		} else {
			Node prev = null;
			Node curr = head;
			while (curr != null) {
				if (curr.seatSign.equals(sign)) {
					if (curr.isReserved == true) { // ����� �¼��̸� ����.
						if (curr.name.equals(name)) { // ����� �̸��̸� ����.
							return false;
						} else {
							System.out.println("That seat is not available !");
							return false;
						}
					} else {
						curr.name = name;
						curr.seatNumber = number;
						curr.isReserved = true; // ���� ��Ű�� ����.
					}
					return true;
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
			Node newNode = new Node(name, number, sign, tf);
			newNode.next = curr;
			if (prev == null) {
				head = newNode;
			} else {
				prev.next = newNode;
			}
			return true;
		}
	}

	public void printList() { // ���� ���� ���
		Node scan = head;
		while (scan != null) {
			if (scan.isReserved == true) { // �ڸ��� �������� * ǥ��
				System.out.print(" " + "*");
			} else {
				System.out.print(" " + scan.seatSign);
			}
			scan = scan.next;
		}
	}

	public boolean cancel(String name) {
		Node scan = head;
		while (scan != null) {
			if (scan.name.equals(name)) {
				scan.name = "";
				scan.isReserved = false; // ���� ��ҽ�Ű�� ����.
				return true;
			} else {
				scan = scan.next;
			}
		}
		return false;
	}

	public boolean find(String name) { // cancel�� �����ϰ� ����
		Node scan = head;
		while (scan != null) {
			if (scan.name.equals(name)) {
				System.out.println("seatSign number : " + scan.seatNumber + scan.seatSign);
				return true;
			} else {
				scan = scan.next;
			}
		}
		return false;
	}

	public void info() {
		Node scan = head;
		while (scan != null) {
			if (scan.isReserved == true) {
				System.out.println(scan.name + "\t" + scan.seatNumber + scan.seatSign);
				scan = scan.next;
			} else {
				scan = scan.next;
			}
		}
	}
}
