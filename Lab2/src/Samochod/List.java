package Samochod;

public interface List<T> extends Iterable {

	// dodaj na wskazaną pozycję
	public void insert(int index, T value) throws IndexOutOfBoundsException;

	// dodaj na koniec
	public void add(T value);

	// usuń element ze wskazanej pozycji
	public Object delete(int index) throws IndexOutOfBoundsException;

	// usuń pierwsze wystąpienie wskazanej wartości
	public boolean delete(T value);

	// usuń wszystkie elementy
	public void clear();

	// zmień element na wskazanej pozycji
	public T set(int index, T value) throws IndexOutOfBoundsException;

	// daj wartość wskazanego elementu
	public T get(int index) throws IndexOutOfBoundsException;

	// znajdź pozycję podanej wartości; -1 gdy nie ma
	public int indexOf(T value);

	// czy dana wartość występuje na liście
	public boolean contains(T value);

	// liczba elementów na liście
	public int size();

	// czy pusta lista
	public boolean isEmpty();

	public void addAll(List<T> other);

	public void addAll(int index, List<T> other);

	public void addAll(T element, List<T> other);
}
