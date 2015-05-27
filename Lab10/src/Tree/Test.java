package Tree;

import java.util.Random;


public class Test {


	public static void main(String[] args) throws Exception {

		/*AVL avl = new AVL();
		avl.insert(54);
		avl.insert(50);
		avl.insert(17);
		avl.insert(72);
		avl.insert(76);
		avl.insert(67);
		avl.insert(12);
		avl.insert(23);
		avl.insert(9);
		avl.insert(14);
		avl.insert(19);
		System.out.println(avl.toString());
		avl.delete(17);
		System.out.println(avl.toString());*/
		
	/*	LinearHashTable linear = new LinearHashTable(5);
		Random generator = new Random();
		linear.dump();
		linear.put(15);
		linear.put(20);
		linear.put(12);
		linear.put(19);
		linear.dump();
		
		linear.remove(15);
		
		System.out.println("Randomowe wypełnienie: ");
		for(int i = 0; i < 60; i++){
			linear.put(generator.nextInt(60));
		}
		linear.dump();*/
		
		LinkedHashTable linked = new LinkedHashTable();
		Random generator = new Random();
		linked.dump();
		linked.put(15);
		linked.put(20);
		linked.put(12);
		linked.put(19);
		linked.dump();
		System.out.println("Wynik: " + linked.get(19));
		
		//linked.remove(15);
		System.out.println("Wynik: " + linked.get(49));
		
		
		System.out.println("Randomowe wypełnienie: ");
		for(int i = 0; i < 1000; i++){
			linked.put(generator.nextInt(200));
			
		}
		System.out.println("Wynik 153: " + linked.get(153));
		System.out.println("Wynik 68: " + linked.get(49));
		linked.dump();
		//System.out.println(linked);
	}

}
