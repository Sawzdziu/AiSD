package Zad12;

public class ThreeAndFiveIterator implements Iterator<Integer>{
	
	public static final int THREE = 3;
	public static final int FIVE = 5;
	
	private int current;
	private int max;

	public ThreeAndFiveIterator(int max) {
		this.max = max;
		current = THREE;
	}
	

	public ThreeAndFiveIterator() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void next() {
		current++;
		while(!(current % THREE == 0 || current % FIVE == 0)){
			current++;
		}
	}

	@Override
	public void previous() {
		current--;
		while(!(current % THREE == 0 || current % FIVE == 0)){
			current--;
		}
	}

	@Override
	public void first() {
		current = THREE;
	}

	@Override
	public void last() {
		if((max / THREE) * THREE > (max / FIVE) * FIVE){
			current = (max / THREE) * THREE;
		}
		else
			current = (max / FIVE) * FIVE;
	}

	@Override
	public Integer current(){
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
