package Samochod;

public class DoubleLinkedListIterator implements Iterator<Samochod>{
	
	private final DoubleLinkedList list;
	private Node node = null;
	
	public DoubleLinkedListIterator(DoubleLinkedList list) {
		this.list = list;
	}
	
	@Override
	public void next() {
		node = node.next;
	}

	@Override
	public void first() {
		node = list.first;
	}

	@Override
	public void last() {
		node = list.last;
	}

	@Override
	public void previous() {
		node = node.previous;
	}

	@Override
	public boolean isDone() {
		return node == null;
	}

	@Override
	public Object current() {
		return node.data;
	}

}
