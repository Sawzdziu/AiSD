package Sorts;

import java.util.Arrays;

public class InsertSort implements Sorter<Integer> {

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
		long timeStart = System.nanoTime();
		for (int i = 1; i < size; i++) {
			int j = i + 1;
			Comparable temp = this.array[j];
			while (j > 0 && (Integer)temp < this.array[j - 1]) {
				this.array[j] = this.array[j - 1];
				swapNumber++;
				compareNumber++;
				j--;
			}
			compareNumber++;
			this.array[j] = (Integer) temp;
		}
		time = System.nanoTime() - timeStart;;
		return this.array;
	}

	public void toString(Comparable<Integer>[] list) {
		for (int i = 0; i < 20; i++)
			System.out.print(list[i] + ", ");
	}

	public String time() {
		return time + " nano second's";
	}
	
	public long swapNumber(){
		return this.swapNumber;
	}
	
	public long compareNumber(){
		return this.compareNumber;
	}

}
