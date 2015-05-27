package Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiMaps implements MultiMap<String, Integer>{

	private ArrayList<Word> array;
	
	public MultiMaps(){
		this.array = new ArrayList<Word>();
	}
	
	@Override
	public List<Integer> get(String key) {
		ArrayList<Integer> help;
		for(Word word: array){
			if(word.getKey().equals(key)){
				help = new ArrayList<Integer>(word.getValueArray());
				return help;
			}
		}
		return help = new ArrayList<Integer>();
	}

	@Override
	public void put(String key, Integer value) {
		Word<String, Integer> add = new Word<String, Integer>(key, value);
		boolean exist = false;
		for(Word word: array){
			if(word.getKey().equals(key)){
				word.addValue(value);
				exist = true;
				break;
			}
		}
		if(!exist){
			array.add(add);
		}
	}

	@Override
	public boolean containsKey(String key) {
		for(Word word: array){
			if(word.getKey().equals(key)){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Integer> remove(String key) {
		for(Word word: array){
			if(word.getKey().equals(key)){
				word.removeValue();
			}
		}
		return null;
	}

	@Override
	public void clear() {
		array.clear();
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

}
