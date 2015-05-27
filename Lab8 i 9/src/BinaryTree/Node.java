package BinaryTree;


public class Node {
	
	private Integer value;
	Node left;
	Node right;
	
	
	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public String toString(){
		return String.valueOf(this.getValue());
	}
	
	public Node(){
		value = null;
		left = null;
		right = null;
	}
	
	public Node(Integer value){
		this.value = value;
		left = null;
		right = null;
	}

}