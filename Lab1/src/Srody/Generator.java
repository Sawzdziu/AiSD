package Srody;

import static java.time.DayOfWeek.*;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Generator implements Iterator<LocalDate>{
	LocalDate first;
	LocalDate current;
	LocalDate last;
	
	public Generator(LocalDate first, LocalDate last){
		this.first = first;
		this.last = last;
		this.current = first.with(TemporalAdjusters.nextOrSame(WEDNESDAY));
	}
	
	
	@Override
	public LocalDate current() {
		if(!isDone()){
			throw new IllegalStateException();
		}
		return current;
	}

	@Override
	public void next() {
		current = current.plusWeeks(1);
	}

	@Override
	public void previous() {
		current = current.minusWeeks(1);
	}

	@Override
	public boolean isDone() {
		return current.isBefore(last);
	}

	@Override
	public void first() {
		current = first.with(TemporalAdjusters.nextOrSame(WEDNESDAY));
	}

	@Override
	public void last() {
		current = last.with(TemporalAdjusters.previousOrSame(WEDNESDAY));
	}

	@Override
	public boolean hasNext() {
		return false;
	}
	


}
