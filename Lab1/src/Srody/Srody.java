package Srody;
import java.time.LocalDate;
import java.util.Scanner;


public class Srody {


	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj pierwszą date");
		System.out.println("Rok: ");
		int firstYear = sc.nextInt();
		System.out.println("Miesiąc: ");
		int firstMonth = sc.nextInt();
		System.out.println("Dzień: ");
		int firstDay = sc.nextInt();
		LocalDate first = LocalDate.of(firstYear, firstMonth, firstDay);
		System.out.println("Podaj drugą date");
		System.out.println("Rok: ");
		int secondYear = sc.nextInt();
		System.out.println("Miesiąc: ");
		int secondMonth = sc.nextInt();
		System.out.println("Dzień: ");
		int secondDay = sc.nextInt();
		LocalDate last = LocalDate.of(secondYear, secondMonth, secondDay);
		Generator g = new Generator(first, last);
		while(g.isDone()){
			System.out.println(g.current);
			g.next();
		}
		
		g.first();
		System.out.println(g.current);
		
	}
	
}
