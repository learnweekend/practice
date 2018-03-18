/* https://leetcode.com/problems/group-anagrams/description/
 Given an array of strings, group anagrams together.
 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:
 [
 	["ate", "eat","tea"],
 	["nat","tan"],
 	["bat"]
 ]
 Note: All inputs will be in lower-case
 */
import java.util.*;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(List<String> words) {
		List<List<String>> anagrams = new ArrayList<>();
		Map<String, List<String>> anagramsMap = new HashMap<>();

		for (String s : words) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);

			if (anagramsMap.containsKey(new String(ch))) {
				anagramsMap.get(new String(ch)).add(s);
			} else {
				List<String> anagram = new ArrayList<>();
				anagram.add(s);
				anagramsMap.put(new String(ch), anagram);
			}
		}

		for (String entry : anagramsMap.keySet()) {
			List<List<String>> anagramsList = new ArrayList<>();
			anagramsList.add(anagramsMap.get(entry));
		}
		return anagrams;
	}

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("abc");
		words.add("hello");
		words.add("cba");
		groupAnagrams(words);
	}
}
