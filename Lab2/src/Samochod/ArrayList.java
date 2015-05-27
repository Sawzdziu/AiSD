package Samochod;

public class ArrayList implements List<Samochod> {

	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	private Samochod elements[];

	public ArrayList() {
		elements = new Samochod[DEFAULT_CAPACITY];
	}

	public ArrayList(int capacity) {
		elements = new Samochod[capacity];
	}

	@Override
	public Iterator<Samochod> iterator() {
		return new ArrayIterator(elements, 0, size);
	}

	@Override
	public void insert(int index, Samochod value)
			throws IndexOutOfBoundsException {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		ensureCapacity(size + 1);
		System.arraycopy(elements, index, elements, index + 1, size - index);
		elements[index] = value;
		++size;
	}

	@Override
	public void add(Samochod value) {
		insert(size(), value);
	}

	@Override
	public Object delete(int index) throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		Samochod value = elements[index];
		int copyFrom = index + 1;
		if (copyFrom < size()) {
			System.arraycopy(elements, copyFrom, elements, index, size
					- copyFrom);
		}
		size--;
		return value;
	}

	@Override
	public boolean delete(Samochod value) {
		int index = indexOf(value);
		if (index != -1) {
			delete(index);
		}
		return index != -1;
	}

	@Override
	public void clear() {
		elements = new Samochod[DEFAULT_CAPACITY];
		size = 0;
	}

	@Override
	public Samochod set(int index, Samochod value)
			throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		Samochod oldValue = elements[index];
		elements[index] = value;
		return oldValue;
	}

	@Override
	public Samochod get(int index) throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		return elements[index];
	}

	@Override
	public int indexOf(Samochod value) {
		for (int i = 0; i < size; i++) {
			if (value.equals(elements[i])) {
				return i;
			}
		}
		return -1;
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

	private void ensureCapacity(int capacity) {
		if (elements.length < capacity) {
			Samochod[] copy = new Samochod[capacity + capacity / 2];
			System.arraycopy(elements, 0, copy, 0, size);
			elements = copy;
		}
	}

	private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
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
			insert(index, other.get(i));
		}
	}

	@Override
	public void addAll(Samochod element, List<Samochod> other) {
		int index = indexOf(element);
		for (int i = 0; i < other.size(); i++) {
			insert(index, other.get(i));

		}
	}

}
