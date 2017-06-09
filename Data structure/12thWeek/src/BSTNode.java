class BSTNode {
	public int item;
	public BSTNode left;
	public BSTNode right;

	public BSTNode(int item) {
		this.item = item;
		left = null;
		right = null;
	}

	public BSTNode(int item, BSTNode left, BSTNode right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}
}
