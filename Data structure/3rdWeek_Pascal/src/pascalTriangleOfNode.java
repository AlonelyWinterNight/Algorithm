public class pascalTriangleOfNode {
	public static final int ROW = 12;
	public static void main(String[] args) {
		Node[] pascal = new Node[ROW];

		// pascal[i] Node���� i+1���� Node�� �����ؾ���. ���ÿ� ���� �־��ָ� ��.
		// ����� ����(this.next) = ���ο� ���
		// ����� ��(this.item) = �ٷ� �� ���� ���� ����� ��.
		// �ٷ� �� ����� ���� ��带 prev�� �ϸ�, �ٷ� �� ���� prev.next.
		// prev.next�� null�϶� �׳� 0�� �����ָ� ��.
		Node prev = null;
		Node curr = null;
		for (int i = 0; i < ROW; i++) {
			if (i > 0) { // �ٷ� �� ���� ��� ������ �����ϱ� ���� Node ��ü prev
				prev = pascal[i - 1]; // �ٷ� ���� ����� �� �� ��带 ����Ŵ
			}
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) { // �� ���� ù ���. ù ���Ҵ� 1�� ����
					Node newNode = new Node(1);
					pascal[i] = newNode;
					curr = pascal[i];
				} else if (j < i) { // �� ���� ó���� ���� ������ �߰� ����.
					Node newNode = new Node(prev.item + prev.next.item);
					curr.next = newNode;
					prev = prev.next;
					curr = curr.next;
				} else { // �� ���� ������ ���.
					Node newNode = new Node(prev.item + 0);
					curr.next = newNode;
				}
			}
		}

		for (int i = 0; i < ROW; i++) { // ��ºκ�
			Node scan = pascal[i];
			while (scan != null) {
				System.out.print(scan.item + " ");
				scan = scan.next;
			}
			System.out.println();
		}
	}
}
