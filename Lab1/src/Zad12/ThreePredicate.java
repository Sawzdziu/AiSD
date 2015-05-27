package Zad12;
import java.util.function.Predicate;


public class ThreePredicate implements Predicate<Integer>{

	
	@Override
	public boolean test(Integer t) {
		return (t % 3 == 0);
	}

}
