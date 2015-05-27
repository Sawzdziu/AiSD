package Dictionary;

import java.util.Iterator;

public interface Map<K, V> {
	
	V get(K key);
	
	void put(K key, V value);
	
	boolean containsKey(K key);
	
	V remove(K key);
	
	void clear();
	
	int size();
	
	boolean isEmpty();
	
	Iterator<K> keyIterator();
	
	Iterator<V> valueIterator();

}
