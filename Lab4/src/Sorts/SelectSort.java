package Sorts;

import java.util.Arrays;

public class SelectSort implements Sorter<Integer> {

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
			int minIndex = i;
			for (int j = i + 1; j < size + 1; j++) {
				compareNumber++;
				if (this.array[j] < this.array[minIndex]) {
					minIndex = j;
				}
			}
			if(minIndex > i)
            {
				++swapNumber;
                Comparable temp = this.array[i];
    			this.array[i] = this.array[minIndex];
    			this.array[minIndex] = (Integer) temp;
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
	
	public long swapNumber(){
		return this.swapNumber;
	}
	
	public long compareNumber(){
		return this.compareNumber;
	}

}
