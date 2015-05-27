package Sorts;

import java.util.Arrays;
import java.util.Random;

public class Test {

	public static final Integer[] array = new Integer[5000];
	public static final int size = array.length;

	public static void main(String[] args) {

		BubbleSort bubbleSortRandom = new BubbleSort();
		BubbleSort bubbleSortSorted = new BubbleSort();

		BubbleSortRemember bubbleRememberRandom = new BubbleSortRemember();
		BubbleSortRemember bubbleRememberSorted = new BubbleSortRemember();

		BubbleSortDual bubbleDualRandom = new BubbleSortDual();
		BubbleSortDual bubbleDualSorted = new BubbleSortDual();

		InsertSort insertSortRandom = new InsertSort();
		InsertSort insertSortSorted = new InsertSort();

		SelectSort selectSortRandom = new SelectSort();
		SelectSort selectSortSorted = new SelectSort();

		Random r = new Random();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < size; j++) {
				array[j] = r.nextInt(100);
			}
			Integer[] sortArray = Arrays.copyOf(array, array.length);
			Arrays.sort(sortArray);

			bubbleSortRandom.sort(array);
			bubbleRememberRandom.sort(array);
			bubbleDualRandom.sort(array);
			insertSortRandom.sort(array);
			selectSortRandom.sort(array);

			bubbleSortSorted.sort(sortArray);
			bubbleRememberSorted.sort(sortArray);
			bubbleDualSorted.sort(sortArray);
			insertSortSorted.sort(sortArray);
			selectSortSorted.sort(sortArray);
		}

		System.out.println("Ilosc danych: " + size);
		System.out.println("");
		System.out
				.println("===============================================================");
		System.out.println("\t\tAlgorytm BubbleSort");
		System.out
				.println("===============================================================");
		System.out.println("\t\tCzas\t\t\tCzas");
		System.out
				.println("BubbleSort random:\t\t\t" + bubbleSortRandom.time());
		System.out.println("Liczba porownan random: "
				+ bubbleSortRandom.compareNumber());
		System.out.println("Liczba przeniesien random: "
				+ bubbleSortRandom.swapNumber());
		System.out.println("\nBubbleSort sorted:\t\t\t"
				+ bubbleSortSorted.time());
		System.out.println("Liczba porownan sorted: "
				+ bubbleSortSorted.compareNumber());
		System.out.println("Liczba przeniesien sorted: "
				+ bubbleSortSorted.swapNumber());
		System.out.println("\nBubbleSortRemember random :\t\t"
				+ bubbleRememberRandom.time());
		System.out.println("Liczba przeniesien random: "
				+ bubbleRememberRandom.swapNumber());
		System.out.println("Liczba porownan random: "
				+ bubbleRememberRandom.compareNumber());
		System.out.println("\nBubbleSortRemember sorted :\t\t"
				+ bubbleRememberSorted.time());
		System.out.println("Liczba przepisan sorted: "
				+ bubbleRememberSorted.swapNumber());
		System.out.println("Liczba porownan sorted: "
				+ bubbleRememberSorted.compareNumber());
		System.out.println("\nBubbleSortDual random:\t\t\t"
				+ bubbleDualRandom.time());
		System.out.println("Liczba przepisan random: "
				+ bubbleDualRandom.swapNumber());
		System.out.println("Liczba porownan random: "
				+ bubbleDualRandom.compareNumber());
		System.out.println("\nBubbleSortDual sorted:\t\t\t"
				+ bubbleDualSorted.time());
		System.out.println("Liczba przepisan sorted: "
				+ bubbleDualSorted.swapNumber());
		System.out.println("Liczba porownan sorted: "
				+ bubbleDualSorted.compareNumber());

		System.out
				.println("\n==============================================================");
		System.out.println("\t\tAlgorytm InsertSort");
		System.out
				.println("==============================================================");
		System.out.println("\t\tCzas\t\t\tCzas");
		System.out
				.println("InsertSort random:\t\t\t" + insertSortRandom.time());
		System.out.println("Liczba przepisan random: "
				+ insertSortRandom.swapNumber());
		System.out.println("Liczba przepisan posortowana: "
				+ bubbleSortRandom.swapNumber());
		System.out.println("\nInsertSort sorted:\t\t\t"
				+ insertSortSorted.time());
		System.out.println("Liczba przepisan posortowana: "
				+ insertSortSorted.swapNumber());
		System.out.println("Liczba porownan posortowana: "
				+ insertSortSorted.compareNumber());
		// insertSort.toString(d);

		System.out
				.println("\n==============================================================");
		System.out.println("\t\tAlgorytm SelectSort");
		System.out
				.println("==============================================================");
		System.out.println("\t\tCzas\t\t\tCzas");
		System.out
				.println("SelectSort random:\t\t\t" + selectSortRandom.time());
		System.out.println("Liczba przepisan random: "
				+ selectSortRandom.swapNumber());
		System.out.println("Liczba porownan random: "
				+ selectSortRandom.compareNumber());
		System.out.println("\nSelectSort sorted:\t\t\t"
				+ selectSortSorted.time());
		System.out.println("Liczba przepisan posortowana: "
				+ selectSortSorted.swapNumber());
		System.out.println("Liczba porownan posortowana: "
				+ selectSortSorted.compareNumber());
		// selectSort.toString(e);

	}

}
