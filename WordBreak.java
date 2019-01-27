package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/articles/word-break/# Given a non-empty string s and a dictionary wordDict
 * containing a list of non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation. You may assume
 * the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"] Output: true Explanation: Return true because
 * "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] Output: true Explanation: Return true
 * because "applepenapple" can be segmented as "apple pen apple". Note that you are allowed to reuse
 * a dictionary word.
 * 
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] Output: false
 */
public class WordBreak {

	/**
	 * brute force using recursion. runtime : o(2 ^ n) - exponential
	 */
	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dictionary = new HashSet<String>(wordDict);
		return wordBreak(s, dictionary, 0);
	}

	public static boolean wordBreak(String s, Set<String> dict, int startIndex) {
		if (startIndex == s.length())
			return true;

		for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
			if (dict.contains(s.substring(startIndex, endIndex)) && wordBreak(s, dict, endIndex))
				return true;
		}
		return false;
	}

	/**
	 * Recursion with memoization, runtime : o(n ^ 2) | space : O(n)
	 */
	public static boolean wordBreakMemo(String s, List<String> wordDict) {
      Set<String> dict = new HashSet<>(wordDict);
      Boolean[] cache = new Boolean[s.length()];
      return wordBreakMemo(s, dict, 0, cache);
  }
  
  private static boolean wordBreakMemo(String str, Set<String> dict, int startIndex, Boolean[] cache){
      if(startIndex == str.length()){
          return true;
      }
      if(cache[startIndex] != null) {
          return cache[startIndex];
      }
      for(int end = startIndex + 1; end <= str.length(); end++){
          if(dict.contains(str.substring(startIndex, end)) && wordBreakMemo(str, dict, end, cache)){
              cache[startIndex] = true;
              return cache[startIndex];
          }
      }
      cache[startIndex] = false;
      return cache[startIndex];
  }
	
	public static void main(String[] args) {
		String s = "catsandog";
		List<String> words = Arrays.asList("cats","dog","sand","and","cat");
		System.out.println(wordBreak(s, words));
		System.out.println(wordBreakMemo(s, words));
	}
}
