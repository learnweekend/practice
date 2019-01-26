package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubStringWithoutRepeatingCharacter {
	/**
	 * Brute force solution :  Get all the substring and check if all the substring have unique characters.
	 * Runtime : O(N ^ 3), Space : O(N)
	 */
	public static int lengthOfLongestSubstringV1(String s) {
		int N = s.length();
		int max = 0;
		String substring = "";
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j <= N; j++)
				if (isUnique(s, i, j)) {
					if (j - i > max) {
						substring = s.substring(i, j);
						max = j - i;
					}
				}
		System.out.println(substring); // print the longest substring without repeating character
		return max;
	}

	public static boolean isUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			char ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

	/**
	 *  Time : O(N) | space : O(min(N, A) , where A = number of unique characters in input string
	 */
	public static String longestSubStringWithoutDuplicateCharacter(String str) {
		if (str == null || str.length() == 0)
			return str;

		Map<Character, Integer> lastSeen = new HashMap<>();
		int[] length = new int[] { 0, 0 }; // To store the start and end indices of longest substring
		int startIndex = 0; // To store the starting index of unique string

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (lastSeen.containsKey(ch)) {
				startIndex = Math.max(startIndex, lastSeen.get(ch) + 1);
			}
			lastSeen.put(ch, i);  // replace with last seen index if present

			if (i - startIndex >= length[1] - length[0]) {
				length[0] = startIndex;
				length[1] = i;
			}
		}
		return str.substring(length[0], length[1] + 1);
	}

	public static void main(String[] args) {
		
		lengthOfLongestSubstringV1("a");
		lengthOfLongestSubstringV1("abc");
		lengthOfLongestSubstringV1("abcb");
		lengthOfLongestSubstringV1("abcdeabcdefc");
		lengthOfLongestSubstringV1("abccdeaabbcddef");
		System.out.println();
		
		System.out.println(longestSubStringWithoutDuplicateCharacter("a"));
		System.out.println(longestSubStringWithoutDuplicateCharacter("abc"));
		System.out.println(longestSubStringWithoutDuplicateCharacter("abcb"));
		System.out.println(longestSubStringWithoutDuplicateCharacter("abcdeabcdefc"));
		System.out.println(longestSubStringWithoutDuplicateCharacter("abccdeaabbcddef"));
	}
}
