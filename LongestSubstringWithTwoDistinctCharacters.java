package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * Given a string s , find the length of the longest substring t that contains at most 2 distinct
 * characters.
 * 
 * Example 1: Input: "eceba" Output: 3 Explanation: t is "ece" which its length is 3.
 * 
 * Example 2: Input: "ccaabbb" Output: 5 Explanation: t is "aabbb" which its length is 5
 */
public class LongestSubstringWithTwoDistinctCharacters {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		
		int N = s.length();
		
		int left = 0;
		int right = 0;
		
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
		
		while (left < N && right < N) {
			if(map.size() < 3) {
				map.put(s.charAt(right), right++);
				sortedMap.put(right, right);
			}
			
			if (map.size() == 3) {
				int index = sortedMap.firstKey();
				map.remove(s.charAt(index));
				left = index + 1;
			}
			
			maxLength = Math.max(maxLength, right - left);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba")); // 3
		System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb")); // 5
	}

}
