package com.all;

import java.util.Arrays;

public class MoveZeros {
	
	/**
	 * Solution : Brute force
	 * 1. Traverse the array from end and place the non-zero elements from end.
	 * 2. During the traversal count the number of zeros.
	 * 3. Fill the zeros in the start to match the zeros count.
	 * Runtime : O(N), Space : O(1)
	 */
	private static void moveZerosToLeft(int[] arr){
		
		int index = arr.length - 1;
		int zerosCount = 0;
		
		for(int i = arr.length - 1; i >= 0; i--){
			if(arr[i] != 0){
				arr[index--] = arr[i];
			} else {
				zerosCount++;
			}
		}
		for(int i = 0; i < zerosCount; i++){
			arr[i] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * Solution : Brute force
	 * 1. Traverse the array from start and place the non-zero elements from beginning.
	 * 2. During the traversal count the number of zeros.
	 * 3. Fill the zeros in the end to match the zeros count.
	 * Runtime : O(N), Space : O(1)
	 */
	private static void moveZerosToRight(int[] arr){
		
		int index = 0;
		int zerosCount = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != 0){
				arr[index++] = arr[i];
			} else {
				zerosCount++;
			}
		}
		for(int i = 0; i < zerosCount; i++){
			arr[index++] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}


	public static void main(String[] args) {
		moveZerosToLeft(new int[] {1, 2, 3, 0, 0, 4, 0, 5, 0, 6});
		moveZerosToLeft(new int[] {1,0});
		moveZerosToLeft(new int[] {0, 1});
		moveZerosToLeft(new int[] {0});
		
		moveZerosToRight(new int[] {1, 2, 3, 0, 0, 4, 0, 5, 0, 6});
		moveZerosToRight(new int[] {1,0});
		moveZerosToRight(new int[] {0, 1});
		moveZerosToRight(new int[] {0});
	}

}
