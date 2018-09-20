package interviewcamp;

/**
 * Given an array of numbers, replace each even number with two of the same number. 
 * e.g, [1,2,5,6,8] -> [1,2,2,5,6,6,8,8]. 
 * Assume that the array has enough space to accommodate the result.
 */

import java.util.Arrays;

public class CloneEvenNumbers {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, -1, -1, -1 };
		cloneEvenNumbers(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void cloneEvenNumbers(int[] arr) {
		
		if (arr == null || arr.length == 0)
			return;

		int end = arr.length - 1;
		int lastIndex = findLastIndexElement(arr);

		if (lastIndex == -1)
			return;

		while (lastIndex >= 0) {
			if (arr[lastIndex] % 2 == 0) {
				arr[end--] = arr[lastIndex];
				arr[end--] = arr[lastIndex];
			} else {
				arr[end--] = arr[lastIndex];
			}
			lastIndex--;
		}
	}

	public static int findLastIndexElement(int[] arr) {
		int end = arr.length - 1;

		while (end >= 0) {
			if (arr[end] != -1)
				return end;
			end--;
		}
		return -1;
	}

}
