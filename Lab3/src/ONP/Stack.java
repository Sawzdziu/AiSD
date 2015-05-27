package ONP;

import java.util.EmptyStackException;

public interface Stack<T> {

	public void push(T value); // odłóż na stos

	public T pop() throws EmptyStackException; // pobierz ze stosu

	public T peek() throws EmptyStackException; // odczytaj ( nieniszcząco
														// ) ze stosu

	public void clear(); // czyść stos

	public int size(); // wysokość stosu

	public boolean isEmpty(); // true jeśli stos jest pusty
}
