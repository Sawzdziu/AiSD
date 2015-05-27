package Zad12;

public class FiveIterator implements Iterator<Integer>{
	
	public static final int FIVE = 5;
	
	private int current = 0;
	private int max;

	public FiveIterator(int max) {
		this.max = max;
		current = FIVE;
		
	}

	@Override
	public void next() {
		current += FIVE;
	}

	@Override
	public void previous() {
		current -= FIVE;
	}

	@Override
	public void first() {
		current = FIVE;
	}

	@Override
	public void last() {
		current = (max / FIVE) * FIVE;
	}

	@Override
	public Integer current() {
		if(isDone()){
			throw new IllegalStateException();
		}
		return current;
	}

	@Override
	public boolean isDone() {
		return current > max;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

}

