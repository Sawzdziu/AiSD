package Dictionary;

import java.util.ArrayList;

public class Word<String, Integer>{
	
	private String key;
	private Integer value;
	private ArrayList<Integer> valueArray = new ArrayList<Integer>();
	
	public Word(String word, Integer value){
		this.key = word;
		this.value = value;
		valueArray.add(value);
	}

	public ArrayList getValueArray() {
		return valueArray;
	}

	public void setValueArray(ArrayList<Integer> valueArray) {
		this.valueArray = valueArray;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public void addValue(Integer value){
		valueArray.add(value);
	}
	
	public void removeValue(){
		int last = valueArray.size() - 1;
		valueArray.remove(last);
	}
	 

}
