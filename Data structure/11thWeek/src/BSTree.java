class BSTree<T extends Comparable<T>> {
	private BSTNode<T> root;
	private boolean insertSuccess;
	private boolean removeSuccess;
	private boolean success;

	public BSTree() {
		root = null;
	} // ������

	public boolean insert(T data) { // �ݺ����� ������� ����.
		BSTNode<T> newNode = new BSTNode<T>(data);
		if (root == null) {
			root = newNode;
			return true;
		} else {
			BSTNode<T> prev = null;
			BSTNode<T> curr = root;
			while (curr != null) {
				prev = curr;
				if (data.compareTo(curr.item) < 0) { // ���� ��. ����.
					curr = curr.left;
				} else if (data.compareTo(curr.item) > 0) { // ū ��. ������.
					curr = curr.right;
				} else {
					return false;
				}
			}
			if (prev.item.compareTo(data) > 0) {
				prev.left = newNode;
			} else {
				prev.right = newNode;
			}
			return true;
		}
	}

	public boolean insertByRecursion(T data) {
		insertSuccess = false;
		root = insertByRecursion(root, data);
		return insertSuccess;// ������� ������� ����
	}

	public BSTNode<T> insertByRecursion(BSTNode<T> tree, T data) {
		if (tree == null) { // �� ������ ����.
			insertSuccess = true;
			tree = new BSTNode<T>(data);
		} else if (data.compareTo(tree.item) < 0) { // ���� ��. ��������.
			tree.left = insertByRecursion(tree.left, data);
		} else if (data.compareTo(tree.item) > 0) { // ū ��. ����������.
			tree.right = insertByRecursion(tree.right, data);
		} else {
			insertSuccess = false;
		}
		return tree;
	}

	public boolean remove(T data) {// �ݺ����� ������� ����
		if (root == null) {
			return false;
		} else {
			BSTNode<T> prev = null;
			BSTNode<T> curr = root;
			while (curr != null) {
				if (data.compareTo(curr.item) < 0) { // ���� ��. ����.
					prev = curr;
					curr = curr.left;
				} else if (data.compareTo(curr.item) > 0) { // ū ��. ������.
					prev = curr;
					curr = curr.right;
				} else { // ������ ��带 ã��.
					if (prev == null) { // root�� ������ ��. ��, root�� �ٲ� ��.
						BSTNode<T> maxNode = null;
						if (curr.left != null) {
							maxNode = curr.left;
							if (maxNode.right != null) {
								prev = maxNode;
								while (maxNode.right != null) {
									prev = maxNode;
									maxNode = maxNode.right;
								}
								prev.right = null;
							} else {
								curr.left = maxNode.left;
							}
							curr.item = maxNode.item;
						} else {
							curr = curr.right;
							root = curr;
						}
					} else if (curr.equals(prev.left)) {// ���� ����� ����.
						if (curr.left == null) {
							prev.left = curr.right;
						} else if (curr.right == null) {
							prev.left = curr.left;
						} else { // �� �� �ְų� ���� ��.
							BSTNode<T> maxNode = curr.left;
							while (maxNode.right != null) {
								maxNode = maxNode.right;
							}
							maxNode.right = curr.right;
							prev.left = maxNode;
						}
					} else {// ������.
						if (curr.left == null) {
							prev.right = curr.right;
						} else if (curr.right == null) {
							prev.right = curr.left;
						} else { // �� �� �ְų� ���� ��.
							BSTNode<T> maxNode = curr.left;
							while (maxNode.right != null) {
								maxNode = maxNode.right;
							}
							maxNode.right = curr.right;
							prev.right = maxNode;
						}
					}
					return true; // ���� ����.
				}
			}
			return false; // ������ ����� ����. ����.
		}
	}

	public boolean removeByRecursion(T data) {// ������� ������� ����
		removeSuccess = true;
		root = removeByRecursion(root, data);
		return removeSuccess;
	}

	public BSTNode<T> removeByRecursion(BSTNode<T> tree, T data) {
		if (tree == null) {
			removeSuccess = false;
		} else if (data.compareTo(tree.item) < 0) {
			tree.left = removeByRecursion(tree.left, data);
		} else if (data.compareTo(tree.item) > 0) {
			tree.right = removeByRecursion(tree.right, data);
		} else { // Ž�� �Ϸ�.
			removeSuccess = true;
			if (tree.left == null) {
				tree = tree.right;
			} else if (tree.right == null) {
				tree = tree.left;
			} else {
				BSTNode<T> maxNode = tree.left;
				while (maxNode.right != null) {
					maxNode = maxNode.right;
				}
				tree.item = maxNode.item;
				tree.left = removeByRecursion(tree.left, maxNode.item);
			}
		}
		return tree;
	}

	public boolean search(T data) { // �ݺ����� ������� Ž��
		if (root == null) {
			return false;
		} else {
			BSTNode<T> curr = root;
			while (curr != null) {
				if (data.compareTo(curr.item) < 0) { // ���� ��. ����.
					curr = curr.left;
				} else if (data.compareTo(curr.item) > 0) { // ū ��. ������.
					curr = curr.right;
				} else {
					return true; // ��带 ã��.
				}
			}
			return false;// ������ �����Դµ��� ��ã�Ҵٸ� ���°��̹Ƿ�
		}
	}

	public boolean searchByRecursion(T data) {// ������� ������� Ž��
		success = false;
		if (root == null) {
			return false;
		} else {
			success = searchByRecursion(root, data);
		}
		return success;
	}

	public boolean searchByRecursion(BSTNode<T> tree, T data) {
		if (tree == null) {
			return false;
		} else if (data.compareTo(tree.item) < 0) {
			success = searchByRecursion(tree.left, data);
		} else if (data.compareTo(tree.item) > 0) {
			success = searchByRecursion(tree.right, data);
		} else { // Ž�� �Ϸ�.
			success = true;
		}
		return success;
	}

	public void inorderTraverse() { // ���� ��ȸ
		inorderTraverse(root);
		System.out.println();
	}

	public void inorderTraverse(BSTNode<T> tree) {
		if (tree != null) {
			inorderTraverse(tree.left);
			System.out.print(tree.item.toString() + " ");
			inorderTraverse(tree.right);
		}
	}

	public void print() {// Ʈ���� ������ �� �� �ֵ��� ���
		print(root, 0);
		System.out.println();
	}

	public void print(BSTNode<T> tree, int level) {
		if (tree != null) {
			print(tree.right, level + 1); // R
			for (int i = 0; i < level; i++) {
				System.out.print("\t");
			}
			// if has left / right / both ���� L,R ���̱�.
			StringBuilder str = new StringBuilder();
			str.append(tree.item.toString());
			if (tree.left != null && tree.right != null) {
				str.append(",L,R ");
			} else if (tree.left != null) {
				str.append(",L ");
			} else if (tree.right != null) {
				str.append(",R ");
			}
			System.out.print(str + "\n"); // V
			print(tree.left, level + 1); // L
		}
	}
}
