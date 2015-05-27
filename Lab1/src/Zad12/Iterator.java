package Zad12;
public interface Iterator<T> {
	
	public T current();
	public void next();
	public void previous();
	public boolean isDone();
	public void first();
	public void last();
	public boolean hasNext();
}
