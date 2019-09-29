package leetcode;

import java.util.HashSet;
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
public class LengthOfLongestSubStringWithoutRepeatingCharacter {
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
					if(j - i > max) {
						substring = s.substring(i, j);
						max = j - i;
					}
				}
		System.out.println(substring);
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

	/** Solution : 1. have two pointers from beginning
	 * 2. move one pointer forward for each character and insert in SET
	 * 3. if the character is present then update the max and remove one character from the start
	 * 4. Repeat this process until the end of the string.
	 * Runtime : O(N), Space : O(N);
	 */
	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int curr = 0;
		int maxLength = 0;
		int end = s.length() - 1;

		Set<Character> set = new HashSet<>();
		
		while (curr <= end) {
			if (!set.contains(s.charAt(curr))) {
				set.add(s.charAt(curr++));
				maxLength = Math.max(maxLength, set.size());
			} else {
				set.remove(s.charAt(start++)); // remove one element from start when duplicate found
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwwkew"));
	}
}
