package Samochod;

public interface Iterator <T>{

	public void next();

	public void first();
	
	public void last();
	
	public void previous();

	public boolean isDone();

	public Object current();
}
