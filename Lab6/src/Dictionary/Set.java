package Dictionary;

public interface Set <T>{
	
	void add(T value);
	
	boolean contains(T value);
	
	void remove(T value);
	
	void clear();
	
	int size();
	
	boolean isEmpty();

}
