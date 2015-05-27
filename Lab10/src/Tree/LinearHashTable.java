package Tree;

import java.util.Iterator;

public class LinearHashTable implements HashTable {

	private Element[] elementArray;
	private Element[] cloneTab;
	private int size, primeSize, temp;

	public LinearHashTable() {
		elementArray = new Element[50];
		size = 0;
		primeSize = 50;
	}

	public LinearHashTable(int length) {
		elementArray = new Element[length];
		size = 0;
		primeSize = length;
	}

	@Override
	public void put(Object key) throws Exception {
		if (++size * 3 / 4 > elementArray.length) {
			resize();
		}
		int hash = Math.abs(key.hashCode()) % elementArray.length;
		System.out.println("Hash obiektu : " + key + " wynosi " + hash);
		// System.out.println("isElementEmpty(hash) " + isElementEmpty(hash));
		int i = 0;
		while (!isElementEmpty(hash) && ++i < elementArray.length) {
			/*
			 * System.out.println("Kolizja przy indeksie nr " + hash);
			 * System.out.println("key.hashCode()+(i+1) == " + key.hashCode() +
			 * (i + 1));
			 */
			hash = (Math.abs(key.hashCode()) + i) % elementArray.length;
			// System.out.println("Index obiektu : " + key + " wynosi " + hash);

		}
		if (i == elementArray.length){
			throw new Exception("Brak miejsca w tablicy");
		}
		if (size == elementArray.length){
			System.out.println("Przepelnienie  tablicy");// */
		}
		if (i >= 0){
			System.out.println("Dodano obiekt: " + key + " Porownano: " + (i));
		}
		elementArray[hash] = new Element(key);
		// _array[0].setEmpty(true);
	}

	private boolean isElementEmpty(int hash) {
		Element result = elementArray[hash];
		if (result == null)
			return true;
		else
			return result.isEmpty();
	}

	@Override
	public Object get(Object key) {
		int hash = Math.abs(key.hashCode() % elementArray.length);
		// System.out.println("Hash obiektu : " + key + " wynosi " + hash );
		Element result = elementArray[hash];

		if (result == null)
			return null;
		int i = 1;
		while (result != null && !key.equals(result.getValue())
				&& i < elementArray.length) {
			if (!result.isEmpty()) {
				hash = (Math.abs(key.hashCode()) + (i++)) % elementArray.length;
				// System.out.println("Index " + key + " " + hash + " i = " +
				// i);
				result = elementArray[hash];
			}
		}
		System.out.println("Index " + key + " " + hash + " i = " + (i - 1));
		if (result == null || i == elementArray.length || result.isEmpty())
			return null;

		return result.getValue();
	}

	@Override
	public boolean containsKey(Object key) {
		Object o = get(key);
		return o != null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() < 1;
	}

	@Override
	public void resize() throws Exception {
		primeSize = primeSize * 2;
		boolean isPrime = false;
		while (isPrime == false) {
			isPrime = true;
			if (primeSize > 2)
				for (int i = 2; i < primeSize; i++)
					if (primeSize % i == 0)
						isPrime = false;
			if (isPrime == false)
				primeSize++;
		}

		cloneTab = elementArray.clone();
		elementArray = new Element[primeSize];
		size = 0;
		for (temp = 0; temp < cloneTab.length; temp++)
			if (cloneTab[temp] != null)
				put(cloneTab[temp].getValue());
	}

	@Override
	public void remove(Object o) {
		int hash = Math.abs(o.hashCode() % elementArray.length);
		int i = 0;
		Element result = elementArray[hash];

		if (result == null)
			return;
		while (result == null || !o.equals(result.getValue())
				&& (i) < elementArray.length) {
			++i;
			hash = Math.abs(o.hashCode() + (i)) % elementArray.length;
			result = elementArray[hash];
		}
		System.out.println("Index " + o + " " + hash + " i = " + i);
		if (result == null || i == elementArray.length)
			return;
		size--;
		elementArray[hash] = null;
	}

	@Override
	public void dump() {
		int temp = -1;
		System.out.print("LinearHashTable: ");
		while (++temp < elementArray.length) {
			if (elementArray[temp] == null)
				System.out.print("_,");
			else
				System.out.print(elementArray[temp] + ",");
		}
		System.out.print("\n");
	}
}
