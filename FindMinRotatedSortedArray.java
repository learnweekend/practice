/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * Input: [3,4,5,1,2] Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,5,6,7,0,1,2] Output: 0
 * 
 */
public class FindMinRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 3, 4, 5, 1, 2 }; // 1
		int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 }; // 0
		System.out.println(findMinV1(nums1));
		System.out.println(findMinV2(nums2));
	}

	public static int findMinV2(int[] nums) {

		if (nums.length == 1) { // check if array has one element
			return nums[0];
		}

		int start = 0, end = nums.length - 1;

		if (nums[end] > nums[start]) { // check if array is sorted
			return nums[start];
		}

		while (start <= end) {
			int mid = start + ((end - start) >> 1);

			if (nums[mid] > nums[mid + 1]) { // check if nums[mid] > nums[mid + 1]
				return nums[mid + 1];
			}
			if (nums[mid - 1] > nums[mid]) { // check if nums[mid - 1] > nums[mid]
				return nums[mid];
			}
			if (nums[mid] > nums[0]) { // if nums[mid] > nums[start], search on right
				start = mid + 1;
			} else { // search or left
				end = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * Solution : Binary Search 1. Start calculate mid; 2. check if complete array is sorted (zero
	 * rotations) (nums[start] <= nums[end]) 3. In step 2, check for start not out of array range 4.
	 * check if left is sorted ==> (nums[mid] >= nums[end]), then search on right 5. else search in left
	 */
	public static int findMinV1(int[] nums) {

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + ((end - start) >> 1); // find the mid

			if (start <= end && nums[start] <= nums[end]) // check if array is sorted
				return nums[start];

			if (mid <= end && nums[mid] >= nums[end]) // if left side is sorted, then search on right
				start = mid + 1;

			else // search on left
				end = mid; // NOTE : end = mid;
		}
		return nums[start]; // return nums[start];
	}
}
