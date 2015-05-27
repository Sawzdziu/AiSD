package Sorter;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSort implements Sorter<Integer> {

	private long time;
	private long swapNumber;
	private long compareNumber;
	private Integer[] array;
	public static int compare = 0;
	public static int write = 0;
	IntegerComparator comparator = new IntegerComparator();

	@Override
	
	  public Comparable[] sort(Comparable[] array) { long timeStart =
	  System.nanoTime(); quickSort((Integer[]) array, 0, array.length - 1);
	  this.time = System.nanoTime() - timeStart; //toString(array); 
	  return array; }
	  
	  public void quickSort(Integer[] array, int start, int end) { if (end >
	  start) { int partition = partition(array, start, end); quickSort(array,
	  start, partition - 1); quickSort(array, partition + 1, end); } }
	  
	  private int partition(Integer[] array, int left, int right) { Integer
	  value = array[right]; int i = left - 1; int j = right; while (i < j) {
	  while (comparator.compare(array[++i], value) < 0) compareNumber++; while
	  ((j > left) && comparator.compare(array[--j], value) > 0)
	  compareNumber++; if (i < j) swap(array, i, j);
	  
	  } swap(array, i, right); return i; }
	  
	  private void swap(Object[] array, int left, int right) { if (left ==
	  right) { return; } Object temp = array[left]; array[left] = array[right];
	  array[right] = temp; swapNumber++; }
	 
	/*public Comparable[] sort(Comparable[] array) {
		this.array = (Integer[]) Arrays.copyOf(array, array.length);
		long timeStart = System.nanoTime();
		//partOnTwice(this.array, 0, array.length - 1);
		quickSort((Integer[]) array, 0, array.length - 1);
		this.time = System.nanoTime() - timeStart;
		// toString(array);
		return this.array;

	}
	

	private void quickSort(Integer tablica[], int x, int y) {

		int i, j, v, temp;

		i = x;
		j = y;
		v = tablica[(x + y) / 2];
		do {
			while (tablica[i] < v)
				i++;
			compareNumber++;
			while (v < tablica[j])
				j--;
			compareNumber++;
			if (i <= j) {
				temp = tablica[i];
				tablica[i] = tablica[j];
				tablica[j] = temp;
				i++;
				j--;
				swapNumber++;
			}
		} while (i <= j);
		if (x < j)
			quickSort(tablica, x, j);
		compareNumber++;
		if (i < y)
			quickSort(tablica, i, y);
		compareNumber++;
	}*/

	public void toString(Comparable<Integer>[] list) {
		for (int i = 0; i < 20; i++)
			System.out.print(list[i] + ", ");
	}

	public String time() {
		return time + " nano second's";
	}

	public long getTime() {
		return this.time;
	}

	public long swapNumber() {
		return this.swapNumber;
	}

	public long compareNumber() {
		return this.compareNumber;
	}

}
