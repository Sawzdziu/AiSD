package BinarySearch;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		
		  String[] array = new String[] { "Hej", "lalka", "papa", "auto",
		  "japa" };
		  
		  IterBinarySearcher search = new IterBinarySearcher();
		  
		  System.out.println(search.search(array, "ook"));
		  
		 //System.out.println(Arrays.binarySearch(array, "lalka"));
		 

		/**
		 * index możemy zapisać jako index = ((upper - lower) /2 + lower);
		 * Wartosci najwieksze musza być o 1 mniejsze od granicznych dla
		 * zadanych typow int, double...
		 * 
		 */

		
		  BinarySearchTree bst = new BinarySearchTree();
		  
		  bst.add("Kaszanka"); bst.add("Ala"); bst.add("Juma");
		  bst.add("Jwfca"); bst.add("Kasztan"); bst.add("Zegar");
		  bst.add("Aaa"); bst.add("Zegarki");
		  
		  System.out.println("Root: " + bst.getRoot()); // bst.add("Zegar");
		  System.out.println("\nAlfabetycznie: "); bst.inOrder(bst.getRoot());
		  System.out.println("\nOd korzenia: "); bst.preOrder(bst.getRoot());
		  System.out.println("\nOd dolu: "); bst.postOrder(bst.getRoot());
		  System.out.println("\nWysokosc drzewa: " +
		  bst.findHeight(bst.getRoot()));
		  System.out.println("Liczba wezlow drzewa: " +
		  bst.amountOfNodes(bst.getRoot()));
		  System.out.println("Liczba lisci: " +
		  bst.amountOfLeaves(bst.getRoot()));
		  System.out.println("Liczba wezlow ponizej wartosci korzenia: " +
		  bst.amountNodeBelow(bst.getRoot()));
		  System.out.println("Odleglosc od korzenia: " + (bst.distanceFromRoot(bst.getRoot(), "Juma")));
		 
	}
}
