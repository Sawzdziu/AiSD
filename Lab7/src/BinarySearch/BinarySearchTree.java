package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private Node node;
	private int numberOfNode;

	public BinarySearchTree() {
		this.node = null;
	}

	public Node getRoot() {
		return this.node;
	}

	public int getNumberOfNode() {
		return this.numberOfNode;
	}

	public void add(String value) {
		insert(value);
		numberOfNode++;
	}

	public String find(String value) {
		Node help = search(value);
		return help != null ? help.getValue() : null;
	}

	private Node search(String value) {
		Node current = node;
		int compare = 0;
		while (current != null
				&& (compare = value.compareTo(current.getValue())) != 0) {
			current = compare < 0 ? current.getLeft() : current.getRight();
		}
		return current;
	}

	public void insert(String value) {
		node = insert(value, node);
	}

	private Node insert(String value, Node n) {
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

	public void delete(String value) {
		node = delete(value, node);
		numberOfNode--;
	}

	private Node delete(String value, Node n) {
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

	public int distanceFromRoot(Node node, String value) {
		if (node == null) {
			return -1;
		}
		if(node.getValue().equals(value)){
			return 0;
		}else{
			if(node.getValue().compareTo(value) > 0){
				return 1 + distanceFromRoot(node.getLeft(), value);
			}else{
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

	/**
	 * Wyswietla alfabetycznie
	 * 
	 * @param focusNode
	 */

	public void inOrder(Node focusNode) {
		if (focusNode != null) {
			inOrder(focusNode.getLeft());
			System.out.println(focusNode.toString());
			inOrder(focusNode.getRight());
		}
	}

	/**
	 * Wyswietla od korzenia w dol
	 * 
	 * @param focusNode
	 */

	public void preOrder(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode.toString());
			preOrder(focusNode.getLeft());
			preOrder(focusNode.getRight());
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

	public void postOrder(Node focusNode) {
		if (focusNode != null) {
			postOrder(focusNode.getLeft());
			postOrder(focusNode.getRight());
			System.out.println(focusNode.toString());
		}
	}

}
