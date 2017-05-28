import java.util.*;

/**
 * Given a string expression contains brackets (), {} or [],
 * Return true if the expression is valid else false;
 */
 public class ExpressionMatch {
	  public static void main(String args[]) {
		    String str = "{{}}[](){[()]}([])";
		    System.out.println(isBalancedV1(str));
		    System.out.println(isBalancedV2(str));
		    System.out.println(isBalancedV3(str));
	  }
	/* Solution 1: Store the valid parenthese in Map
	 * Loop through the input and push to stack if the characer is present in the map
	 * else, pop the stack and check the map value of the character matches.
	 * return false if doesn't match.
	 * Runtime : O(N);
	 * Space   : O(N);
	 */
	public static boolean isBalancedV1(String expression) {
		if (expression == null || expression.length() == 0)
			throw new IllegalArgumentException();

		if (expression.length() % 2 != 0) // if valid % 2 == 0
			return false;

		Map<Character, Character> parenthesesMap = new HashMap<>();
			parenthesesMap.put('(', ')');
			parenthesesMap.put('{', '}');
			parenthesesMap.put('[', ']');
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (parenthesesMap.containsKey(ch)) {
				stack.push(ch);
			} else if(stack.isEmpty() || parenthesesMap.get(stack.pop()) != ch ){
				return false;
			}
		}
		return stack.isEmpty();
	}
	/*
	 * Solution 2: Loop through the input and push to stack if the characer is open parenthesis
	 * else, pop the stack and check if it the character matches.
	 * return false if doesn't match.
	 * Runtime : O(N);
	 * Space   : O(N);
	 */
	public static boolean isBalancedV2(String expression) {
		if (expression == null || expression.length() == 0)
			throw new IllegalArgumentException();

		if (expression.length() % 2 != 0)
			return false;

		char[] chars = expression.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char c : chars) {
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			} else if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
				return false;
			} else if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
				return false;
			} else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	/*
	 * Solution 2: Loop through the input and add count for open parenthesis
	 * reduce the count if the charater is close parenthesis
	 * If the result sum is 0 - valid else Invalid.
	 * Runtime : O(N);
	 * Space   : O(1);
	 */
	public static boolean isBalancedV3(String expression) {
		if (expression == null || expression.length() == 0)
			throw new IllegalArgumentException();

		if (expression.length() % 2 != 0) //
			return false;

		int count = 0;

		for(int i = 0; i < expression.length(); i++) {
			count += getCharValue(expression.charAt(i));
		}
		return count == 0 ? true : false;
	}

	private static int getCharValue(char ch) {
		if(ch == '(') return 1;
		if(ch == ')') return -1;

		if(ch == '{') return 2;
		if(ch == '}') return -2;

		if(ch == '[') return 3;
		if(ch == ']') return -3;

		return 0;
	}
}
