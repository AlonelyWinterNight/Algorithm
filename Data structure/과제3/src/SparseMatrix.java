class SparseMatrix {
	private Node[] rows;
	private Node[] cols;

	private Node prev;
	private Node curr;

	public SparseMatrix(int row, int col) { // »ý¼ºÀÚ
		rows = new Node[row];
		cols = new Node[col];
	}

	public void insert(int row, int col, Node node) {
		curr = node;
		if (rows[row] == null) {
			rows[row] = curr;
		} else {
			prev = rows[row];
			while (prev.nextCol != null) {
				prev = prev.nextCol;
			}
			prev.nextCol = curr;
		}
		if (cols[col] == null) {
			cols[col] = curr;
		} else {
			prev = cols[col];
			while (prev.nextRow != null) {
				prev = prev.nextRow;
			}
			prev.nextRow = curr;
		}
	}

	public void printMatrix() {
		System.out.print(String.format("%4s", ""));
		for (int i = 0; i < cols.length; i++) {
			System.out.print(String.format("%4s", "[" + i + "]"));
		}
		System.out.println();
		for (int i = 0; i < rows.length; i++) {
			System.out.print("[" + i + "]");
			curr = rows[i];
			for (int j = 0; j < cols.length; j++) {
				int tempValue = findNode(i, j);
				if (tempValue > 0) {
					System.out.print(String.format("%4d", tempValue));
				} else {
					System.out.print(String.format("%4s", "0"));
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public int findNode(int row, int col) {
		Node scan = null;
		for (int i = 0; i < rows.length; i++) {
			scan = rows[i];
			while (scan != null) {
				if (scan.col == col && scan.row == row) {
					return scan.value;
				} else {
					scan = scan.nextCol;
				}
			}
		}
		return -1;
	}

	public void multiplyMatrix(SparseMatrix m1, SparseMatrix m2) {
		SparseMatrix multiplied = new SparseMatrix(m1.getRowLength(), m2.getColLength());
		for (int i = 0; i < multiplied.getRowLength(); i++) {
			int temp = 0;
			prev = m1.rows[i];
			curr = m2.cols[i];
			for (int j = 0; j < multiplied.getColLength(); j++) {
				while (prev != null && curr != null) {
					if (prev != null && curr != null) {
						temp += prev.value * curr.value;
						prev = prev.nextCol;
						curr = curr.nextRow;
					} else {
						temp += 0;
					}
				}
				Node newNode = new Node(i, j, temp);
				multiplied.insert(i, j, newNode);
			}
		}
		multiplied.printMatrix();
	}

	public int getRowLength() {
		return rows.length;
	}

	public int getColLength() {
		return cols.length;
	}
}