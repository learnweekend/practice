/*
 problem : Palindrome Permutation
 Given a string, determine if a permutation of the string could form a palindrome.
 For example : “code” -> False, “aab” -> True, “carerac” -> True.
 https://leetcode.com/articles/palindrome-permutation/
 */
 import java.util.*;

 public class PalindromePermutation {
  public static void main(String[] args) {
    String s = "carerac";
    System.out.println(s + " : is Palindrome Permutation ? : " + isPermutationPalindrome(s));
  }
  
  	// solution 1 : 
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

  public static boolean isPermutationPalindrome(String s) {
    if(s == null) throw new IllegalArgumentException();
    if(s.length() == 0) return true;
    Map<Character, Integer> countMap = new HashMap<>();
    // character -> count map
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(countMap.containsKey(ch)){
        countMap.put(ch, countMap.get(ch) + 1);
      } else {
        countMap.put(ch, 1);
      }
    }
    int oddCharCounts = 0;
    // traverse the countMap and check for number of odd character counts, if more than 1, return false.
    for(Character ch : countMap.keySet()){
      if(countMap.get(ch) % 2 == 1){ //
        oddCharCounts++;
      }
      if(oddCharCounts > 1)
          return false;
     }
     return true;
   }
 }
