package Dictionary;

import java.util.List;

public interface MultiMap <K, V>{
	
	List<V> get(K key);
	
	void put(K key, V value);
	
	boolean containsKey(K key);
	
	List<V> remove(K key);
	
	void clear();
	
	int size();
	
	boolean isEmpty();

}
