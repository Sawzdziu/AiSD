package Dictionary;

import java.util.Iterator;

public class DictionarySet<T> implements Set<String>{
	
	Dictionary dictionary = new Dictionary();

	@Override
	public void add(String value) {
		if(!dictionary.containsKey(value)){
			dictionary.put(value, null);
		}
	}

	@Override
	public boolean contains(String value) {
		return dictionary.containsKey(value);
	}

	@Override
	public void remove(String value) {
		dictionary.remove(value);
	}

	@Override
	public void clear() {
		dictionary.clear();
	}

	@Override
	public int size() {
		return dictionary.size();
	}

	@Override
	public boolean isEmpty() {
		return dictionary.isEmpty();
	}
	
	public String toString(){
		//return dictionary.toString();
		System.out.println("Aktualny stan: ");
		Iterator<String> keyIterator = dictionary.keyIterator();
		while(keyIterator.hasNext()){
			String value = keyIterator.next();
			System.out.println("Slowo: " + value);
		}
		return "Koniec";
	}
	
	

}
