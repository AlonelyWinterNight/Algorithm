public class Node {
	public int item;
	public Node next;

	public Node(int item, Node next) { // 持失切
		this.item = item;
		this.next = next;
	}

	public Node(int item) { // 持失切
		this(item, null);
	}
}
