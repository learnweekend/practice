package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the
 * maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has
 * the same degree as nums.
 * 
 * Example 1: Input: [1, 2, 2, 3, 1] Output: 2 Explanation: The input array has a degree of 2
 * because both elements 1 and 2 appear twice. Of the subarrays that have the same degree: [1, 2, 2,
 * 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2] The shortest length is 2. So
 * return 2.
 * 
 * Example 2: Input: [1,2,2,3,1,4,2] Output: 6
 *
 */
public class DegreeOfArray {
	
	public static int findShortestSubArray(int[] array) {

		Map<Integer, Integer> leftMap = new HashMap<>();
		Map<Integer, Integer> rightMap = new HashMap<>();
		Map<Integer, Integer> countMap = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			int value = array[i];

			if (leftMap.get(value) == null)
				leftMap.put(value, i);

			rightMap.put(value, i);
			countMap.put(value, countMap.getOrDefault(value, 1) + 1);
		}

		int degree = Collections.max(countMap.values());
		int result = array.length;

		for (int key : countMap.keySet()) {
			if (countMap.get(key) == degree) {
				int count = rightMap.get(key) - leftMap.get(key) + 1;
				if (count < result) {
					result = count;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findShortestSubArray(new int[] {1, 2, 2, 3, 1})); // 2
		System.out.println(findShortestSubArray(new int[] {1,2,2,3,1,4,2})); // 6
	}

}
