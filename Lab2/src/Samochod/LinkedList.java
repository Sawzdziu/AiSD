package Samochod;

public class LinkedList implements List<Samochod> {

    int size;
	Node first;

	public LinkedList() {
		size = 0;
		first = null;
	}
	
	public void addFirst(Samochod value){
		Node temporary = new Node(value);
		temporary.setNext(null);
		first = temporary;
		size++;
	}

	@Override
	public void insert(int index, Samochod value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(Samochod value) {
		Node temporary = new Node(value);
		if (first == null) {
			addFirst(value);
			return;
		} else {
			if (first.getData().yearOfProduction < temporary.getData().yearOfProduction) {
				Node current = this.first;
				for (int i = 1; i < size
						&& first.getData().yearOfProduction < temporary
								.getData().yearOfProduction; i++) {
					current = current.getNext();
				}
				temporary.setNext(current.getNext());
				current.setNext(temporary);
			}else{
				temporary.setNext(first);
				first = temporary;
			}
			size++;
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
		first = null;
	}

	@Override
	public Samochod set(int index, Samochod value)
			throws IndexOutOfBoundsException {
		checkOutOfBoundsException(index);
		Node temporary = getNode(index);
		Samochod previousValue = temporary.getData();
		temporary.setData(value);
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
		Node  current = this.first;
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

	@Override
	public Iterator iterator() {
		return new LinkedListIterator(this);
	}

	private Node getNode(int index) throws IndexOutOfBoundsException {
		checkOutOfBoundsException(index);
		Node current = this.first;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}
	
	private void checkOutOfBoundsException(int index) {
		if (index < 0 || index > size || size == 0)
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
		throw new UnsupportedOperationException();
	}

	@Override
	public void addAll(Samochod element, List<Samochod> other) {
		throw new UnsupportedOperationException();
	}

}
