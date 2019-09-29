package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings
 * is a subsequence that is common to both strings.
 * 
 * If there is no common subsequence, return 0.
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace" Output: 3 Explanation: The longest common subsequence is
 * "ace" and its length is 3.
 * 
 * Example 2:
 * Input: text1 = "abc", text2 = "abc" Output: 3 Explanation: The longest common subsequence is
 * "abc" and its length is 3.
 * 
 * Example 3:
 * Input: text1 = "abc", text2 = "def" Output: 0 Explanation: There is no such common subsequence,
 * so the result is 0.
 */

public class LongestCommonSubsequence {

	public static int longestCommonSubsequence(String text1, String text2) {
		int rows = text1.length();
		int cols = text2.length();

		int[][] cache = new int[rows + 1][cols + 1];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (text1.charAt(row) == text2.charAt(col)) { // check for characters match
					cache[row + 1][col + 1] = cache[row][col] + 1;
				} else {
					cache[row + 1][col + 1] = Math.max(cache[row + 1][col], cache[row][col + 1]);
				}
			}
		}
		System.out.println(getSequence(cache, text2));  // Displays the common sequence
		return cache[rows][cols];
	}

	public static List<Character> getSequence(int[][] cache, String text2) {
		List<Character> sequence = new ArrayList<>();

		int i = cache.length - 1;
		int j = cache[0].length - 1;

		while (i != 0 && j != 0) {

			if (cache[i][j] == cache[i - 1][j]) {
				i--;
			} else if (cache[i][j] == cache[i][j - 1]) {
				j--;
			} else {
				sequence.add(0, text2.charAt(j - 1));
				i--;
				j--;
			}
		}
		return sequence;
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));
		System.out.println(longestCommonSubsequence("abc", "abc"));
		System.out.println(longestCommonSubsequence("abc", "def"));
	}
}
