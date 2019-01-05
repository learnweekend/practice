/**
 * https://leetcode.com/problems/third-maximum-number/description/
 * 
 * Given a non-empty array of integers, return the third maximum number in this array. If it does
 * not exist, return the maximum number. The time complexity must be in O(n).
 * 
 * Example 1:
 * Input: [3, 2, 1],  Output: 1, Explanation: The third maximum is 1.
 * 
 * Example 2:
 * Input: [1, 2], Output: 2, Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * 
 * Example 3:
 * Input: [2, 2, 3, 1], Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number. Both
 * numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {

	public static int thirdMax(int[] nums) {
		if (nums.length < 3)
			return nums[0] > nums[1] ? nums[0] : nums[1];

		long firstMax = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > firstMax)
				firstMax = nums[i];
		}
		long secondMax = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < firstMax && nums[i] > secondMax)
				secondMax = nums[i];
		}

		long thirdMax = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < secondMax && nums[i] > thirdMax)
				thirdMax = nums[i];
		}
		if (thirdMax == Long.MIN_VALUE)
			return (int) firstMax;

		return (int) thirdMax;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 1 };
		System.out.println(thirdMax(nums));
	}
}
