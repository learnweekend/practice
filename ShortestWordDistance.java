import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/shortest-word-distance/description/
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these
 * two words in the list.
 * 
 * Example: Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Input: word1 = “coding”, word2 = “practice” Output: 3
 * 
 * Input: word1 = "makes", word2 = "coding" Output: 1
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
	// Time : O(N) | Space : O(1)
	public static int shortestDistanceFast(String[] words, String word1, String word2) {
		int minDistance = words.length;
		int word1Index = -1;
		int word2Index = -1;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				word1Index = i;
			} else if (words[i].equals(word2)) {
				word2Index = i;
			}
			if (word1Index > -1 && word2Index > -1) {
				minDistance = Math.min(minDistance, Math.abs(word2Index - word1Index));
				if (minDistance == 1)
					return minDistance;
			}
		}
		return minDistance;
	}

	// Brute force : Time : O(N ^ 2) | Space : O(1)
	public static int shortestDistanceBruteForce(String[] words, String word1, String word2) {
		int minDistance = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				for (int j = 0; j < words.length; j++) {
					if (words[j].equals(word2)) {
						minDistance = Math.min(minDistance, Math.abs(i - j));
						if (minDistance == 1)
							return minDistance;
					}
				}
			}
		}
		return minDistance;
	}

	// Time : O(N ^ 2) | Space : O(N)
	public static int shortestDistance(String[] words, String word1, String word2) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) {
				map.put(words[i], new ArrayList<Integer>());
			}
			map.get(words[i]).add(i);
		}
		int minDistance = Integer.MAX_VALUE;
		for (int i : map.get(word1))
			for (int j : map.get(word2)) {
				minDistance = Math.min(Math.abs(i - j), minDistance);
				if (minDistance == 1)
					return minDistance;
			}
		return minDistance;
	}

	public static void main(String[] args) {
		String[] words = { "a", "c", "b", "a" };
		String word1 = "a";
		String word2 = "b";
		System.out.println(shortestDistance(words, word1, word2));
	}
}
