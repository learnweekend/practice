package com.all;

/**
	MaximumSlidingWindow
*/
import java.util.*;

public class MaxSlidingWindow {
	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7}; // 7, 10
		int windowSize = 3;
		int[] result = maxSlidingWindowV1(arr, windowSize);
		System.out.println(Arrays.toString(result));
	}

	// brute force solution: have two loops and check for maximum using linear search
	// runtime : O(n * k) - where n = array size, k = window size
	private static int[] maxSlidingWindowV1(int[] arr, int windowSize){
		if(arr == null || arr.length == 0 || windowSize < 1) return arr;

		int[] result = new int[arr.length - windowSize + 1];
		int index = 0;

		for(int i = 0; i < arr.length - windowSize + 1; i++){
			int max = arr[i];
			int end = i + windowSize;

			for(int j = i; j < end; j++){
				if(arr[j] > max){
					max = arr[j];
				}
			}
			result[index++] = max;
		}
		return result;
	}
}