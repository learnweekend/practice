package leetcode;
/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * Given a sorted array consisting of only integers where every element appears twice except for one
 * element which appears once. Find this single element that appears only once.
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8] Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11] Output: 10
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementSortedArray {
	//Time : O(N) | space : O(1)
	public static int singleNonDuplicate(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];
		}
		return xor;
	}
	//Time : O(log n) | space : O(1)
	public static int singleNonDuplicateBinarySearch(int[] nums) {
		int start = 0;
		int N = nums.length;
		int end = N - 1;
		
		while (true) {
			int mid = start + (end - start) / 2;
			if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
				if ((mid - start) % 2 == 1)
					start = mid + 1;
				else
					end = mid - 2;
			} else if (mid + 1 < N && nums[mid] == nums[mid + 1]) {
				if ((mid - start) % 2 == 1)
					end = mid - 1;
				else
					start = mid + 2;
			} else {
				return nums[mid];
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		System.out.println(singleNonDuplicate(nums));
		System.out.println(singleNonDuplicateBinarySearch(nums));
	}
}
