package Tree;

public interface HashTable{

	public void put(Object key) throws Exception;

	public Object get(Object key);

	public boolean containsKey(Object key);

	public int size();

	public boolean isEmpty();

	public void resize() throws Exception;
	
	public void dump();

	public void remove(Object o);

}
