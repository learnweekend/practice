package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/description/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add
 * spaces in s to construct a sentence where each word is a valid dictionary word. Return all such
 * possible sentences. Note: The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1: Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"] Output: [
 * "cats and dog", "cat sand dog" ]
 * 
 * Example 2: Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen", "pine",
 * "pineapple"] Output: [ "pine apple pen apple", "pineapple pen apple", "pine applepen apple" ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3: Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"] Output: []
 */
public class WordBreakII {

	/**
	 * Recursion
	 */
	public static List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		return wordBreakHelper(s, dict, 0);
	}

	private static List<String> wordBreakHelper(String s, Set<String> dictionary, int startIndex) {
		List<String> result = new ArrayList<>();
		if (startIndex == s.length()) {
			result.add("");
			return result;
		}

		for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
			if (dictionary.contains(s.substring(startIndex, endIndex))) {
				List<String> list = wordBreakHelper(s, dictionary, endIndex);
				for (String str : list) {
					result.add(s.substring(startIndex, endIndex) + (str.equals("") ? "" : " ") + str);
				}
			}
		}
		return result;
	}

	/**
	 * Recursion with Memoization
	 */
	public static List<String> wordBreakMemo(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		Map<Integer, List<String>> cache = new HashMap<>();
		return wordBreakMemo(s, dict, 0, cache);
	}

	private static List<String> wordBreakMemo(String s, Set<String> dictionary, int startIndex,
			Map<Integer, List<String>> cache) {

		if (cache.containsKey(startIndex)) {
			return cache.get(startIndex);
		}
		List<String> result = new ArrayList<>();
		if (startIndex == s.length()) {
			result.add("");
			return result;
		}

		for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
			if (dictionary.contains(s.substring(startIndex, endIndex))) {
				List<String> list = wordBreakMemo(s, dictionary, endIndex, cache);
				for (String str : list) {
					result.add(s.substring(startIndex, endIndex) + (str.equals("") ? "" : " ") + str);
				}
			}
		}
		cache.put(startIndex, result);
		return result;
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> dictionary = Arrays.asList("cat", "cats", "and", "sand", "dog");
		System.out.println(wordBreak(s, dictionary));
		System.out.println(wordBreakMemo(s, dictionary));
	}
}
