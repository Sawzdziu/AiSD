package Sorts;

import java.util.Arrays;

public class BubbleSortDual implements Sorter<Integer> {

	private Integer[] array;
	private int size;
	private long time;
	private long swapNumber;
	private long compareNumber;

	@Override
	public Comparable[] sort(Comparable[] array) {
		this.array = new Integer[array.length];
		this.size = array.length;
		this.array = (Integer[]) Arrays.copyOf(array, array.length);
		long timeStart = System.nanoTime();
		for (int i = 0; i < size / 2; i++) {
			boolean swaped = false;
			for (int j = i; j < size - i - 1; j++) {
				compareNumber++;
				if (this.array[j] > this.array[j + 1]) {
					swapNumber++;
					Comparable temp = this.array[j];
					this.array[j] = this.array[j + 1];
					this.array[j + 1] = (Integer) temp;
					swaped = true;
				}
			}
			for (int j = size - 2 - i; j > i; j--) {
				compareNumber++;
				if (this.array[j] < this.array[j - 1]) {
					swapNumber++;
					compareNumber++;
					Comparable temp = this.array[j];
					this.array[j] = this.array[j - 1];
					this.array[j - 1] = (Integer) temp;
					swaped = true;
				}
			}
			if (!swaped) {
				break;
			}
		}
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
	
	public long compareNumber(){
		return this.compareNumber;
	}

}
