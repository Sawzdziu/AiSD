package Samochod;

public class LinkedListIterator implements Iterator<Samochod> {

	private LinkedList list;
	private Node current = null;

	public LinkedListIterator(LinkedList list) {
		this.list = list;
	}

	@Override
	public void next() {
		current = current.getNext();
	}

	@Override
	public void first() {
		current = list.first;
	}

	@Override
	public void last() {
		current = current.getNext();
		while (current.getNext() != null) {
			next();
		}
	}

	@Override
	public void previous() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDone() {
		return current.getNext() == null;
	}

	@Override
	public Samochod current() {
		return current.getData();
	}

}
