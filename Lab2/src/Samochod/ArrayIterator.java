package Samochod;

public class ArrayIterator implements Iterator<Samochod> {

	final Samochod[] array;
	final int first;
	final int last;
	int current = -1;

	public ArrayIterator(Samochod[] array, int start, int length) {
		this.array = array;
		this.first = start;
		this.last = start + length - 1;
	}

	public ArrayIterator(Samochod[] array) {
		this.array = array;
		first = 0;
		last = array.length - 1;
	}

	@Override
	public void next() {
		current++;
	}

	@Override
	public void first() {
		current = first;
	}

	@Override
	public boolean isDone() {
		return current < first || current > last;
	}

	@Override
	public Samochod current() {
		return array[current];
	}

	@Override
	public void last() {
		current = last;
	}

	@Override
	public void previous() {
		current--;
	}

}
