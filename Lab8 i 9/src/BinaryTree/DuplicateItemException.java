package BinaryTree;

public class DuplicateItemException extends RuntimeException {

	public DuplicateItemException() {
		super();
	}

	public DuplicateItemException(Integer value) {
		super(String.valueOf(value));
	}
}
