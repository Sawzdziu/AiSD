package BinaryTree;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException() {
		super();
	}

	public ItemNotFoundException(Integer value) {
		super(String.valueOf(value));
	}
}
