class BSTree<T extends Comparable<T>> {
	private BSTNode<T> root;
	private boolean insertSuccess;
	private boolean removeSuccess;
	private boolean success;

	public BSTree() {
		root = null;
	} // 생성자

	public boolean insert(T data) { // 반복적인 방법으로 삽입.
		BSTNode<T> newNode = new BSTNode<T>(data);
		if (root == null) {
			root = newNode;
			return true;
		} else {
			BSTNode<T> prev = null;
			BSTNode<T> curr = root;
			while (curr != null) {
				prev = curr;
				if (data.compareTo(curr.item) < 0) { // 작은 값. 왼쪽.
					curr = curr.left;
				} else if (data.compareTo(curr.item) > 0) { // 큰 값. 오른쪽.
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
		return insertSuccess;// 재귀적인 방법으로 삽입
	}

	public BSTNode<T> insertByRecursion(BSTNode<T> tree, T data) {
		if (tree == null) { // 맨 끝에서 삽입.
			insertSuccess = true;
			tree = new BSTNode<T>(data);
		} else if (data.compareTo(tree.item) < 0) { // 작은 값. 왼쪽으로.
			tree.left = insertByRecursion(tree.left, data);
		} else if (data.compareTo(tree.item) > 0) { // 큰 값. 오른쪽으로.
			tree.right = insertByRecursion(tree.right, data);
		} else {
			insertSuccess = false;
		}
		return tree;
	}

	public boolean remove(T data) {// 반복적인 방법으로 삭제
		if (root == null) {
			return false;
		} else {
			BSTNode<T> prev = null;
			BSTNode<T> curr = root;
			while (curr != null) {
				if (data.compareTo(curr.item) < 0) { // 작은 값. 왼쪽.
					prev = curr;
					curr = curr.left;
				} else if (data.compareTo(curr.item) > 0) { // 큰 값. 오른쪽.
					prev = curr;
					curr = curr.right;
				} else { // 삭제할 노드를 찾음.
					if (prev == null) { // root를 삭제할 때. 즉, root가 바뀔 때.
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
					} else if (curr.equals(prev.left)) {// 삭제 대상이 왼쪽.
						if (curr.left == null) {
							prev.left = curr.right;
						} else if (curr.right == null) {
							prev.left = curr.left;
						} else { // 둘 다 있거나 없을 때.
							BSTNode<T> maxNode = curr.left;
							while (maxNode.right != null) {
								maxNode = maxNode.right;
							}
							maxNode.right = curr.right;
							prev.left = maxNode;
						}
					} else {// 오른쪽.
						if (curr.left == null) {
							prev.right = curr.right;
						} else if (curr.right == null) {
							prev.right = curr.left;
						} else { // 둘 다 있거나 없을 때.
							BSTNode<T> maxNode = curr.left;
							while (maxNode.right != null) {
								maxNode = maxNode.right;
							}
							maxNode.right = curr.right;
							prev.right = maxNode;
						}
					}
					return true; // 삭제 성공.
				}
			}
			return false; // 삭제할 대상이 없음. 실패.
		}
	}

	public boolean removeByRecursion(T data) {// 재귀적인 방법으로 삭제
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
		} else { // 탐색 완료.
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

	public boolean search(T data) { // 반복적인 방법으로 탐색
		if (root == null) {
			return false;
		} else {
			BSTNode<T> curr = root;
			while (curr != null) {
				if (data.compareTo(curr.item) < 0) { // 작은 값. 왼쪽.
					curr = curr.left;
				} else if (data.compareTo(curr.item) > 0) { // 큰 값. 오른쪽.
					curr = curr.right;
				} else {
					return true; // 노드를 찾음.
				}
			}
			return false;// 끝까지 내려왔는데도 못찾았다면 없는것이므로
		}
	}

	public boolean searchByRecursion(T data) {// 재귀적인 방법으로 탐색
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
		} else { // 탐색 완료.
			success = true;
		}
		return success;
	}

	public void inorderTraverse() { // 중위 순회
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

	public void print() {// 트리의 구조를 알 수 있도록 출력
		print(root, 0);
		System.out.println();
	}

	public void print(BSTNode<T> tree, int level) {
		if (tree != null) {
			print(tree.right, level + 1); // R
			for (int i = 0; i < level; i++) {
				System.out.print("\t");
			}
			// if has left / right / both 따라 L,R 붙이기.
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
