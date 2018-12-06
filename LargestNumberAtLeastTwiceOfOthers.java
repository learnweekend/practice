/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 * 
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as every other number in
 * the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * Example 1:
 * 
 * Input: nums = [3, 6, 1, 0] Output: 1 Explanation: 6 is the largest integer, and for every other
 * number in the array x, 6 is more than twice as big as x. The index of value 6 is 1, so we return  1.
 */
public class LargestNumberAtLeastTwiceOfOthers {
	
	/**
	 * Have one variable for largest and another for second largest, another variable to track the largest index
	 * if the largest >= 2 * secondlargest, then return index of largest otherwise -1
	 * Runtime : O(N), space : O(1)
	 */
	public int dominantIndex(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		if (nums.length == 1)
			return 0;

		int largest = nums[0];
		int secondLargest = 0;
		int largestIndex = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > largest) {
				secondLargest = largest;
				largest = nums[i];
				largestIndex = i;
			} else if (nums[i] > secondLargest) {
				secondLargest = nums[i];
			}
		}
		if (largest >= secondLargest * 2)
			return largestIndex;

		return -1;
	}

	public static void main(String[] args) {
		LargestNumberAtLeastTwiceOfOthers obj = new LargestNumberAtLeastTwiceOfOthers();
		System.out.println(obj.dominantIndex(new int[] { 3, 6, 1, 0 }));
		System.out.println(obj.dominantIndex(new int[] { 1, 0 }));
	}
}
