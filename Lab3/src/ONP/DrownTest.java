package ONP;

public class DrownTest {

	public static void main(String[] args) {
		DrowningStack drowningStack = new DrowningStack(5);
		drowningStack.push(1);
		drowningStack.push(2);
		drowningStack.push(3);
		drowningStack.push(4);
		drowningStack.push(5);
		drowningStack.display();
		System.out.println("");
		drowningStack.push(6);
		drowningStack.push(7);
		drowningStack.push(8);
		drowningStack.push(9);
		drowningStack.push(10);
		drowningStack.push(11);
		drowningStack.display();
		System.out.println("");
		drowningStack.size();
		drowningStack.clear();
		drowningStack.push(1);
		drowningStack.display();
	}
}
