package ONP;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class IntegerStack implements Stack<Integer>{

	private final List<Integer> list;
	
	public IntegerStack(){
		list = new ArrayList<Integer>();
	}
	
	@Override
	public void push(Integer value) {
		list.add(value);
	}

	@Override
	public Integer pop() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return list.remove(list.size() - 1);
	}

	@Override
	public Integer peek() throws EmptyStackException {
		Integer result = pop();
		push(result);
		return result;
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public Integer shift(){
		return list.remove(0);
	}
	
	public void unshift(Integer value){
		list.add(0, value);
	}

}
