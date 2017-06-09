class BSTree {
	private BSTNode root;
	private boolean insertSuccess;
	private boolean removeSuccess;
	private boolean hasPath; // 추가한 boolean 변수

	public BSTree() {
		root = null;
	}

	public boolean insert(int data) {
		root = insert(root, data);
		return insertSuccess;
	}

	public BSTNode insert(BSTNode tree, int data) {
		if (tree == null) {
			insertSuccess = true;
			tree = new BSTNode(data);
		} else if (data < tree.item)
			tree.left = insert(tree.left, data);
		else if (data > tree.item)
			tree.right = insert(tree.right, data);
		else
			insertSuccess = false;
		return tree;
	}

	public boolean search(int data) {
		return search(root, data);
	}

	private boolean search(BSTNode tree, int data) {
		if (tree == null)
			return false;
		else if (data < tree.item)
			return search(tree.left, data);
		else if (data > tree.item)
			return search(tree.right, data);
		else
			return true;
	}

	public boolean remove(int data) {
		root = remove(root, data);
		return removeSuccess;
	}

	public BSTNode remove(BSTNode tree, int data) {
		if (tree == null) {
			removeSuccess = false;
		} else if (data < tree.item) {
			tree.left = remove(tree.left, data);
		} else if (data > tree.item) {
			tree.right = remove(tree.right, data);
		} else {
			removeSuccess = true;
			if (tree.left == null) {
				tree = tree.right;
			} else if (tree.right == null) {
				tree = tree.left;
			} else {
				BSTNode maxNode = tree.left;
				while (maxNode.right != null)
					maxNode = maxNode.right;
				tree.item = maxNode.item;
				tree.left = remove(tree.left, maxNode.item);
			}
		}
		return tree;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void print() {
		print(root, 0);
		System.out.println();
	}

	public void print(BSTNode tree, int skip) {
		if (tree != null) {
			print(tree.right, skip + 10);
			for (int i = 0; i < skip; i++)
				System.out.print(" ");
			System.out.print(tree.item);
			if (tree.left != null)
				System.out.print(",L");
			if (tree.right != null)
				System.out.print(",R");
			System.out.println();
			print(tree.left, skip + 10);
		}
	}

	public void inorderTraverse() {
		inorderTraverse(root);
		System.out.println();
	}

	private void inorderTraverse(BSTNode tree) {
		if (tree != null) {
			inorderTraverse(tree.left);
			System.out.print(tree.item + " ");
			inorderTraverse(tree.right);
		}
	}

	public int height() {// 문제 1
		return height(root);
	}

	public int height(BSTNode tree) {
		if(tree==null) return -1;
		else
			return 1+Math.max(height(tree.left), height(tree.right));
	}

	public int countNodes() { // 문제 2
		return countNodes(root);
	}

	public int countNodes(BSTNode tree) {
		if (tree == null) {
			return 0;
		} else {
			return countNodes(tree.left) + countNodes(tree.right) + 1;
		}
	}

	public int countLeaves() { // 문제 3
		int leaves = 0;
		BSTNode scan = root;
		leaves += countLeaves(scan);
		return leaves;
	}

	public int countLeaves(BSTNode tree) {
		int leaves = 0;
		if (tree.left != null && tree.right != null) {
			leaves += countLeaves(tree.left);
			leaves += countLeaves(tree.right);
		} else if (tree.left != null && tree.right == null) {
			leaves += countLeaves(tree.left);
		} else if (tree.right != null && tree.left == null) {
			leaves += countLeaves(tree.right);
		} else {
			leaves += 1;
		}
		return leaves;
	}

	public boolean fullTree() { // 문제 4
		boolean isFullTree = false;
		isFullTree = fullTree(root, root, isFullTree);
		return isFullTree;
	}

	public boolean fullTree(BSTNode leftTree, BSTNode rightTree, boolean isFullTree) {
		if (leftTree != null && rightTree != null) {
			if ((leftTree.left != null && leftTree.right != null)
					&& (rightTree.left != null && rightTree.right != null)) {
				isFullTree = true;
			} else if ((leftTree.left == null && leftTree.right == null)
					&& (rightTree.left == null && rightTree.right == null)) {
				isFullTree = true;
			} else {
				isFullTree = false;
			}
			isFullTree = fullTree(leftTree.left, leftTree.right, isFullTree)
					&& fullTree(rightTree.left, rightTree.right, isFullTree);
			return isFullTree;
		}
		return isFullTree;
	}

	public boolean hasPathSum(int sum) { // 문제 5
		hasPath = false;
		hasPathSum(root, 0, sum);
		return hasPath;
	}

	public int hasPathSum(BSTNode tree, int pathSum, int sum) {
		if (tree != null && sum != pathSum) { // tree 탐색을 더 할 수 있으면
			pathSum += tree.item;
			pathSum += hasPathSum(tree.left, pathSum, sum);
			pathSum += hasPathSum(tree.right, pathSum, sum);
			if (tree.left == null && tree.right == null) { // tree 탐색이 끝나면
				if (pathSum == sum)
					hasPath = true; // insert / remove처럼 처리.
			}
		}
		return 0;
	}

	public void printPaths() { // 문제 6
		String s = new String("[");
		printPaths(root, s);
	}

	public void printPaths(BSTNode tree, String s) {
		if (tree != null) { // tree 탐색을 더 할 수 있으면
			s += tree.item;
			if (tree.left != null || tree.right != null) {
				s += ", ";
			}
			printPaths(tree.left, s); // 왼쪽 경로에 대해
			printPaths(tree.right, s); // 오른쪽 경로에 대해
			if (tree.left == null && tree.right == null) { // tree 탐색이 끝나면
				System.out.println(s + "]"); // 일단 출력 한번 하고
			}
		}
	}
}