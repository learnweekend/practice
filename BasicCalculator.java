package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/description/
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 * 
 * Example 1: Input: "1 + 1" Output: 2
 * 
 * Example 2: Input: " 2-1 + 2 " Output: 3
 * 
 * Example 3: Input: "(1+(4+5+2)-3)+(6+8)" Output: 23
 *
 */
public class BasicCalculator {

	public static int calculate(String s) {
		Stack<Integer> valStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		int N = s.length();

		for (int i = 0; i < N; i++) {

			if (s.charAt(i) == ' ')
				continue;

			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				StringBuffer sb = new StringBuffer();
				while (i < N && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					sb.append(s.charAt(i++));
				}
				valStack.push(Integer.parseInt(sb.toString())); // push the operand to valStack
			}

			if (i < N && s.charAt(i) == '(') { // if '(' push into opStack.
				opStack.push(s.charAt(i));
			}

			else if (i < N && s.charAt(i) == ')') { // if ')' pop and eval
				while (opStack.peek() != '(') {
					int value = calculate(valStack.pop(), opStack.pop(), valStack.pop());
					valStack.push(value); // push the sum to valStack
				}
				opStack.pop();
			}

			else if (i < N && (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')) {
				while (!opStack.isEmpty() && checkPrecedence(s.charAt(i), opStack.peek())) {
					int value = calculate(valStack.pop(), opStack.pop(), valStack.pop());
					valStack.push(value);
				}
				opStack.push(s.charAt(i));
			}
		} // parsing the expression is complete.

		while (!opStack.empty()) { // check if opStack is empty, if not process them.
			valStack.push(calculate(valStack.pop(), opStack.pop(), valStack.pop()));
		}
		return valStack.pop(); // return final result.
	}

	// return true of op2 is higher precedence than op1.
	private static boolean checkPrecedence(char op1, char op2) {

		if (op2 == '(' || op2 == ')')
			return false;

		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	private static int calculate(int operand1, char operator, int operand2) {

		switch (operator) {
		case '+':
			return operand2 + operand1;
		case '-':
			return operand2 - operand1;
		case '*':
			return operand2 * operand1;
		case '/':
			if (operand2 == 0)
				return 0;
			else
				return operand2 / operand1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));  //2
		System.out.println(calculate(" 2-1 + 2 ")); // 3
		System.out.println(calculate(" (1+(4+5+2)-3)+(6+8) "));  // 23
	}
}
