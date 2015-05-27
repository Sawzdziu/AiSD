package Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class Element {

	Object value;
	ArrayList<Element> array;
	Element next;
	

	public Element(Object value) {
		this.value = value;
		next = null;
		array = new ArrayList<Element>();
	}

	public Element(Element next, Object value) {
		this.value = value;
		this.next = next;
	}

	public ArrayList<Element> getArray() {
		return array;
	}

	public void setArray(ArrayList<Element> array) {
		this.array = array;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element next) {
		this.next = next;
	}

	public boolean isEmpty() {
		return value == null;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}


	public String toString() {
		return "" + value + "";
	}

	public String toStringLinked() {
		return array.toString();
	}

}
