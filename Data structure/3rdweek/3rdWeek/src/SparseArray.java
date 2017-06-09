public class SparseArray {
	private Node head; // ���� ����Ʈ�� ���
	private int size; // �迭�� ũ��

	public SparseArray(int size) { // ������
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
					curr.value = value; // index�� ������ ū ������ ����
					return;
				} else {
					prev = curr; // �ϳ��� �������� ����.
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
