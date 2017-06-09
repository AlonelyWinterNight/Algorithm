public class pascalTriangleOfNode {
	public static final int ROW = 12;
	public static void main(String[] args) {
		Node[] pascal = new Node[ROW];

		// pascal[i] Node에는 i+1개의 Node를 연결해야함. 동시에 값도 넣어주면 됨.
		// 노드의 다음(this.next) = 새로운 노드
		// 노드의 값(this.item) = 바로 위 노드와 왼쪽 노드의 합.
		// 바로 위 노드의 왼쪽 노드를 prev라 하면, 바로 위 노드는 prev.next.
		// prev.next가 null일땐 그냥 0을 더해주면 됨.
		Node prev = null;
		Node curr = null;
		for (int i = 0; i < ROW; i++) {
			if (i > 0) { // 바로 윗 행의 노드 정보를 참조하기 위한 Node 객체 prev
				prev = pascal[i - 1]; // 바로 왼쪽 노드의 윗 행 노드를 가리킴
			}
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) { // 각 행의 첫 노드. 첫 원소는 1로 셋팅
					Node newNode = new Node(1);
					pascal[i] = newNode;
					curr = pascal[i];
				} else if (j < i) { // 각 행의 처음과 끝을 제외한 중간 노드들.
					Node newNode = new Node(prev.item + prev.next.item);
					curr.next = newNode;
					prev = prev.next;
					curr = curr.next;
				} else { // 각 행의 마지막 노드.
					Node newNode = new Node(prev.item + 0);
					curr.next = newNode;
				}
			}
		}

		for (int i = 0; i < ROW; i++) { // 출력부분
			Node scan = pascal[i];
			while (scan != null) {
				System.out.print(scan.item + " ");
				scan = scan.next;
			}
			System.out.println();
		}
	}
}
