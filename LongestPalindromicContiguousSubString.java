/**
 *  #46 : Longest Palindromic Substring
 *  
 *  https://leetcode.com/problems/longest-palindromic-substring/description/

This problem was asked by Amazon.

Given a string, find the longest palindromic contiguous substring. 
If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". 
The longest palindromic substring of "bananas" is "anana".
 *
 */
public class LongestPalindromicContiguousSubString {
	
	// solution 1: Runtime : O(N^3) | space : O(1)
	public static String longestPalindromicSubStringBruteForce(String str) {
		String longest = "";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i ; j <= str.length(); j++) {
				String substr = str.substring(i, j);
				if (substr.length() > longest.length() && isPalindrome(substr)) {
					longest = substr;
				}
			}
		}
		return longest;
	}
	private static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;

		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	// solution 2: Runtime : O(N^2) | space : O(1)
	public static String longestPalindromicSubstring(String str) {
		int[] longest = new int[] { 0, 1 };
		for (int i = 0; i < str.length(); i++) {
			int[] oddLength = getLongestPalindrome(str, i - 1, i + 1);
			int[] evenLength = getLongestPalindrome(str, i - 1, i);
			int[] currentLongest = oddLength[1] - oddLength[0] > evenLength[1] - evenLength[0] ? oddLength : evenLength;
			longest = longest[1] - longest[0] > currentLongest[1] - currentLongest[0] ? longest : currentLongest;
		}
		return str.substring(longest[0], longest[1]);
	}

	private static int[] getLongestPalindrome(String str, int leftIndex, int rightIndex) {
		while (leftIndex >= 0 && rightIndex < str.length()) {
			if (str.charAt(leftIndex) != str.charAt(rightIndex))
				break;

			leftIndex--;
			rightIndex++;
		}
		return new int[] { leftIndex + 1, rightIndex };
	}
	// solution 3 : Runtime : O(N^2) | space : O(1)
	
	private static String longest = "";

	public static String longestPalindrome(String str) {
		for (int i = 0; i < str.length(); i++) {
			longestPalindrome(str, i, i);
			longestPalindrome(str, i, i + 1);
		}
		return longest;
	}

	private static String longestPalindrome(String str, int left, int right) {
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			if (right + 1 - left > longest.length()) {
				longest = str.substring(left, right + 1);
			}
			left--;
			right++;
		}
		return longest;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindromicSubStringBruteForce("bananas"));
		System.out.println(longestPalindrome("bananas"));
		System.out.println(longestPalindrome("bananas"));
		
		/*System.out.println(longestPalindromicSubStringBruteForce("aabcdcb"));
		System.out.println(longestPalindrome("aabcdcb"));
		System.out.println(longestPalindrome("aabcdcb"));*/
	}
}
