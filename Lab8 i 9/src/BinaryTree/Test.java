package BinaryTree;

import java.util.function.Consumer;

public class Test {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		/*
		 * bt.add(20); bt.add(15); bt.add(30); bt.add(25); bt.add(40);
		 * bt.add(23); bt.add(28);
		 */

		bt.add(5);
		bt.add(3);
		bt.add(1);
		bt.add(7);

		System.out.println("Root: " + bt.getRoot()); // bst.add("Zegar");
		// System.out.println("\nAlfabetycznie: "); bt.inOrder(bt.getRoot());
		// System.out.println("\nOd korzenia: "); bt.preOrder(bt.getRoot());
		// System.out.println("\nOd dolu: "); bt.postOrder(bt.getRoot());
		System.out.println("\nWysokosc drzewa: " + bt.findHeight(bt.getRoot()));
		System.out.println("Liczba wezlow drzewa: "
				+ bt.amountOfNodes(bt.getRoot()));
		System.out.println("Liczba lisci: " + bt.amountOfLeaves(bt.getRoot()));
		System.out.println("Liczba wezlow ponizej wartosci korzenia: "
				+ bt.amountNodeBelow(bt.getRoot()));
		System.out.println("Odleglosc od korzenia: "
				+ (bt.distanceFromRoot(bt.getRoot(), 4)));

		System.out.println("\nPo DSW wyglad drzewa: ");

		System.out.println(bt.toString());

		/*
		 * bt.dswAlgorithm(); System.out.println("Root: " + bt.getRoot());
		 * System.out.println("\nAlfabetycznie: "); bt.inOrder(bt.getRoot());
		 * System.out.println("\nOd korzenia: "); bt.preOrder(bt.getRoot());
		 * System.out.println("\nOd dolu: "); bt.postOrder(bt.getRoot());
		 * //System.out.println(bt.toString());
		 */
		System.out.println("InOrder: ");

		bt.inOrder(bt.getRoot(), new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.println(value);
			}
		});

		System.out.println("PreOrder: ");

		bt.preOrder(bt.getRoot(), value -> System.out.println(value));

		System.out.println("PostOrder: ");

		bt.postOrder(bt.getRoot(), new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.println(value);
			}
		});

		System.out.println("Wyszukiwanie wszerz: ");
		
		bt.acrossOrder(bt.getRoot(), new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.println(value);
			}
		});
		
		System.out.println("BTree: ");
		
		BTree bTree = new BTree();
		bTree.insert(1, 12);
		bTree.insert(1, 12312);
		bTree.insert(0, 3);

	}
}
