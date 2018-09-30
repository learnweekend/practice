package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  #791 : https://leetcode.com/problems/custom-sort-string/description/
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.

 */
public class CustomSortString {
	
	/**
	 * Solution :  Using HashMap to store the characters count from String T.
	 * Loop through the String T and add characters to countMap.
	 * Take a StringBuilder to store the result String.
	 * Loop through the String S and check if character is present in Map then add all the chars to stringbuilder.
	 * Add the remaining elements in the String T to StringBuilder  and return the result.
	 * Runtime : O (MAX(S + T))
	 */
	public static String customSortString(String S, String T) {
		if(S == null || S.length() == 0 || T == null || T.length() == 0)
			return null;
		
		Map<Character, Integer> countMap = new HashMap<>();
		for(char ch : T.toCharArray()) {
			if(countMap.containsKey(ch)) {
				countMap.put(ch,  countMap.get(ch) + 1);
			} else {
				countMap.put(ch,  1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : S.toCharArray()) {
			if(countMap.containsKey(ch)) {
				for(int i = 0; i < countMap.get(ch); i++) {
					sb.append(ch);
				}
				countMap.remove(ch);
			} 
		}
		for(char ch : countMap.keySet()) {
			for(int i = 0; i < countMap.get(ch); i++) {
				sb.append(ch);
			}
		}
		return sb.toString();
   }
	
	/**
	 * Solution :  Using array to store the characters count from String T.
	 * Loop through the String T and add characters to countMap.
	 * Take a StringBuilder to store the result String.
	 * Loop through the String S and check if character is present in Map then add all the chars to stringbuilder.
	 * Add the remaining elements in the String T to StringBuilder  and return the result.
	 * Runtime : O (MAX(S + T))
	 */
	public static String customSortStringV2(String S, String T) {
		if(S == null || S.length() == 0 || T == null || T.length() == 0)
			return null;
		
		int[] count = new int[26];  // to store char count of String T
		for(char ch : T.toCharArray()) { 
			count[ch - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder(); // to store the result
		
		for(char ch : S.toCharArray()) {  // traverse String S and append which are present
			while(count[ch - 'a']-- > 0) {
				sb.append(ch);
			}
		}
		
		for(char ch : T.toCharArray()) { // append remaining chars from String T
			while(count[ch - 'a']-- > 0) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String S = "cbafg" ;
		String T = "abcd";
		System.out.println(customSortString(S, T));
		System.out.println(customSortStringV2(S, T));
	}

}
