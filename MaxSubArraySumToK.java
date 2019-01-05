package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * 
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
Example 1:
Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4 
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:
Input: nums = [-2, -1, 2, 1], k = 1
Output: 2 
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
Follow Up:
Can you do it in O(n) time?
 */
public class MaxSubArraySumToK {

	public static void main(String[] args) {
		int[] nums =  {1, -1, 5, -2, 3}; int k = 3;
		System.out.println(maxSubArrayLen(nums, k));
	}

	/**
	 * Solution : Keep a track of cumulative sum in HashMap<CumSum, Index).
	 * 2. Get the difference of CumSum and Target Sum
	 * 3. Check if difference is in Map, if yes, get the sub array length and check if this is maximum
	 * 4. if difference is not in HashMap, then insert in Map.
	 * 5. Return the maximum sub array length
	 *  Runtime : O(N), Space : O(N)
	 */
	public static int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		
		int cumSum = 0;  // cumulative sum
		int max = 0;  // get the max sub array length

		Map<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, -1);

		for (int i = 0; i < nums.length; i++) {
			cumSum += nums[i];
			int diff = cumSum - k;
			if (sumMap.containsKey(diff)) {  // found one sub array
				max = Math.max(max, i - sumMap.get(diff));  // get the max sub array length
			}
			if (!sumMap.containsKey(cumSum)) {
				sumMap.put(cumSum, i);
			}
		}
		return max;
	}
}
