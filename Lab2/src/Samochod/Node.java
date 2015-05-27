package Samochod;

public class Node {

	Samochod data;
	Node next;
	Node previous;
	
	public Node(Node next, Samochod car){
		this.next = next;
		this.data = car;
	}
	
	public Node(Samochod car, Node next, Node prev){
		this.data = car;
		this.next = next;
		this.previous = prev;
	}

	public Node(Samochod data) {
		this.data = data;
	}

	public Samochod getData() {
		return data;
	}

	public void setData(Samochod data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}
	

	public void setNext(Node _next) {
		next = _next;
	}
	
	public void setPrevious(Node _prev){
		this.previous = _prev;
	}

	public Node getPrevious() {
		return previous;
	}
	
	public void attachBefore(Node next) {
		Node previous = next.getPrevious();
		setNext(next);
		setPrevious(previous);
		next.setPrevious(this);
		previous.setNext(this);
	}
	
	public void detach() {
		previous.setNext(next);
		next.setPrevious(previous);
	}
	
	
}
