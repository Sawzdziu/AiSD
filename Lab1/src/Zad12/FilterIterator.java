package Zad12;

import java.util.function.Function;
import java.util.function.Predicate;

public class FilterIterator implements Iterator<Integer>{

	public static final int THREE = 3;
	
	Iterator<Integer> it;
	Predicate<Integer> pr;
	Function<Integer, Integer> threeMultiply;
	
	public FilterIterator(Iterator<Integer> it, Predicate<Integer> pr){
		this.it = it;
		this.pr = pr;
		
	}
	
	public FilterIterator(Iterator<Integer> it, Predicate<Integer> pr, Function<Integer, Integer> tm){
		this.it = it;
		this.pr = pr;
		this.threeMultiply = tm;
		
	}
	
	@Override
	public Integer current() {
		return it.current();
	}

	@Override
	public void next() {
		it.next();
		filterForwards();
	
	}

	@Override
	public void previous() {
		it.previous();
		filterBackwards();
	}

	@Override
	public boolean isDone() {
		return it.isDone();
	}

	@Override
	public void first() {
		it.first();
		filterForwards();
	}

	@Override
	public void last() {
		it.last();
		filterBackwards();
	}
	
	private void filterForwards() {
        while (!it.isDone() && !pr.test(it.current())) {
            it.next();
        }
    }
	
	private void filterBackwards() {
        while (!it.isDone() && !pr.test(it.current())) {
            it.previous();
        }
    }
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

}
