/**
 * https://leetcode.com/problems/one-edit-distance/description/
 * 
 * Given two strings s and t, determine if they are both one edit distance apart.
 * Note:
 * There are 3 possiblities to satisify one edit distance apart:
 * Insert a character into s to get t Delete a character from s to get t Replace a character of s to  get t
 * Example 1:
 * Input: s = "ab", t = "acb" Output: true Explanation: We can insert 'c' into s to get t.
 */
public class OneEditDistance {

	public static boolean isOneEditDistance(String s, String t) {
		return levenshteinDistance(s, t) == 1 ? true : false;
	}

	public static int levenshteinDistance(String x, String y) {
		if (x.length() == 0)
			return y.length();

		if (y.length() == 0)
			return x.length();

		int[][] cache = new int[x.length() + 1][y.length() + 1];

		for (int i = 0; i <= x.length(); i++) {
			for (int j = 0; j <= y.length(); j++) {
				if (i == 0) {
					cache[i][j] = j;
				} else if (j == 0) {
					cache[i][j] = i;
				} else {
					if (x.charAt(i - 1) == y.charAt(j - 1)) {
						cache[i][j] = cache[i - 1][j - 1];
					} else {
						cache[i][j] = 1 + Math.min(cache[i - 1][j - 1], Math.min(cache[i - 1][j], cache[i][j - 1]));
					}
				}
			}
		}
		return cache[x.length()][y.length()];
	}

	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acd"));
	}
}
