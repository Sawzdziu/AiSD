package Tree;

import java.util.Iterator;

public class LinkedHashTable implements HashTable {
	private Element[] elementArray;
	private int size, primeSize;

	public LinkedHashTable() {
		elementArray = new Element[50];
		size = 0;
		primeSize = 50;
	}

	public LinkedHashTable(int size) {
		elementArray = new Element[size];
		size = 0;
		primeSize = size;
	}

	@Override
	public boolean containsKey(Object key) {
		Object o = get(key);
		return o != null;
	}

	@Override
	public Object get(Object key) {
		int hash = Math.abs(key.hashCode()) % elementArray.length;
		if (elementArray[hash] == null) {
			return null;
		} else {
			Element temp = elementArray[hash];
			boolean isDone = false;
			Iterator<Element> iterator = temp.array.iterator();
			int i = 0;
			if (temp.array.isEmpty()) {
				return hash;
			} else {
				System.out.println(iterator.next());
				while (iterator.hasNext() && !isDone) {
					i++;
					if (iterator.next().value == (key)) {
						System.out.println("Hash: " + hash + " indeks: " + i);
						isDone = true;
					}
				}
				if (isDone) {
					return hash;
				} else {
					return null;
				}
			}
		}
	}

	@Override
	public boolean isEmpty() {
		return size < 1;
	}

	@Override
	public void put(Object key) throws Exception {
		++size;
		//System.out.println("Klucz: " + key + " jego hash: " + key.hashCode());
		int hash = Math.abs(key.hashCode()) % elementArray.length;
		//System.out.println("Jego miejsce w tablicy: " + hash);
		if (elementArray[hash] == null)
			elementArray[hash] = new Element(key);
		else {
			Element temp = elementArray[hash];
			temp.array.add(new Element(key));
		}
	}

	@Override
	public void remove(Object key) {
		int hash = Math.abs(key.hashCode()) % elementArray.length;
		if (elementArray[hash] != null) {
			Element temp = elementArray[hash];
			Element previous = null;
			boolean isDone = false;
			while (!(isDone = key.equals(temp.getValue()))
					&& temp.getNext() != null) {
				previous = temp;
				temp = temp.getNext();
			}

			if (isDone) {
				if (previous == null)
					if (temp.getNext() == null)
						elementArray[hash] = null;
					else
						elementArray[hash] = temp.getNext();
				else
					previous.setValue(temp.getNext());
				--size;
			}
		}
	}

	@Override
	public void resize() throws Exception {
		Element[] help = elementArray;
		primeSize *= 20;
		elementArray = new Element[primeSize];
		size = 0;
		for (Element e : help)
			while (e != null) {
				put(e.getValue());
				e = e.getNext();
			}
	}

	@Override
	public int size() {
		return primeSize;
	}

	@Override
	public void dump() {
		for (int i = 0; i < elementArray.length; i++)
			if (elementArray[i] != null)
				System.out.print("Array[" + i + "] -> "
						+ elementArray[i].toStringLinked() + "\n");
	}

	public String toString() {
		// return
		String result = "LinkedHashTable \n";// + Arrays.toString(_array);
		result += "**********\n";

		for (int i = 0; i < elementArray.length; i++) {
			if (elementArray[i] != null)
				result += i + ") " + elementArray[i].toStringLinked() + "\n";
		}
		return result;
	}
}