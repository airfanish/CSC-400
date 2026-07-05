package criticalThinking;

import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PostfixCalculator {

	// create method evaluatePostfix(expression)
	public int evaluatePostfix(String expression) {

		// create an empty stack
		Stack<Integer> numberStack = new Stack<>();

		// Split expression into tokens wherever there is a space
		String[] tokens = expression.split(" ");

		// Begin for loop

		for (String token : tokens) {

			// token validation
			try {
				int number = Integer.parseInt(token); // convert token to int
				numberStack.push(number); // push number onto stack
			}

			// operator validation
			catch (NumberFormatException e) {

				if (numberStack.size() < 2) {
					System.out.println("Invalid postfix expression.");
					return 0;
				}

				// addition
				if (token.equals("+")) {
					int secondValue = numberStack.pop();
					int firstValue = numberStack.pop();
					int result = firstValue + secondValue;
					numberStack.push(result);
				}

				// subtraction
				else if (token.equals("-")) {
					int secondValue = numberStack.pop();
					int firstValue = numberStack.pop();
					int result = firstValue - secondValue;
					numberStack.push(result);
				}

				// multiplication
				else if (token.equals("*")) {
					int secondValue = numberStack.pop();
					int firstValue = numberStack.pop();
					int result = firstValue * secondValue;
					numberStack.push(result);
				}

				// division
				else if (token.equals("/")) {
					int secondValue = numberStack.pop();
					int firstValue = numberStack.pop();
					if (secondValue == 0) {
						System.out.println("Division by zero not permitted.");
						return 0;
					}
					int result = firstValue / secondValue;
					numberStack.push(result);
				}

				// division %
				else if (token.equals("%")) {
					int secondValue = numberStack.pop();
					int firstValue = numberStack.pop();
					if (secondValue == 0) {
						System.out.println("Division by zero not permitted.");
						return 0;
					}
					int result = firstValue % secondValue;
					numberStack.push(result);
				}

				// invalid tokens
				else {
					System.out.println("Invalid postfix expression.");
					return 0;
				}
			}
		}

		if (numberStack.size() == 1) {
			return numberStack.peek();
		} else {
			System.out.println("Invalid postfix expression.");
			return 0;
		}

	}

	// main: testing
	
	public static void main(String[] args) {
		
		PostfixCalculator calculator = new PostfixCalculator();
		
		System.out.println("\nCalculator:\n");
		
		// Test valid postfix expression with single-digit operands
		String expression1 = "4 2 * 3 +";
		System.out.println("Result 1: " + calculator.evaluatePostfix(expression1));

		// Test valid postfix expression with multi-digit operands
		String expression2 = "55 69 + 87 *";
		System.out.println("Result 2: " + calculator.evaluatePostfix(expression2));

		// Test invalid postfix expression
		String expression3 = "12 56 @ 4 #";
		System.out.println("Result 3: " + calculator.evaluatePostfix(expression3));
		
		//Test missing operand
		String expression4 = "4 2 * +";
		System.out.println("Result 4: " + calculator.evaluatePostfix(expression4));

		System.out.println("\nReading expressions from file:\n");
		// Read postfix expressions from text file
		calculator.readExpressionsFromFile("expressions.txt");

	}

	// read from text file
	public void readExpressionsFromFile(String fileName) {

		try {
			File file = new File(fileName);
			Scanner inputFile = new Scanner(file);

			while (inputFile.hasNextLine()) {
				String expression = inputFile.nextLine(); // reads expression from file
				System.out.println("Result: " + evaluatePostfix(expression));
			}
			inputFile.close(); // close the file
		}

		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
}
