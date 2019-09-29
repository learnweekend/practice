package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/ 
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example: Input: [10,9,2,5,3,7,101,18] 
 * Output: 4 Explanation: The longest increasing subsequence
 * is [2,3,7,101], therefore the length is 4.
 * 
 * Note: There may be more than one LIS combination, it is only necessary for you to return the
 * length. Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int[] cache = new int[nums.length];
		Arrays.fill(cache, 1);

		for (int j = 1; j < nums.length; j++) {
			for (int k = 0; k < j; k++) {
				if (nums[j] > nums[k]) {
					cache[j] = Math.max(cache[j], cache[k] + 1);
				}
			}
		}
		
		int max = 1;
		for (int i = 0; i < cache.length; i++) {
			if (cache[i] > max)
				max = cache[i];
		}
		
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
	}
}
