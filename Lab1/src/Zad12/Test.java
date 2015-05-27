package Zad12;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;


public class Test {

	public static void main(String[] args) {
		Test.menu();
	}
		
	
	public static void menu(){
		boolean end = true;
		int helper = 0;
		int maxValue = 0;
		Scanner sc = new Scanner(System.in);
		while(end){
			System.out.println("Menu: ");
			System.out.println("1 - Generowanie liczb podzielnych przez 3 mniejszych od podanej.");
			System.out.println("2 - Filtrowanie liczb");
			System.out.println("3 - Podwajanie wartości na wyjściu");
			System.out.println("4 - Koniec");
			System.out.println("Wybierz interesujące Ciebie zadanie: ");
			helper = Integer.parseInt(sc.next());
			if(helper == 1){
				System.out.println("Podaj liczbę maksymalną: ");
				maxValue = Integer.parseInt(sc.next());
				ThreeAndFiveIterator threeAndFiveIterator = new ThreeAndFiveIterator(maxValue);
				while(!threeAndFiveIterator.isDone()){
					System.out.println(threeAndFiveIterator.current());
					threeAndFiveIterator.next();
				}
				System.out.println();
			}
			else if(helper == 2){
				System.out.println("Podaj liczbę maksymalną: ");
				maxValue = Integer.parseInt(sc.next());
				Iterator<Integer> threeAndFiveIterator = new ThreeAndFiveIterator(maxValue);
				Predicate<Integer> threePredicate = new ThreePredicate();
				Iterator<Integer> filterIterator = new FilterIterator(threeAndFiveIterator ,threePredicate);
				while(!filterIterator.isDone()){
					System.out.println(filterIterator.current());
					filterIterator.next();
				}
			}
			else if(helper == 3){
				System.out.println("Podaj liczbę maksymalną: ");
				maxValue = Integer.parseInt(sc.next());
				ThreeAndFiveIterator threeIterator = new ThreeAndFiveIterator(maxValue);
				Predicate<Integer> threePredicate = new ThreePredicate();
				Function<Integer,Integer> threeMultiply = new ThreeMultiply();
				FilterIterator filterIterator = new FilterIterator(threeIterator ,threePredicate);
				while(!filterIterator.isDone()){
					System.out.println(threeMultiply.apply(filterIterator.current()));
					filterIterator.next();
				}
			}
			else if(helper == 4){
				end = false;
				System.out.println("Aufwiedersehen");
			}
		}

	}
}
