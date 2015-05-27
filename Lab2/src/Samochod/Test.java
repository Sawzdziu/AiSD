package Samochod;

public class Test {

	public static void main(String[] args) {
		Samochod car1 = new Samochod("DW3456", "Opel", "Astra", 2002, 1.6,
				"metallic");
		Samochod car2 = new Samochod("KR0982", "BMW", "M3", 2012, 2.6, "blue");
		Samochod car3 = new Samochod("WPR666", "Volvo", "S40", 2005, 1.8,
				"black");
		Samochod car4 = new Samochod("DO BUZI", "Porsche", "Panamera", 2014,
				2.2, "white");

		
		/*  ArrayList array = new ArrayList(10); ArrayList arrayA = new
		  ArrayList(3); arrayA.add(car2); arrayA.add(car4); array.add(car1);
		  array.add(car2); array.add(car3); array.addAll(arrayA);
		  System.out.println(array.size()); Iterator arrayIterator =
		  array.iterator(); arrayIterator.first(); arrayIterator.last();
		  System.out.println(arrayIterator.current());
		  System.out.println(array.contains(car4)); array.add(car4);
		  System.out.println(array.indexOf(car4));
		  System.out.println(array.contains(car4)); array.delete(car4);
		  System.out.println(array.contains(car4)); arrayIterator.next();
		  System.out.println(arrayIterator.current()); arrayIterator.next();
		  System.out.println(arrayIterator.current());*/
		 
		
		LinkedList linked = new LinkedList();
		LinkedList linkedA = new LinkedList();
		linked.add(car2);//2012
		linked.add(car3);
		linked.add(car4);
		linked.add(car1);
		System.out.println(linked.size());
		linkedA.add(car3);
		linkedA.add(car2);
		linkedA.add(car4);
		System.out.println(linkedA.size());
		linked.addAll(linkedA);
		Iterator linkedIterator = linked.iterator();
		linkedIterator.first();
		System.out.println(linkedIterator.current());
		linkedIterator.next();
		System.out.println(linkedIterator.current());
		linkedIterator.next();
		System.out.println(linkedIterator.current());
		linkedIterator.next();
		System.out.println(linkedIterator.current());
		
		
		/*
		  DoubleLinkedList dable = new DoubleLinkedList(); 
		  DoubleLinkedList dableA = new DoubleLinkedList(); 
		  dable.add(car1); 
		  dable.add(car4);
		  dable.add(car2);
		  dable.add(car3); 
		  dable.insert(0, car3);
		  System.out.println(dable.size());
		  System.out.println("Metoda get: " + dable.get(0));
		  dableA.add(car3); 
		  dableA.add(car2);
		  dableA.add(car1); 
		  //dable.addAll(dableA); 
		  Iterator dableIterator = dable.iterator(); 
		  dableIterator.first();
		  System.out.println(dableIterator.current());
		  System.out.println(dable.size()); 
		  dable.delete(car1);
		  System.out.println(dable.size()); 
		  dableIterator.next();
		  System.out.println(dableIterator.current()); 
		  dableIterator.next();
		  System.out.println(dableIterator.current()); 
		  dableIterator.next();
		  System.out.println(dableIterator.current()); 
		  dableIterator.next();
		  System.out.println(dableIterator.current()); 
		  dableIterator.next();
		  System.out.println(dableIterator.current()); 
			*/
	}
}
