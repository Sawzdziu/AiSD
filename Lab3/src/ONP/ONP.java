package ONP;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ONP {

	private String infixString;
	private String postfixString;
	private double result;

	public ONP(String expression) {
		this.infixString = expression;
		this.postfixString = "";
		convertToPostfix();
		result = calculate();
	}

	private void convertToPostfix() {
		PostfixStack<String> stack = new PostfixStack<String>();
		StringTokenizer ststringTokenizer = new StringTokenizer(infixString,
				"+-*/^!log", true);

		while (ststringTokenizer.hasMoreTokens()) {
			String oneChar = ststringTokenizer.nextToken();

			if (oneChar.equals("+") || oneChar.equals("*")
					|| oneChar.equals("-") || oneChar.equals("/")
					|| oneChar.equals("^") || oneChar.equals("!")
					|| oneChar.equals("log")) {
				while (!stack.isEmpty()
						&& priority(stack.peek()) >= priority(oneChar)) {
					postfixString += stack.pop() + " ";
				}
				stack.push(oneChar);
			}
			else
				postfixString += oneChar + " ";
		}
		while (!stack.isEmpty())
			postfixString += stack.pop() + " ";
	}

	public static int priority(String operation) {
		if (operation.equals("+") || operation.equals("-"))
			return 1;
		else if (operation.equals("*") || operation.equals("/"))
			return 2;
		else if (operation.equals("^") || operation.equals("!")
				|| operation.equals("log"))
			return 3;
		else
			return 0;
	}

	private double calculate() {

		PostfixStack<Double> stack = new PostfixStack<Double>();

		double fractal = 1.0;
		StringTokenizer stringTokenizer = new StringTokenizer(postfixString,
				" ");

		while (stringTokenizer.hasMoreTokens()) {

			String oneChar = stringTokenizer.nextToken();

			if (!oneChar.equals("+") && !oneChar.equals("*")
					&& !oneChar.equals("-") && !oneChar.equals("/")
					&& !oneChar.equals("^") && !oneChar.equals("l") && !oneChar.equals("!")) {
				double value = Double.parseDouble(oneChar);
				stack.push(value);
			} else {
				switch (oneChar.charAt(0)) {
				case '*': {
					double firstValue = stack.pop();
					double secondValue = stack.pop();
					stack.push(secondValue * firstValue);
					break;
				}
				case '+': {
					double firstValue = stack.pop();
					double secondValue = stack.pop();
					stack.push(secondValue + firstValue);
					break;
				}
				case '-': {
					double firstValue = stack.pop();
					double secondValue = stack.pop();
					stack.push(secondValue - firstValue);
					break;
				}
				case '/': {
					double firstValue = stack.pop();
					double secondValue = stack.pop();
					stack.push(secondValue / firstValue);
					break;
				}
				case '^': {
					double firstValue = stack.pop();
					double secondValue = stack.pop();
					stack.push(Math.pow(secondValue, firstValue));
					break;
				}
				case '!': {
					double firstValue = stack.pop();
					for (int i = 1; i <= firstValue; i++) {
						fractal = fractal * i;
					}
					stack.push(fractal);
					break;
				}
				case 'l': {
					double firstValue = stack.pop();
					double value = Math.log10(firstValue);
					stack.push(value);
					break;
				}
				}
			}
		}
		return stack.pop();
	}

	public String toString() {
		return postfixString + "\nWynik: " + result;
	}

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj wyrażenie infiksowe: ");

		String wyrazenie = scanner.nextLine();

		ONP onp = new ONP(wyrazenie);

		System.out.println("Wyrażenie postfiksowe: " + onp);
	}

}
