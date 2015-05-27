package Dictionary;

import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		Dictionary dictionary = new Dictionary();

		dictionary.put("Jakub", 1);
		dictionary.put("Jabol", 2);
		dictionary.put("Mama", 4);
		dictionary.put("Piosenka", 5);
		dictionary.put("Slask", 1949);
		dictionary.put("Popek", 4);
		dictionary.put("Jakub", 100);

		Iterator<String> keyIterator = dictionary.keyIterator();
		Iterator<Integer> valueIterator =  dictionary.valueIterator();

		//while(keyIterator.hasNext()){
		//	System.out.println(keyIterator.next());
		//}
		
		//while(valueIterator.hasNext()){
		//	System.out.println(valueIterator.next());
		//}

		/* dictionary.toString();
		 System.out.println(dictionary.size());

		 System.out.println(dictionary.containsKey("Foo"));
		 System.out.println(dictionary.get("Foo"));
		 System.out.println("Usuwam Popka: " + dictionary.remove("Popek"));
		 System.out.println(dictionary.get("Jakub"));*/
		
		MultiMaps multi = new MultiMaps();
		multi.put("foo", 1);
		multi.put("foo", 2);
		multi.put("foo", 123);
		List<Integer> fooValues = multi.get("foo");
		System.out.println(fooValues);
		multi.put("foo", 3);
		List<Integer> anotherFooValues = multi.get("foo");
		System.out.println(anotherFooValues);
		anotherFooValues.add(4);
		System.out.println(anotherFooValues);
		anotherFooValues = multi.get("foo");
		System.out.println(anotherFooValues);
		
		/*DictionarySet dictionarySet = new DictionarySet();
		
		dictionarySet.add("Koks");
		dictionarySet.add("Jajo");
		dictionarySet.add("Jajo");
		dictionarySet.add("Malpa");
		dictionarySet.add("Hit");
		
		System.out.println(dictionarySet.contains("Jajo"));
		System.out.println(dictionarySet.contains("Malpa"));
		
		dictionarySet.toString();*/
		
		
		
	}

}
