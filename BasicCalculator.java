package all;

import java.util.Stack;

/*
 * Implement a basic calculator to evaluate a simple expression string.
	The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
	The integer division should truncate toward zero.
	You may assume that the given expression is always valid. Some examples:
	"3+2*2" = 7
	" 3/2 " = 1
	" 3+5 / 2 " = 5
	https://leetcode.com/problems/basic-calculator-ii/description/
 */

public class BasicCalculator {
	
	/*
	 * Solution :  
	 * 1. Use two stacks, one for operands and one for operators.
	 * 2. Parse the expression and push values to valueStack and operators to opStack.
	 * 3. Pop the operators and and evaluate based on higher precedence and push result to value stack.
	 * 4. after the parse complete, check for any operands on opStack and process them.
	 * 5. return the value from valueStack.
	 */
	
	public static int calculate(String s) {
		
		if(s == null || s.length() == 0 ) throw new IllegalArgumentException();
		Stack<Character> opStack = new Stack<>();
		Stack<Integer> valStack = new Stack<>();
		int N = s.length();
		
		for(int i = 0; i < N; i++) { // parse the expression
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				StringBuilder sb = new StringBuilder();
				while(i < N && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					sb.append(s.charAt(i++));
				}
				valStack.push(Integer.parseInt(sb.toString()));
			}
			
			if(i < N && (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')) {
				while(!opStack.isEmpty() && checkPrecedence(s.charAt(i), opStack.peek()))
					valStack.push(eval(valStack.pop(), opStack.pop(), valStack.pop()));
				
				opStack.push(s.charAt(i));
			}
		}  
		while(!opStack.empty())  // check if any operators
			valStack.push(eval(valStack.pop(), opStack.pop(), valStack.pop()));
		
		return valStack.pop();
	}
	
	// return true if op2 is higher precedence.
	private static boolean checkPrecedence(char op1, char op2) {  // return true if op2 is higher precedence
		if(op2 == '(' || op2 == ')')
			return false;
		
		if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		
		else
			return true;
	}
	//applies the operator on two given operands
	private static int eval(int operand1, char operator, int operand2) {
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
		System.out.println(calculate("3+2*2"));
		System.out.println(calculate(" 3/2"));
		System.out.println(calculate(" 3+5 / 2 "));
	}

}
