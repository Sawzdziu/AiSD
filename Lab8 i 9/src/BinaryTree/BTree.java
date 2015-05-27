package BinaryTree;

import java.util.Comparator;

public class BTree {

	public class Node<Integer> {

		public int numItems = 0;
		public int[] keys = new int[2 * size - 1];
		public Object[] objects = new Object[2 * size - 1];
		public Node[] childNodes = new Node[2 * size];
		public boolean isLeafNode;
		public Node nextNode;

	}

	private static final int size = 4;
	private Node root = null;

	public BTree() {
        root = new Node();
        root.isLeafNode = true;           
}
	
	public Node getRoot(){
		return root;
	}

	public void insert(int key, Object object) {
		Node newNode = root;
		if (newNode.numItems == (2 * size - 1)) {
			Node newRootNode = new Node();
			root = newRootNode;
			newRootNode.isLeafNode = false;
			root.childNodes[0] = newNode;
			splitChildNode(newRootNode, 0, newNode);
			insertToNonFullNode(newRootNode, key, object);
		} else {
			insertToNonFullNode(newNode, key, object);
		}
	}

	void splitChildNode(Node upperNode, int i, Node node) {
		Node newNode = new Node();
		newNode.isLeafNode = node.isLeafNode;
		newNode.numItems = size;
		for (int j = 0; j < size; j++) {
			newNode.keys[j] = node.keys[j + size - 1];
			newNode.objects[j] = node.objects[j + size - 1];
		}
		if (!newNode.isLeafNode) {
			for (int j = 0; j < size + 1; j++) {
				newNode.childNodes[j] = node.childNodes[j + size - 1];
			}
			for (int j = size; j <= node.numItems; j++) {
				node.childNodes[j] = null;
			}
		} else {
			newNode.nextNode = node.nextNode;
			node.nextNode = newNode;
		}
		for (int j = size - 1; j < node.numItems; j++) {
			node.keys[j] = 0;
			node.objects[j] = null;
		}
		node.numItems = size - 1;
		for (int j = upperNode.numItems; j >= i + 1; j--) {
			upperNode.childNodes[j + 1] = upperNode.childNodes[j];
		}
		upperNode.childNodes[i + 1] = newNode;
		for (int j = upperNode.numItems - 1; j >= i; j--) {
			upperNode.keys[j + 1] = upperNode.keys[j];
			upperNode.objects[j + 1] = upperNode.objects[j];
		}
		upperNode.keys[i] = newNode.keys[0];
		upperNode.objects[i] = newNode.objects[0];
		upperNode.numItems++;
	}
	
	void insertToNonFullNode(Node node, int key, Object object) {
        int i = node.numItems - 1;
        if (node.isLeafNode) {
                while (i >= 0 && key < node.keys[i]) {
                        node.keys[i + 1] = node.keys[i];
                        node.objects[i + 1] = node.objects[i];
                        i--;
                }
                i++;
                node.keys[i] = key;
                node.objects[i] = object;
                node.numItems++;
        } else {
                while (i >= 0 && key < node.keys[i]) {
                        i--;
                }
                i++;
                if (node.childNodes[i].numItems == (2 * size - 1)) {
                        splitChildNode(node, i, node.childNodes[i]);
                        if (key > node.keys[i]) {
                                i++;
                        }
                }
                insertToNonFullNode(node.childNodes[i], key, object);
        }
}       

	public Object search(int key) {
		return search(root, key);
	}

	public Object search(Node node, int key) {
		int i = 0;
		while (i < node.numItems && key > node.keys[i]) {
			i++;
		}
		if (i < node.numItems && key == node.keys[i]) {
			return node.objects[i];
		}
		if (node.isLeafNode) {
			return null;
		} else {
			return search(node.childNodes[i], key);
		}
	}

}
