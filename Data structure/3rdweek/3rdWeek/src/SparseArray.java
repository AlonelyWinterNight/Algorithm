public class SparseArray {
	private Node head; // 연결 리스트의 헤드
	private int size; // 배열의 크기

	public SparseArray(int size) { // 생성자
		this.size = size;
		head = null;
	}

	public void set(int index, int value) {
		if (head == null) {
			head = new Node(index, value);
		} else {
			Node prev = null;
			Node curr = head;
			while (curr != null) {
				if (curr.index > index) {
					break;
				} else if (curr.index == index) {
					curr.value = value; // index가 같을때 큰 값으로 갱신
					return;
				} else {
					prev = curr; // 하나씩 다음으로 진행.
					curr = curr.next;
				}
			}
			Node newNode = new Node(index, value);
			newNode.next = curr;
			if (prev == null) {
				head = newNode;
			} else {
				prev.next = newNode;
			}
		}
	}

	public void print() {
		Node scan = head;
		for (int i = 0; i < size; i++) {
			if (scan != null && i == scan.index) {
				System.out.println("[" + scan.index + "]" + scan.value);
				scan = scan.next;
			} else {
				System.out.println("[" + i + "]" + " " + 0 + " ");
			}
		}
	}
}
