package Sorts;

import java.util.Arrays;

public class BubbleSortRemember implements Sorter<Integer> {

	private Integer[] array;
	private int size;
	private long time;
	private long swapNumber;
	private long compareNumber;
	
	@Override
	public Comparable[] sort(Comparable[] array) {
		this.array = new Integer[array.length];
		this.size = array.length - 1;
		this.array = (Integer[]) Arrays.copyOf(array, array.length);
		int lastSwap = size;
		long timeStart = System.nanoTime();
		while (lastSwap > 0) {
			int end = lastSwap;
			lastSwap = 0;
			for (int i = 0; i < end; i++) {
				if (this.array[i] > this.array[i + 1]) {
					Comparable temp = this.array[i];
					
					while (i < end && ((Integer) temp > this.array[i + 1])) {
						this.array[i] = this.array[i + 1];
						swapNumber++;
						compareNumber++;
						i++;
					}
					lastSwap = i;
					this.array[i] = (Integer) temp;
				}
				else{
					compareNumber++;
				}
			}
		}
		time = System.nanoTime() - timeStart;
		return this.array;
	}

	/*
	 * public Comparable[] sort(Comparable[] array) { this.array = new
	 * Integer[array.length]; this.size = array.length - 1; this.array =
	 * (Integer[]) Arrays.copyOf(array, array.length); long timeStart =
	 * System.nanoTime(); int kupa = size; for (int i = 0; i < size; i++) { for
	 * (int j = 0; j < kupa; j++) { if (this.array[j].compareTo(this.array[j +
	 * 1]) > 0) { Comparable temp = this.array[j]; this.array[j] = this.array[j
	 * + 1]; this.array[j + 1] = (Integer) temp; } } kupa--; } time =
	 * System.nanoTime() - timeStart; return this.array; }
	 */

	public void toString(Comparable<Integer>[] list) {
		for (int i = 0; i < 20; i++)
			System.out.print(list[i] + ", ");
	}

	public String time() {
		return time + " nano seond's";
	}
	
	public long swapNumber(){
		return this.swapNumber;
	}
	
	public long compareNumber(){
		return this.compareNumber;
	}
	

}
