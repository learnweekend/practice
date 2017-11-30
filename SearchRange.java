package com.all;

import java.util.Arrays;

/*
 * Given a sorted array of integers, return the low and high index of the given key. Return -1 if not found. 
 * The array length can be in millions with lots of duplicates.
 */
public class SearchRange {

	public static int[] searchRange(int[] nums, int target) {
		int[] range = { -1, -1 };

		if (nums == null) // base case
			return range;

		if (nums.length == 1) {  // base case when array has one element
			if (nums[0] == target)
				return new int[] { 0, 0 };
		}

		int startIndex = getIndex(nums, target - 0.5); // get start range

		if (startIndex >= nums.length || target != nums[startIndex])  // validation
			return range;

		int endIndex = getIndex(nums, target + 0.5); // end range
		range[0] = startIndex;

		if (endIndex < nums.length && target == nums[endIndex]) 
			range[1] = endIndex;
		else
			range[1] = endIndex - 1; 
		return range;
	}

	public static int getIndex(int[] arr, double target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (target > arr[mid]) {  // note NO mid here
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start; // note this.
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] {1}, 1)));
		System.out.println(Arrays.toString(searchRange(new int[] {2, 2}, 2)));
		System.out.println(Arrays.toString(searchRange(new int[] {1,2,3}, 2)));
	}

}
