package ONP;

import java.util.EmptyStackException;

public class DrowningStack implements Stack<Integer>{
	
	private final Integer[] array;
	
	private final int capacity;
	
	private int size = 0;
	
	public DrowningStack(int capacity) throws IllegalArgumentException{
		this.capacity = capacity;
		array = new Integer[capacity];
		if(capacity < 1){
			throw new IllegalArgumentException("Capacity must be greater than 0");
		}
	}
	
	
	@Override
	public void push(Integer value) {
		if(size == capacity){
			drow();
		}
		array[size++] = value;
	}

	@Override
	public Integer pop() throws EmptyStackException {
		if(size == 0){
			throw new EmptyStackException();
		}
		return array[--size];
	}

	@Override
	public Integer peek() throws EmptyStackException {
		if(size == 0){
			throw new EmptyStackException();
		}
		return array[size - 1];
	}
	
	/*
	 * Metoda topiaca jeden element.
	 */
	private void drow(){
		size--;
		System.arraycopy(array, 1, array, 0, size);
		/*
		 * for(int i = 0; i < size; i++)
		 * 		array[i] = array[i+];
		 */
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void display() throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException(
                    "Stos jest pusty, operacja nie powiodła się");
        }
 
        int temp = size - 1;
        do {
            System.out.println(array[temp]);
            temp--;
        } while (temp > -1);
 
    }

}
