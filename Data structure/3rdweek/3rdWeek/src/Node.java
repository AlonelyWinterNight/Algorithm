public class Node {
	public int index;
	public int value;
	public Node next;

	public Node(int index, int value) { // »ý¼ºÀÚ
		this.index = index;
		this.value = value;
		next = null;
	}

	public Node() {
		next = null;
	}
}
