package Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort implements Sorter<Integer> {

	private Integer[] array;
	private int size;
	private long time;
	private long swapNumber;
	private long compareNumber;
	IntegerComparator comparator = new IntegerComparator();

	@Override
	public Comparable[] sort(Comparable[] array) {
		long timeStart = System.nanoTime();
		this.array = (Integer[]) Arrays.copyOf(array, array.length);
		mergeSort(this.array);
		this.time = System.nanoTime() - timeStart;
		//toString(this.array);
		return this.array;
	}
	
	public void mergeSort(Integer[] array){
		if (array.length > 1) {
			Integer[] left = leftHalf(array);
			Integer[] right = rightHalf(array);

			mergeSort(left);
			mergeSort(right);

			merge(array, left, right);
		}
	}

	public Integer[] leftHalf(Integer[] array) {
		int size1 = array.length / 2;
		Integer[] left = new Integer[size1];
		for (int i = 0; i < size1; i++) {
			left[i] = array[i];
		}
		return left;
	}

	public Integer[] rightHalf(Integer[] array) {
		int half = array.length / 2;
		int end = array.length - half;
		Integer[] right = new Integer[end];
		for (int i = 0; i < end; i++) {
			right[i] = array[i + half];
		}
		return right;
	}

	public void merge(Integer[] result, Integer[] left, Integer[] right) {
		int leftIndex = 0; // index into left array
		int rightIndex = 0; // index into right array

		for (int i = 0; i < result.length; i++) {
			if (rightIndex >= right.length
					|| (leftIndex < left.length && left[leftIndex] <= right[rightIndex])) {
				result[i] = left[leftIndex]; // take from left
				leftIndex++;
			} else {
				result[i] = right[rightIndex]; // take from right
				rightIndex++;
			}
		}
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
	
	public long getTime(){
		return this.time;
	}

	/*
	 * public Comparable[] sort(Comparable[] array) { long timeStart =
	 * System.nanoTime(); this.size = array.length - 1; this.array = new
	 * Integer[array.length]; this.array = (Integer[]) Arrays.copyOf(array,
	 * array.length); mergeSort(this.array, 0, array.length - 1); time =
	 * System.nanoTime() - timeStart; toString(array); return array; }
	 * 
	 * private Integer[] mergeSort(Integer[] array, int startIndex, int
	 * endIndex) { if (startIndex == endIndex) { Integer[] result = new
	 * Integer[this.size]; result[0] = array[startIndex]; return result; } int
	 * splitIndex = startIndex + (endIndex - startIndex) / 2; return
	 * merge(mergeSort(array, startIndex, splitIndex), mergeSort(array,
	 * splitIndex + 1, endIndex)); }
	 * 
	 * private Integer[] merge(Integer[] left, Integer[] right) { Integer[]
	 * result = new Integer[this.size]; int leftSize = left.length; int
	 * rightSize = right.length; int k = 0; int i = 0; int j = 0; while (i <
	 * leftSize && j < rightSize) { if (comparator.compare(left[i], right[j]) <=
	 * 0) { result[k] = left[i]; k++; i++; } else { result[k] = right[j]; k++;
	 * j++; } } while (i < leftSize) { result[k] = left[i]; k++; i++; } while (j
	 * < rightSize) { result[k] = right[j]; k++; j++; }
	 * System.out.println("Tu byłem");
	 * 
	 * return result; }
	 */
}
