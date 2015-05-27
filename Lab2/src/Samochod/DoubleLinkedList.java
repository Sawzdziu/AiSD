package Samochod;

public class DoubleLinkedList implements List<Samochod> {

	private int size;
	Node first;
	Node last;

	public DoubleLinkedList() {
		size = 0;
		first = null;
	}

	@Override
	public Iterator iterator() {
		return new DoubleLinkedListIterator(this);
	}

	@Override
	public void insert(int index, Samochod value)
			throws IndexOutOfBoundsException {
		checkOutOfBoundsException(index);
		Node temporary = new Node(value);
		Node before = getNode(index);

		if (index == 0) {
			temporary.setPrevious(before.getPrevious());
			temporary.setNext(before.getNext());
			first = temporary;
			size++;
		} else {
			temporary.attachBefore(before);
		}

		size++;

	}

	@Override
	public void add(Samochod value) {
		Node temporary = new Node(value);
		if( size == 0 ){
			temporary.setPrevious(temporary);
			temporary.setNext(temporary);
			first = temporary;
			size++;
		}else{
			insert(size(), value);
		}
	}

	@Override
	public Samochod delete(int index) throws IndexOutOfBoundsException {
		checkOutOfBoundsException(index);
		Node current = this.first;
		for(int i = 0; i < index; i++){
			current = current.getNext();
		}
		current.detach();
		--size;
		return current.getData();
	}

	@Override
	public boolean delete(Samochod value) {
		int index = indexOf(value);
		if (index != -1)
			delete(index);
		return index != -1;
	}

	@Override
	public void clear() {
		size = 0;
		last = null;
		first = null;
	}

	@Override
	public Samochod set(int index, Samochod value)
			throws IndexOutOfBoundsException {
		checkOutOfBoundsException(index);
		Node current = getNode(index);
		Samochod previousValue = current.getData();
		current.setData(value);
		return previousValue;
	}

	@Override
	public Samochod get(int index) throws IndexOutOfBoundsException {
		checkOutOfBoundsException(index);
		return getNode(index).getData();
	}

	@Override
	public int indexOf(Samochod value) {
		int index = 0;
		boolean found = false;
		Node current = first;
		while (index != size && !found) {
			current = current.getNext();
			index++;
			if (current.getData().equals(value)) {
				found = true;
			}
		}
		return found ? index : -1;
	}

	@Override
	public boolean contains(Samochod value) {
		return indexOf(value) != -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Node getNode(int index) throws IndexOutOfBoundsException {
		checkOutOfBoundsException(index);
		Node current = this.first;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	private void checkOutOfBoundsException(int index) {
		if (index < 0 || index > size() || size == 0)
			throw new IndexOutOfBoundsException();
	}

	@Override
	public void addAll(List<Samochod> other) {
		for (int i = 0; i < other.size(); i++) {
			add(other.get(i));
		}
	}

	@Override
	public void addAll(int index, List<Samochod> other) {
		for (int i = 0; i < other.size(); i++) {
			insert(index++, other.get(i));
		}
	}

	@Override
	public void addAll(Samochod element, List<Samochod> other) {
		int index = indexOf(element);
		for (int i = 0; i < other.size(); i++) {
			insert(index++, other.get(i));
		}
	}

}
