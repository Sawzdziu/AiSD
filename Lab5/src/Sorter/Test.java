package Sorter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Test {

	public static final Integer[] array = new Integer[500];
	public static final int size = array.length;
	public static final int number_of_test = 6;

	public static void main(String[] args) {

		long quickSortTime = 0;
		long quickRandomTime = 0;
		long quickReverseTime = 0;

		int quickSortSwapNumber = 0;
		int quickSortCompareNumber = 0;

		int quickRandomSwapNumber = 0;
		int quickRandomCompareNumber = 0;

		int quickReverseSwapNumber = 0;
		int quickReverseCompareNumber = 0;

		int mergeSortTime = 0;
		int mergeRandomTime = 0;
		int mergeReverseTime = 0;

		int mergeSortSwapNumber = 0;
		int mergeSortCompareNumber = 0;

		int mergeRandomSwapNumber = 0;
		int mergeRandomCompareNumber = 0;

		int mergeReverseSwapNumber = 0;
		int mergeReverseCompareNumber = 0;

		long timSortTime = 0;
		long timRandomTime = 0;
		long timReverseTime = 0;

		Random r = new Random();
		for (int i = 0; i < number_of_test; i++) {

			QuickSort quickSort = new QuickSort();
			QuickSort quickRandom = new QuickSort();
			QuickSort quickReverse = new QuickSort();

			MergeSort mergeSort = new MergeSort();
			MergeSort mergeRandom = new MergeSort();
			MergeSort mergeReverse = new MergeSort();

			for (int j = 0; j < size; j++) {
				array[j] = r.nextInt(500);
			}
			Integer[] sortArray = Arrays.copyOf(array, array.length);
			Integer[] reverseArray = Arrays.copyOf(array, array.length);
			Arrays.sort(sortArray);
			Arrays.sort(reverseArray, Collections.reverseOrder());

			quickSort.sort(sortArray);
			quickSortTime += quickSort.getTime();
			quickSortCompareNumber += quickSort.compareNumber();
			quickSortSwapNumber += quickSort.swapNumber();

			quickRandom.sort(array);
			quickRandomTime += quickRandom.getTime();
			quickRandomSwapNumber += quickRandom.swapNumber();
			quickRandomCompareNumber += quickRandom.compareNumber();

			quickReverse.sort(reverseArray);
			quickReverseTime += quickReverse.getTime();
			quickReverseSwapNumber += quickReverse.swapNumber();
			quickReverseCompareNumber += quickReverse.compareNumber();

			mergeSort.sort(sortArray);
			mergeSortTime += mergeSort.getTime();
			mergeSortSwapNumber += mergeSort.swapNumber();
			mergeSortCompareNumber += mergeSort.compareNumber();

			mergeRandom.sort(array);
			mergeRandomTime += mergeRandom.getTime();
			mergeRandomSwapNumber += mergeSort.swapNumber();
			mergeRandomCompareNumber += mergeSort.compareNumber();

			mergeReverse.sort(reverseArray);
			mergeReverseTime += mergeReverse.getTime();
			mergeReverseSwapNumber += mergeReverse.swapNumber();
			mergeReverseCompareNumber += mergeReverse.compareNumber();

			long timeSortStart = System.nanoTime();
			Arrays.sort(sortArray);
			timSortTime += System.nanoTime() - timeSortStart;

			long timeRandomStart = System.nanoTime();
			Arrays.sort(array);
			timRandomTime += System.nanoTime() - timeRandomStart;

			long timeReverseStart = System.nanoTime();
			Arrays.sort(reverseArray);
			timReverseTime += System.nanoTime() - timeReverseStart;

		}

		System.out.println("Ilosc danych: " + size);
		System.out.println("");
		System.out
				.println("===============================================================");
		System.out.println("\t\tAlgorytm QuickSort");
		System.out
				.println("===============================================================");
		System.out.println("\t\tCzas\t\t\tCzas");
		System.out.println("QuickSort Random:\t\t\t" + (quickRandomTime / 6));
		System.out.println("Liczba porownan Random: "
				+ quickRandomCompareNumber);
		System.out.println("Liczba przeniesien Random: "
				+ quickRandomSwapNumber);
		System.out.println("\nQuickSort Sorted: \t\t\t" + (quickSortTime / 6));
		System.out.println("Liczba porownan Sorted: " + quickSortCompareNumber);
		System.out.println("Liczba przeniesien Sorted: " + quickSortSwapNumber);

		System.out.println("\nQuickSort Reverse: \t\t\t"
				+ (quickReverseTime / 6));
		System.out.println("Liczba porownan Reverse: "
				+ quickReverseCompareNumber);
		System.out.println("Liczba przeniesien Reverse: "
				+ quickReverseSwapNumber);

		System.out
				.println("\n==============================================================");
		System.out.println("\t\tAlgorytm MergeSort");
		System.out
				.println("==============================================================");
		System.out.println("\t\tCzas\t\t\tCzas");
		System.out.println("MergeSort Random:\t\t\t" + (mergeRandomTime / 6));
		System.out.println("Liczba przepisan Random: " + mergeRandomSwapNumber);
		System.out.println("Liczba porównań Random: "
				+ mergeRandomCompareNumber);
		System.out.println("\nMergeSort Sorted:\t\t\t" + (mergeSortTime / 6));
		System.out.println("Liczba przepisan Sorted: " + mergeSortSwapNumber);
		System.out.println("Liczba porównań Sorted: " + mergeSortCompareNumber);
		System.out.println("\nMergeSort Reverse:\t\t\t"
				+ (mergeReverseTime / 6));
		System.out.println("Liczba przepisan Reverse: "
				+ mergeReverseSwapNumber);
		System.out.println("Liczba porównań Reverse: "
				+ mergeReverseCompareNumber);

		System.out
				.println("\n==============================================================");
		System.out.println("\t\tAlgorytm TimSort");
		System.out
				.println("==============================================================");
		System.out.println("\t\tCzas\t\tCzas");
		System.out.println("TimSort Random:\t\t\t" + (timSortTime / 6));
		System.out.println("\nTimSort Sorted:\t\t\t" + (timRandomTime / 6));
		System.out.println("\nTimSort Reverse:\t\t" + (timReverseTime / 6));

	}
}
