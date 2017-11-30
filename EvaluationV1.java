package com.all;

public class EvaluationV1 {

	public static int evaluate(String expression) {

		if (expression == null || expression.length() == 0)
			return 0;

		//make sure to check if the first char is negative or not
		boolean isNegative = expression.charAt(0) == '-' ? true : false; 
		int index = 0;
		int result = 0;

		if (isNegative) // consider reading from second char
			index++;

		StringBuilder sb = new StringBuilder();

		//extract the first word.
		while (index < expression.length() && expression.charAt(index) >= '0'
				&& expression.charAt(index) <= '9')
			sb.append(expression.charAt(index++));

		int value = Integer.parseInt(sb.toString()); // parse the string to integer
		result = isNegative == true ? -value : value;

		while (index < expression.length()) {
			char operator = expression.charAt(index);
			index++;
			sb = new StringBuilder();

			while (index < expression.length()
					&& expression.charAt(index) >= '0'
					&& expression.charAt(index) <= '9')
				sb.append(expression.charAt(index++));

			value = Integer.parseInt(sb.toString());

			if (operator == '+')
				result += value;
			else if (operator == '-')
				result -= value;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(evaluate("6+9-12-10")); // -7
		System.out.println(evaluate("-6+9-12-10")); // -19
		System.out.println(evaluate("-6-9-12-10")); // -37
		System.out.println(evaluate("6+9-12-1")); // 2
		System.out.println(evaluate("6+0-12-1")); // -7
	}
}