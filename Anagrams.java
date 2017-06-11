/*
Problem :  Given two strings, check if both strings are anagrams of each other.
*/
import java.util.Arrays;
 public class Anagrams {
   public static void main(String args[]) {
     String str1 = "Mother-in-law";
     String str2 = "Hitler woman";
     System.out.println(isAnagramV1(str1, str2));
   }
  // Solution 1 : Have an Integer frequency count array for characters of first string.
  // Remove the count looping through the second String.
  // Runtime O(M + N); Space O(1)- constant for frequencyCount array
   private static boolean isAnagramV1(String s1, String s2) {
     if(s1 == null || s2 == null)
       return false;
     int[] frequencyCount = new int[256];
     for(char c : s1.toCharArray()) {  // get char frequency count of s1
     	if(Character.isLetter(c)) {
     		c = Character.toLowerCase(c);
     		frequencyCount[c]++;
     	}
     }
     for(char c : s2.toCharArray()) { // get char frequency count of s2
     	if(Character.isLetter(c)) {
     		c = Character.toLowerCase(c);
     		frequencyCount[c]--;
     	}
     }
     for(int c : frequencyCount) { 
       if( c != 0)
         return false;
     }
     return true;
   }
}
