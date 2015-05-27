package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree {

	private Node node;
	private int numberOfNode;

	public BinaryTree() {
		this.node = null;
	}

	public Node getRoot() {
		return this.node;
	}

	public int getNumberOfNode() {
		return this.numberOfNode;
	}

	public void add(Integer value) {
		insert(value);
		numberOfNode++;
	}

	public Integer find(Integer value) {
		Node help = search(value);
		return help != null ? help.getValue() : null;
	}

	private Node search(Integer value) {
		Node current = node;
		int compare = 0;
		while (current != null
				&& (compare = value.compareTo(current.getValue())) != 0) {
			current = compare < 0 ? current.getLeft() : current.getRight();
		}
		return current;
	}

	public void insert(Integer value) {
		node = insert(value, node);
	}

	private Node insert(Integer value, Node n) {
		if (n == null) {
			n = new Node(value);
		} else {
			int compare = value.compareTo(n.getValue());
			if (compare < 0) {
				n.setLeft(insert(value, n.getLeft()));
			} else if (compare > 0) {
				n.setRight(insert(value, n.getRight()));
			} else {
				throw new DuplicateItemException(value);
			}
		}
		return n;
	}

	public void delete(Integer value) {
		node = delete(value, node);
		numberOfNode--;
	}

	private Node delete(Integer value, Node n) {
		if (n == null) {
			throw new ItemNotFoundException(value);
		} else {
			int compare = value.compareTo(n.getValue());
			if (compare < 0) {
				n.setLeft(delete(value, n.getLeft()));
			} else if (compare > 0) {
				n.setRight(delete(value, n.getRight()));
			} else if (n.getLeft() != null && n.getRight() != null) {
				n.setRight(detachMin(n.getRight(), n));
			} else {
				n = (n.getLeft() != null) ? n.getLeft() : n.getRight();
			}
		}
		return n;
	}

	private Node detachMin(Node n, Node delete) {
		if (n.getLeft() != null) {
			n.setLeft(detachMin(n.getLeft(), delete));
		} else {
			delete.setValue(n.getValue());
			n = n.getRight();
		}
		return n;
	}

	public int distanceFromRoot(Node node, Integer value) {
		if (node == null) {
			return -1;
		}
		if (node.getValue().equals(value)) {
			return 0;
		} else {
			if (node.getValue().compareTo(value) > 0) {
				return 1 + distanceFromRoot(node.getLeft(), value);
			} else {
				return 1 + distanceFromRoot(node.getRight(), value);
			}
		}
	}

	public int amountOfNodes(Node node) {
		if (node == null) {
			return 0;
		} else
			return 1 + amountOfNodes(node.getLeft())
					+ amountOfNodes(node.getRight());
	}

	public int amountOfLeaves(Node node) {
		if (node == null)
			return 0;
		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		} else {
			return amountOfLeaves(node.getLeft())
					+ amountOfLeaves(node.getRight());
		}
	}

	public int amountNodeBelow(Node node) {
		if (node == null) {
			return 0;
		} else {
			return amountOfNodes(node.getLeft());
		}
	}

	public boolean isEmpty() {
		return node == null;
	}

	public void makeEmpty() {
		node = null;
	}

	public String toString() {
		return toString(node);
	}

	private String toString(Node focusNode) {
		String str = "";
		if (focusNode == null) {
			return str + "null";
		}
		if (focusNode.equals(getRoot())) {
			str = "root={";
		}
		str += "value=" + focusNode.getValue() + ",";
		str += "left={" + toString(focusNode.getLeft()) + "}, right={"
				+ toString(focusNode.getRight()) + "}";
		return str;
	}

	public void dswAlgorithm() {
		createSpine();
		createPerfectBST();
	}

	public void createSpine() {
		Node grandParent = null;
		Node parent = node;
		Node leftChild;

		while (null != parent) {
			leftChild = parent.left;
			if (null != leftChild) {
				grandParent = rotateRight(grandParent, parent, leftChild);
				parent = leftChild;
			} else {
				grandParent = parent;
				parent = parent.getRight();
			}
		}
	}

	private Node rotateRight(Node grandParent, Node parent, Node leftChild) {
		if (null != grandParent) {
			grandParent.right = leftChild;
		} else {
			node = leftChild;
		}
		parent.left = leftChild.right;
		leftChild.right = parent;
		return grandParent;
	}

	private void createPerfectBST() {
		int n = 0;
		for (Node tmp = node; null != tmp; tmp = tmp.right) {
			n++;
		}
		// m = 2^floor[lg(n+1)]-1, ie the greatest power of 2 less than n: minus
		// 1
		int m = greatestPowerOf2LessThanN(n + 1) - 1;
		makeRotations(n - m);

		while (m > 1) {
			makeRotations(m /= 2);
		}
	}

	private int greatestPowerOf2LessThanN(int n) {
		int x = MSB(n);// MSB
		return (1 << x);// 2^x
	}

	public int MSB(int n) {
		int ndx = 0;
		while (1 < n) {
			n = (n >> 1);
			ndx++;
		}
		return ndx;
	}

	private void makeRotations(int bound) {
		Node grandParent = null;
		Node parent = node;
		Node child = node.right;
		for (; bound > 0; bound--) {
			try {
				if (null != child) {
					rotateLeft(grandParent, parent, child);
					grandParent = child;
					parent = grandParent.right;
					child = parent.right;
				} else {
					break;
				}
			} catch (NullPointerException convenient) {
				break;
			}
		}
	}

	private void rotateLeft(Node grandParent, Node parent, Node rightChild) {
		if (null != grandParent) {
			grandParent.right = rightChild;
		} else {
			node = rightChild;
		}
		parent.right = rightChild.left;
		rightChild.left = parent;
	}

	/**
	 * Wyswietla alfabetycznie
	 * 
	 * @param focusNode
	 */

	public void inOrder(Node focusNode, Consumer<Integer> consumer) {
		if (focusNode != null) {
			inOrder(focusNode.getLeft(), consumer);
			consumer.accept(focusNode.getValue());
			inOrder(focusNode.getRight(), consumer);
		}
	}

	/**
	 * Wyswietla od korzenia w dol
	 * 
	 * @param focusNode
	 */

	public void preOrder(Node focusNode, Consumer<Integer> consumer) {
		if (focusNode != null) {
			consumer.accept(focusNode.getValue());
			preOrder(focusNode.getLeft(), consumer);
			preOrder(focusNode.getRight(), consumer);
		}
	}

	public int findHeight(Node node) {
		if (node == null)
			return -1;

		int left = findHeight(node.getLeft());
		int righth = findHeight(node.getRight());

		if (left > righth) {
			return left + 1;
		} else {
			return righth + 1;
		}
	}

	/**
	 * Wyswietla od najnizszego
	 * 
	 * @param focusNode
	 */

	public void postOrder(Node focusNode, Consumer<Integer> consumer) {
		if (focusNode != null) {
			postOrder(focusNode.getLeft(), consumer);
			postOrder(focusNode.getRight(), consumer);
			consumer.accept(focusNode.getValue());
		}
	}

	public void acrossOrder(Node focusNode, Consumer<Integer> consumer) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(focusNode);
		while (!queue.isEmpty()) {
			Node help = queue.poll();
			consumer.accept(help.getValue());
			if (help.getLeft() != null) {
				queue.add(help.getLeft());
			}
			if (help.getRight() != null) {
				queue.add(help.getRight());
			}
		}
	}

}