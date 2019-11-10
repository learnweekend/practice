package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/string-transforms-into-another-string/ 
 * 
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 
 * by doing zero or more conversions.
 * In one conversion you can convert all occurrences of one character in str1 to any other lowercase
 * English character.
 * Return true if and only if you can transform str1 into str2.
 * 
 * Example 1:
 * Input: str1 = "aabcc", str2 = "ccdee" Output: true Explanation: Convert 'c' to 'e' then 'b' to
 * 'd' then 'a' to 'c'. Note that the order of conversions matter.
 * 
 * Example 2:
 * Input: str1 = "leetcode", str2 = "codeleet" Output: false Explanation: There is no way to
 * transform str1 to str2.
 */
public class TransformStringToAnotherString {

	public static void main(String[] args) {
		System.out.println(canConvert("aabcc", "ccdee"));
		System.out.println(canConvert("leetcode", "codeleet"));
	}
	
	public static boolean canConvert(String str1, String str2) {
		if (str1.equals(str2))
			return true;

		if (str1.length() != str2.length())
			return false;
		
		Set<Character> set = new HashSet<>();

		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);

			if (map.containsKey(ch1) && map.get(ch1) != ch2) {
				return false;
			}
			map.put(ch1, ch2);
			set.add(ch2);
		}
		return set.size() < 26;
	}
}
