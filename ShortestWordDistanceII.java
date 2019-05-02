package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a class which receives a list of words in the constructor, and implements a method that
 * takes two words word1 and word2 and return the shortest distance between these two words in the
 * list. Your method will be called repeatedly many times with different parameters.
 * Example: Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Input: word1 = “coding”, word2 = “practice” Output: 3
 * Input: word1 = "makes", word2 = "coding" Output: 1
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistanceII {

	private static Map<String, List<Integer>> wordIndexCache;

	public ShortestWordDistanceII(String[] input) {
		wordIndexCache = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			List<Integer> list = wordIndexCache.getOrDefault(input[i], new ArrayList<Integer>());
			list.add(i);
			wordIndexCache.put(input[i], list);
		}
	}

	/**
	 * Maintain a word and List of Indices in HashMap
	 * iterate the two lists and find the absolute difference between two indices and get the min.
	 * if min distance is 1, then return;
	 * 
	 * Runtime : O(N) for constructor
	 * and O( max(P, Q))  where P and Q are sizes of array lists
	 * Space : O(N)
	 */
	public int shortest(String word1, String word2) {
		int minDistance = Integer.MAX_VALUE;
		List<Integer> word1Indices = wordIndexCache.get(word1);
		List<Integer> word2Indices = wordIndexCache.get(word2);
		
		int indexOne = 0;
		int indexTwo = 0;
		
		while(indexOne < word1Indices.size() && indexTwo < word2Indices.size()) {
			minDistance = Math.min(minDistance, Math.abs(word1Indices.get(indexOne) - word2Indices.get(indexTwo)));
			
			if(minDistance == 1)  // Note: Improvement, the min distance cannmot be less than 1
            return minDistance;
			
			if(word1Indices.get(indexOne) < word2Indices.get(indexTwo)) {
				indexOne++;
			} else {
				indexTwo++;
			}
		}
		return minDistance;
	}

	public static void main(String[] args) {
		String[] str = {"practice", "makes", "perfect", "coding", "makes" } ;
		ShortestWordDistanceII obj = new ShortestWordDistanceII(str);
		System.out.println(obj.shortest("coding", "practice"));  // 3
		System.out.println(obj.shortest("makes", "coding"));  // 1
	}
}
