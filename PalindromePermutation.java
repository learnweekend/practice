
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/palindrome-permutation/description/ 
 * Given a string, determine if a permutation of the string could form a palindrome. 
 * Example 
 * 1: Input: "code" Output: false Example
 * 2: Input: "aab" Output: true
 */
public class PalindromePermutation {

	// solution 1 : Runtime : O(N) | Space : O(1)
	public static boolean canPermutePalindrome(String s) {
		int[] count = new int[128];
		int uniques = 0;
		for (char c : s.toCharArray()) {
			count[c]++;
			if (count[c] % 2 == 0) {
				uniques--;
			} else {
				uniques++;
			}
		}
		return uniques <= 1;
	}

	// solution 2: Runtime : O(N) | Space : O(1)
	public static boolean isPermutationPalindrome(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		int count = 0;
		for (char ch : map.keySet()) {
			count += map.get(ch) % 2;
			if (count > 1)
				return false;
		}
		return count <= 1;
	}

	public static void main(String[] args) {
		String str = "aab";
		System.out.println(isPermutationPalindrome(str));
		System.out.println(canPermutePalindrome(str));
	}
}
