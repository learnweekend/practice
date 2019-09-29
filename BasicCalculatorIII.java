package leetcode;

import java.util.Stack;

public class BasicCalculatorIII {
	
	public static int calculate(String s) {
		Stack<Integer> valStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		int N = s.length();

		for (int i = 0; i < N; i++) {
			
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				StringBuffer sb = new StringBuffer();
				while (i < N && s.charAt(i) >= '0' && s.charAt(i) <= '9')
					sb.append(s.charAt(i++)); // note i++
				valStack.push(Integer.parseInt(sb.toString())); // push the operand to valStack
			}

			if (i < N && s.charAt(i) == '(') // if '(' push into opStack.
				opStack.push(s.charAt(i));

			else if (i < N && s.charAt(i) == ')') { // if ')' pop and eval
				while (opStack.peek() != '(')
					valStack.push(calculate(valStack.pop(), opStack.pop(), valStack.pop()));
				opStack.pop(); // note : make sure to remove the ( from opStack
			} else if (i < N && (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')) {
				while (!opStack.isEmpty() && checkPrecedence(s.charAt(i), opStack.peek()))
					valStack.push(calculate(valStack.pop(), opStack.pop(), valStack.pop()));
				opStack.push(s.charAt(i));
			}
		} // parsing the expression is complete.

		while (!opStack.empty()) // check if opStack is empty, if not process them.
			valStack.push(calculate(valStack.pop(), opStack.pop(), valStack.pop()));

		return valStack.pop(); // return final result.
	}

	// return true if op2 is higher precedence than op1.
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
			if (operand1 == 0)
				return 0;
			else
				return operand2 / operand1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(calculate("-1+4*3/3/3")); // = 11
		System.out.println(calculate(" 6-4 / 2 ")); // = 4
		System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")) ; // = 21
		System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); //=-12
	}

}
