package BinarySearch;

import java.util.Comparator;

public class IterBinarySearcher implements Searcher<String> {

	private Comparator<String> comparator = new Comparator<String>() {
	

		@Override
		public int compare(String o1, String o2) {
			if(o1.equals(o2)){
				return 1;
			}else 
				return 0;
		}
	};

	@Override
	public int search(String[] array, String value) {
		int lower = 0;
		int upper = array.length - 1;
		int index = 0, cmp = 0;
		while (lower <= upper
				&& (cmp = value.compareTo(array[index = (lower + upper) / 2])) != 0) {
			if (cmp < 0) {
				upper = index - 1;
			} else {
				lower = index + 1;
			}
		}
		return lower <= upper && cmp == 0 ? index : -(lower + 1);
	}

}