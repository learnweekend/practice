package leetcode;

/**
 *  https://leetcode.com/problems/shortest-word-distance-iii/
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1

Input: word1 = "makes", word2 = "makes"
Output: 3

Note:
You may assume word1 and word2 are both in the list.

 * @author suryateja
 *
 */
public class ShortestWordDistanceIII {

	public int shortestWordDistance(String[] words, String word1, String word2) {
		int index1 = -1;
		int index2 = -1;
		int shortestDistance = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (word1.equals(word2)) {
				if (word1.equals(words[i])) {
					index1 = index2;
					index2 = i;
				}
			} else {
				if (word1.equals(words[i])) {
					index1 = i;
				} else if (word2.equals(words[i])) {
					index2 = i;
				}
			}

			if (index1 > -1 && index2 > -1) {
				shortestDistance = Math.min(shortestDistance, Math.abs(index2 - index1));

				if (shortestDistance == 1)
					return shortestDistance;
			}
		}
		return shortestDistance;
	}
}