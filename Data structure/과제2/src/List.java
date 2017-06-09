class List {
	private static class Node {
		private String name;
		private int seatNumber;
		private String seatSign;
		private boolean isReserved; // 예약이 됐는지 판단.
		private Node next;

		public Node(String name, int number, String sign, Boolean tf, Node next) {
			this.name = name;
			this.seatNumber = number; // 좌석 행 번호
			this.seatSign = sign; // 좌석 기호
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
					if (curr.isReserved == true) { // 예약된 좌석이면 종료.
						if (curr.name.equals(name)) { // 예약된 이름이면 종료.
							return false;
						} else {
							System.out.println("That seat is not available !");
							return false;
						}
					} else {
						curr.name = name;
						curr.seatNumber = number;
						curr.isReserved = true; // 예약 시키고 종료.
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

	public void printList() { // 예약 정보 출력
		Node scan = head;
		while (scan != null) {
			if (scan.isReserved == true) { // 자리가 차있으면 * 표시
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
				scan.isReserved = false; // 예약 취소시키고 종료.
				return true;
			} else {
				scan = scan.next;
			}
		}
		return false;
	}

	public boolean find(String name) { // cancel과 유사하게 동작
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
