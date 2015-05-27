import java.util.Scanner;
import java.util.function.Function;




public class Zad4 implements Function<Integer, Integer>{

	//static Function<Integer, Integer> pow = new Function<Integer, Integer>(){
		//public Integer apply(Integer t){
			//return 2 * t;
		//}
	//};
	
	@Override
	public Integer apply(Integer t) {
		return 2 * t;
	}
	
	default <Integer> andThen(Function<>)
	
	void write(int value){
		for(int i = 0; i <= value; i++){
			Integer helper = new Integer(i);
			if(helper % 3 == 0){
				System.out.print( + ", ");
			}
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj maksymalną wartość: ");
		//Zad4.write(Integer.parseInt(sc.next()));
		Zad4 kupa = new Zad4();
		for(int i = 0; i < maxValue; i++)
			kupa.
	}

}
