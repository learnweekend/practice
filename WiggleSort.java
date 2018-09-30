package leetcode;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
	Example:
	Input: nums = [3,5,2,1,6,4]
	Output: One possible answer is [3,5,1,6,2,4]
 */
public class WiggleSort {
	
	/*
	 * Solution 1 :  Sort the array and swap the odd/even indices accordingly 
	 */
	public static void wiggleSortV1(int[] arr) {
		if(arr == null || arr.length == 0) 
			return;
		Arrays.sort(arr); //[1, 2, 3, 4, 5, 6]
		
		for(int i = 1; i < arr.length - 1; i=i+2)
			swap(arr, i, i+1);
	}
	
	/*
	 * Solution 2 :  Loop through the array and check for odd and even indices and swap them accordingly. 
	 */
	public static void wiggleSortV2(int[] arr) {
		
		if(arr == null || arr.length == 0) 
			return;
		
		for(int i = 0; i < arr.length - 1; i ++) {
			if(i % 2 == 0) {
				if(arr[i] > arr[i + 1]) {
					swap(arr, i, i+1);
				}
			} else {
				if(arr[i] < arr[i + 1]) {
					swap(arr, i, i+1);
				}
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i+1] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {3,5,1,6,2,4};
		wiggleSortV2(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
