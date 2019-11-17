package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 * 
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * 
 * n >= 3 X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * 
 * Given a strictly INCREASING array A of positive integers forming a sequence, find the length of
 * the longest fibonacci-like subsequence of A. If one does not exist, return 0.
 * 
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements
 * (including none) from A, without changing the order of the remaining elements. 
 * For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 * 
 * Example 1:
 * Input: [1,2,3,4,5,6,7,8] Output: 5 Explanation: The longest subsequence that is fibonacci-like:
 * [1,2,3,5,8].
 * 
 * Example 2:
 * Input: [1,3,7,11,12,14,18] Output: 3 Explanation: The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 * 
 */
public class LongestFibonacciSequence {

	public static int lenLongestFibSubseq(int[] array) {
		int longest = 0;
		
		Set<Integer> set = new HashSet<>();  // Add all elements to set
		for (int i : array)
			set.add(i);

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int second = array[j];
				int third = array[i] + second;
				int currLongest = 2;

				while (set.contains(third)) {
					int temp = third;
					third = second + third;
					second = temp;
					longest = Math.max(longest, ++currLongest);
				}
			}
		}
		return longest >= 3 ? longest : 0; // Note : To make sure the length >= 3
	}

	public static void main(String[] args) {
		System.out.println(lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 })); // 5
		System.out.println(lenLongestFibSubseq(new int[] { 1, 3, 7, 11, 12, 14, 18 })); // 3
	}
}
