package leetcode;

/**
 * https://leetcode.com/problems/count-and-say/
 * 
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 
 * 1. 1 2. 11 3. 21 4. 1211 5. 111221
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off as "one 2, then
 * one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1:
 * 
 * Input: 1 Output: "1"
 * 
 * Example 2:
 * 
 * Input: 4 Output: "1211"
 * 
 */
public class CountAndSay {

	public static String countAndSay(int n) {
		String result = "1";

		if (n == 1)
			return result;

		while (n > 1) {
			StringBuilder current = new StringBuilder();  // to track the current

			for (int i = 0; i < result.length(); i++) {  // iterate through the previous
				int count = 1;
				
				while (i + 1 < result.length() && result.charAt(i) == result.charAt(i + 1)) {  // count the number if same element
					count++;
					i++;
				}
				current = current.append(count).append(result.charAt(i));  // append the count and the number
			}
			result = current.toString();
			n--;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
	}
}
