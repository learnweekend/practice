package samples.leetcode;

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesesV1(5));
		System.out.println(generateParenthesesV2(5));
	}

	/** Brute-ofrce solution: 
	 * 1. Generate all possible permutations of a given string with number of pairs.
	 * 2. Check if a permutation is a well formed parantheses.
	 * Runtime : O(n!)
	 */
	public static Set<String> generateParenthesesV1(int n) {
		Set<String> result = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			sb.append("()");
		}
		List<String> all = permutations(sb.toString());
		for (String str : all) {
			if(str.startsWith(")") || str.endsWith("("))
				continue;
			if (isValid(str)) {
				result.add(str);
			}
		}
		return result;
	}

		// Get all permutations
	public static List<String> permutations(String s) {
		if (s == null || s.length() == 0)
			return null;
		List<String> permutations = new ArrayList<>();
		permutations("", s, permutations);
		return permutations;
	}
    // Get all permutations - recursion, runtime : O(n!)
	private static void permutations(String prefix, String suffix,
				List<String> permutations) {
		if (suffix.length() == 0)
			permutations.add(prefix);
		else {
			for (int i = 0; i < suffix.length(); i++) {
				permutations(prefix + suffix.charAt(i), suffix.substring(0, i)
							+ suffix.substring(i + 1), permutations);
			}
		}
	}
	
	// Check if a given String is well formed or not.
	public static boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(')
				count++;
			else
				count--;
			if (count < 0)
				return false;
		}
		return (count == 0);
	}
	
	/**
	 * Solution 2:  Using recursion
	 * 1. check if open and close parantheses are equal to number of input pairs then print
	 * 2. check if open < pairs ... the concat open and increment open
	 * 3. Check if close < open ... then concat close and increment close
	 * runtime : exponential ,  which means > O(2^N) and < O(n!)
	 */
	public static List<String> generateParenthesesV2(int noOfPairs){
		List<String> result = new ArrayList<>();
		generateParenthesesV2("", 0, 0, noOfPairs, result);
		return result;
	}
	
	private static void generateParenthesesV2(String parentheses, int open, int close, int pairs, List<String> result){
		if(open == pairs && close == pairs) {
			result.add(parentheses);
			return;
		}
		else if(open < pairs)
			generateParenthesesV2(parentheses + '(', open + 1, close, pairs, result);
		
		if(close < open)
			generateParenthesesV2(parentheses + ')', open, close + 1, pairs, result);
	}
}
