package expert.medium;

/**
 * https://leetcode.com/problems/edit-distance/description/
 * 
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character Delete a character Replace a character
 * Example 1:
 * Input: word1 = "horse", word2 = "ros" 
 * Output: 3 
 * Explanation: horse -> rorse (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 */
public class EditDistance {

	//Runtime : O(N^2) | Space : O(NM)
	// Space can be reduced to min(N, M)
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
		String x = "horse";
		String y = "ros";
		System.out.println(levenshteinDistance(x, y));
	}
}
