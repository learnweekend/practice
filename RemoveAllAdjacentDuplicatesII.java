package leetcode;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * 
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s
 * and removing them causing the left and the right side of the deleted substring to concatenate
 * together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * Example 1:
 * 
 * Input: s = "abcd", k = 2 Output: "abcd" Explanation: There's nothing to delete.
 * 
 * Example 2:
 * 
 * Input: s = "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete "eee" and "ccc", get
 * "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete "ddd", get "aa"
 * 
 * Example 3:
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2 Output: "ps"
 * 
 */

public class RemoveAllAdjacentDuplicatesII {

	/**
	 * Brute Force Solution Runtime : O(N^2/k), Space : O(1)
	 */
	public static String removeDuplicatesBruteForce(String input, int k) {
		if (input == null || input.length() == 0) {
			return input;
		}

		StringBuilder sb = new StringBuilder(input);

		int length = 0;

		while (length != sb.length()) { // compare length with original/updated String, continue until length changes
			length = sb.length();

			int charCount = 0;
			for (int i = 0; i < sb.length(); i++) { // The bottleneck is the count is repeated for same characters
				if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
					charCount = 1;
				} else {
					charCount++;
					if (charCount == k) {
						sb.delete(i - k + 1, i + 1);
						break;
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Improvements: Memoize the counts so that we don't have to re-compute the counts after every
	 * deletion Runtime : O(N), Space : O(N)
	 */
	public static String removeDuplicates(String input, int k) {
		if (input == null || input.length() == 0) {
			return input;
		}
		StringBuilder sb = new StringBuilder(input);
		int[] counts = new int[sb.length()];

		for (int i = 0; i < sb.length(); i++) { //
			if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				counts[i] = 1;
			} else {
				counts[i] = counts[i - 1] + 1;
				if (counts[i] == k) {
					sb.delete(i - k + 1, i + 1);
					i = i - k;
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3)); // aa
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2)); // ps
	}

}
