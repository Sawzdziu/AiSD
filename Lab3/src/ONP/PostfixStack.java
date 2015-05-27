package ONP;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class PostfixStack<T> implements Stack<T>{
	
	private final List<T> list;
	
	public PostfixStack(){
		list = new ArrayList<T>();
	}

	@Override
	public void push(Object value) {
		list.add((T) value);
	}

	@Override
	public T pop() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return list.remove(list.size() - 1);
	}

	@Override
	public T peek() throws EmptyStackException {
		Object result = pop();
		push(result);
		return (T) result;
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


}
