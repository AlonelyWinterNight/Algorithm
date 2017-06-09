class Node {
	public int row;
	public int col;
	public int value;
	public Node nextRow;
	public Node nextCol;

	public Node(int row, int col, int value) {
		this.row = row;
		this.col = col;
		this.value = value;
		nextRow = null;
		nextCol = null;
	}
}