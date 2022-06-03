public class BSTree<T extends Comparable<T>> {

	protected TNode<T> root;

	

	public BSTree() {
	}

	public TNode<T> find(T data) {
		return find(data, root);
	}

	public TNode<T> find(T data, TNode<T> node) {
		if (node != null) {
			int comp = node.data.compareTo(data);
			if (comp == 0)
				return node;
			else if (comp > 0 && node.hasLeft())
				return find(data, node.left);
			else if (comp < 0 && node.hasRight())
				return find(data, node.right);
		}
		return null;
	}

	public TNode<T> largest() {
		return largest(root);
	}

	public TNode<T> largest(TNode<T> node) {
		if (node != null) {
			if (!node.hasRight())
				return (node);
			return largest(node.right);
		}
		return null;
	}

	public TNode<T> smallest() {
		return smallest(root);
	}

	public TNode<T> smallest(TNode<T> node) {
		if (node != null) {
			if (!node.hasLeft())
				return (node);
			return smallest(node.left);
		}
		return null;
	}

	public int height() {
		return height(root);
	}

	public int height(TNode<T> node) {
		if (node == null)
			return 0;
		if (node.isLeaf())
			return 1;
		int left = 0;
		int right = 0;
		if (node.hasLeft())
			left = height(node.left);
		if (node.hasRight())
			right = height(node.right);
		return (left > right) ? (left + 1) : (right + 1);
	}

	public void insert(T data) {
		if (isEmpty())
			root = new TNode<>(data);
		else
			insert(data, root);
	}

	private void insert(T data, TNode<T> node) {
		if (data.compareTo((T) node.data) >= 0) { // insert into right subtree
			if (!node.hasRight())
				node.right = new TNode<>(data);
			else
				insert(data, node.right);
		} else { // insert into left subtree
			if (!node.hasLeft())
				node.left = new TNode<>(data);
			else
				insert(data, node.left);
		}
	}

	public boolean isEmpty() {
		if (root != null)
			return false;
		else
			return true;
	}

	public TNode<T> delete(T data) {
		TNode<T> current = root;
		TNode<T> parent = root;
		boolean isLeftChild = false;
		if (isEmpty())
			return null; // tree is empty
		while (current != null && !current.data.equals(data)) {
			parent = current;
			if (data.compareTo((T) current.data) < 0) {
				current = current.left;
				isLeftChild = true;
			} else {
				current = current.right;
				isLeftChild = false;
			}
		}
		if (current == null)
			return null; // node to be deleted not found
		// case 1: node is a leaf
		if (!current.hasLeft() && !current.hasRight()) {
			if (current == root) // tree has one node
				root = null;
			else {
				if (isLeftChild)
					parent.left = null;
				else
					parent.right = null;
			}
		} else if (current.hasLeft()) { // current has left child only
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.hasRight()) { // current has right child only
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else {
			TNode<T> successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return current;
	}

	private TNode<T> getSuccessor(TNode<T> node) {
		TNode<T> parentOfSuccessor = node;
		TNode<T> successor = node;
		TNode<T> current = node.right;
		while (current != null) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.left;
		}
		if (successor != node.right) { // fix successor connections
			parentOfSuccessor.left = successor.right;
			successor.right = node.right;
		}
		return successor;
	}

	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(TNode<T> node) {
		if (node != null) {
			if (node.left != null)
				traverseInOrder(node.left);
			System.out.print(node + " ");
			if (node.right != null)
				traverseInOrder(node.right);
		}
	}
	public void traversepreOrder() {
		traversepreOrder(root);
	}
	
	private void traversepreOrder(TNode<T> node) {
		if (node == null)
		    return;

		  // Traverse root
		  System.out.print(node + " ");
		  // Traverse left
		  traversepreOrder(node.left);
		  // Traverse right
		  traversepreOrder(node.right);
	}
	
	
	public void traversePostOrder() {
		traversePostOrder(root);
	}
	
	private void traversePostOrder(TNode<T> node) {
		if (node == null)
		    return;

		  // Traverse left
		traversePostOrder(node.left);
		  // Traverse right
		traversePostOrder(node.right);
		  // Traverse root
		  System.out.print(node + " ");
	}
	
	
	

	public int count() {
		return count(root);
	}

	private int count(TNode<T> node) {
		if (node == null) {
			return 0;
		}
		return 1 + count(node.left) + count(node.right);

	}

	
	
	public int countNonLeafes() {
		return countNonLeafes(root);
	}

	private int countNonLeafes(TNode<T> node) {
		if (node != null) {
			if(node == null || node.left == null  && node.right == null){
				return 0;
			}else {
			return 1 + countNonLeafes(node.left)+countNonLeafes(node.right);
			}
		}
		return 0;
	}
	
	
	public int countLeaves() {
		return countLeaves(root);

		}

		private int countLeaves(TNode<T> n) {
		if (n == null)
		return 0;

		if (n.isLeaf())
		return 1;
		return countLeaves(n.getLeft()) + countLeaves(n.getRight());

		}
	
	

}
