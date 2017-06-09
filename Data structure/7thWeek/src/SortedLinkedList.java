class SortedLinkedList<T extends Comparable<T>> implements List<T> {
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
	}

	private Node<T> head;
	private Node<T> scanPos;
	private int size;

	public SortedLinkedList() {
		head = null;
		size = 0;
		scanPos = null;
	}

	public void insert(T item) {
		Node<T> prev = null;
		Node<T> curr = head;
		Node<T> newNode = new Node<T>(item);
		while(curr!=null){
			if(curr.item.compareTo(item)<0){
				prev = curr;
				curr = curr.next;
			}else
				break;
		}
		if(head == null)
			head = newNode;
		else if(prev ==null){
			newNode.next = head;
			head = newNode;
		}else{
			newNode.next = curr;
			prev.next = newNode;
		}size++;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void clear(){
		head = null;
		size =0;
	}

	public int size() {
		return size;
	}

	public void reset() {
		scanPos = head;
	}

	public boolean hasNext() {
		return scanPos!=null;
	}

	public T next() {
		T item = scanPos.item;
		scanPos = scanPos.next;
		return item;
	}
	
	public String toString(){
		Node<T> scan = head;
		StringBuilder str = new StringBuilder();
		while(scan!=null){
			str.append(scan.item.toString()+"\n");
			scan = scan.next;
		}
		return str.toString();
	}
}
