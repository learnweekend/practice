/**
 * https://leetcode.com/problems/find-pivot-index/description/
 * 
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * 
 * We define the pivot index as the index where the sum of the numbers to the left of the index is
 * equal to the sum of the numbers to the right of the index.
 * 
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should
 * return the left-most pivot index.
 * 
 * Example 1:
 * 
 * Input: nums = [1, 7, 3, 6, 5, 6] Output: 3 Explanation: The sum of the numbers to the left of
 * index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3. Also, 3 is the
 * first index where this occurs.
 * 
 */
public class PivotIndex {

	/**
	 * pre-compute the total sum.
	 * loop through the array and find left and right sum.
	 * check if both sums are equals otherwise reurn -1
	 * Runtime : O(N), space : O(1)
	 */
	public int pivotIndex(int[] nums) {
		int leftsum = 0;
		int totalsum = 0;

		for (int num : nums)
			totalsum += num;

		for (int index = 0; index < nums.length; index++) {
			int rightsum = totalsum - leftsum - nums[index];

			if (leftsum == rightsum)
				return index;

			leftsum = leftsum + nums[index];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { -1 };
		PivotIndex obj = new PivotIndex();
		System.out.println(obj.pivotIndex(nums));
	}
}
