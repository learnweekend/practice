package com.all;

import java.util.Arrays;


public class RotateArray {
	
	/**
	 * solution :
	 * 1. divide the array into two parts based on positions to rotate.
	 * 2. reverse the first part
	 * 3. reverse the second part.
	 * 4. reverse the total array.
	 * 5. runtime : O(N), space : O(1);
	 */
	private static void rotateArray(int[] arr, int positions){
		if(arr == null || arr.length == 0) return;
		if(positions == 0 || positions == arr.length) return;
		if(positions > arr.length)
			positions =  positions % arr.length;
		reverse(arr, 0, arr.length - 1 - positions);
		reverse(arr, arr.length - positions, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}
	
	private static void reverse(int[] arr, int start, int end){
		if(start >= end) return ;
		
		while(start <= end){
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int positions = 3;
		rotateArray(arr, positions);
		System.out.println(Arrays.toString(arr));
	}

}
