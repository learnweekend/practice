package leetcode;

import java.util.HashMap;
import java.util.Map;

/** 
 * https://leetcode.com/problems/ransom-note/description/
 * 
 * Given an arbitrary ransom note string and another string containing letters from all the
 * magazines, write a function that will return true if the ransom note can be constructed from the
 * magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false canConstruct("aa", "aab") -> true
 */
public class RansomNote {

	public static boolean canConstruct(String str, String magazine) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		for (int i = 0; i < magazine.length(); i++) {
			char ch = magazine.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) {
					map.remove(ch);
				}
			}
		}
		return map.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "bb"));
		System.out.println(canConstruct("aa", "aab"));
	}
}
