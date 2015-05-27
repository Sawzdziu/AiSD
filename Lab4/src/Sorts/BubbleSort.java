package Sorts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Timer;

public class BubbleSort implements Sorter<Integer> {

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
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				compareNumber++;
				if (this.array[j] > this.array[j + 1]) {
					++swapNumber;
					Comparable temp = this.array[j];
					this.array[j] = this.array[j + 1];
					this.array[j + 1] = (Integer) temp;
				} else {
					compareNumber++;
				}
			}
		}
		long timeEnd = System.currentTimeMillis();
		time = System.nanoTime() - timeStart;
		return this.array;
	}

	public void toString(Comparable<Integer>[] list) {
		for (int i = 0; i < 20; i++)
			System.out.print(list[i] + ", ");
	}

	public String time() {
		return time + " nano second's";
	}

	public long swapNumber() {
		return this.swapNumber;
	}

	public long compareNumber() {
		return this.compareNumber;
	}

}