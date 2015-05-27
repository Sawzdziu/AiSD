package Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Dictionary implements Map<String, Integer> {

	private ArrayList<Word> array;
	private ArrayList<String> keyArray;
	private ArrayList<Integer> valueArray;

	public Dictionary() {
		this.array = new ArrayList<Word>();
		this.keyArray = new ArrayList<String>();
		this.valueArray = new ArrayList<Integer>();
	}

	@Override
	public Integer get(String key) {
		for (Word word : array) {
			if (word.getKey().equals(key)) {
				return (Integer) word.getValue();
			}
		}
		return null;
	}

	@Override
	public void put(String key, Integer value) {
		boolean exist = false;
		Word<String, Integer> add = new Word<String, Integer>(key, value);
		for (Word word : array) {
			if (word.getKey().equals(key)) {
				word.setValue(value);
				exist = true;
			}
		}
		if (!exist) {
			array.add(add);
			keyArray.add(key);
			valueArray.add(value);
		}
	}

	@Override
	public boolean containsKey(String key) {
		for (Word word : array) {
			if (word.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Integer remove(String key) {
		Iterator<Word> iterator = array.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getKey().equals(key)) {
				iterator.remove();
				return 1;
			}
		}
		return 0;
	}

	@Override
	public void clear() {
		array.clear();
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	public String toString() {
		System.out.println("Aktualny stan: ");
		for (Word word : array) {
			System.out.println("Slowo: " + word.getKey() + ", Wartosc: "
					+ word.getValue());
		}
		System.out.println();
		return "Koniec";
	}

	@Override
	public Iterator<String> keyIterator() {
		List<String> keyList = new ArrayList<String>();
		for (Word word : array) {
			keyList.add((String) word.getKey());
		}
		Iterator iterator = keyList.iterator();
		return iterator;
		// Iterator iterator = keyArray.iterator();
		// return iterator;
	}

	@Override
	public Iterator<Integer> valueIterator() {
		/*
		 * List<Integer> valueList = new ArrayList<Integer>(); for (Word word :
		 * array) { valueList.add((Integer) word.getValue()); } Iterator
		 * iterator = valueList.iterator(); return iterator;
		 */
		Iterator iterator = valueArray.iterator();
		return iterator;
	}
}
