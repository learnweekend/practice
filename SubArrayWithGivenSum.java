/*
 You're given an unsorted array positive integers and a number "targetSum". Your task is to find a contiguous subarray that has a
 sum equal to "targetSum" and return an array containing the two integers that represent its inclusive bounds.
 If there are no answers, return [-1].  */

import java.util.*;

public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		// int[] a = { 23, 2, 4, 6, 7 };
		// int targetSum = 6; // 2 4
		// int[] a = { 1, 4, 20, 3, 10, 5 };
		// int targetSum = 33; // 20 3 10
		// int[] a = {1, 4, 0, 0, 3, 10, 5};
		// int targetSum = 7; // 4 0 0 3
		// int[] a = {1, 4};
		// int targetSum = 0; // not found
		// int a[] = {15, 2, 4, 8, 9, 5, 10, 23};
		// int targetSum = 23; // 2 4 8 9
		// int[] a = { -4, 5, -6, 7, 8, 9, 10 };
		// int targetSum = 2;
		// int[] a = {4, 8, 9, 10, 3, 8};
		// int targetSum = 21;
		int[] a = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28,
				162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117,
				119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12,
				123, 134 };

		int targetSum = 468;

		int[] subarray = subArrayWithGivenSum(a, targetSum);
		if (subarray == null)
			System.out.println("subarray not found for a given sum");
		else
			System.out.println(Arrays.toString(Arrays.copyOfRange(a,subarray[0], subarray[1] + 1)));

		int[] subarray2 = subArrayWithGivenSumV2(a, targetSum);
		if (subarray2 == null)
			System.out.println("subarray not found for a given sum");
		else
			System.out.println(Arrays.toString(Arrays.copyOfRange(a,subarray2[0], subarray2[1] + 1)));
	}
	/*
	 * Solution :
	 * 1. Have two pointers startIndex and endIndex at the start of the array.
	 * 2. Have the forst element assigned to assigned
	 * 3. Loop through the array and check currSum with targetSum.
	 * 4. Move startIndex pointer forward if "currSum > targetSum" and update the currSum.
	 * 5. Move the endIndex pointer forward if currSum < targetSum and update the currSum.
	 * 6. Make sure the startIndex and endIndex pointers doesn't fall out of array bound exception.
	 *
	 *    Runtime : O(N)
	 *    Space : O(1)
	 */
	private static int[] subArrayWithGivenSumV2(int[] arr, int targetSum) {
		if (arr == null || arr.length == 0 || arr.length < 2)
			throw new IllegalArgumentException();
		int startIndex = 0;
		int endIndex = 0;
		int currSum = arr[0];

    while (true) {
			if (currSum < targetSum) {
				endIndex++; // move endIndex forward
				if (endIndex == arr.length) // check of endIndex out of array
					return new int[] { -1 }; // not found if reach end of array
				currSum += arr[endIndex]; // update currSum
			} else if (currSum > targetSum) {
				currSum -= arr[startIndex]; // update the currSum
				startIndex++; // move startIndex forward
			} else { // found
				return new int[] { startIndex, endIndex }; // match found, return indices
			}
		}
	}
	/*
	 * Solution 2:  Same approach as solution 1 above.
	 */
	private static int[] subArrayWithGivenSum(int[] a, int targetSum) {
		if (a == null || a.length == 0 || a.length < 2)
			throw new IllegalArgumentException();
		int start = 0;
		int end = 1;
		int currSum = a[0] + a[1];

		while (start < a.length && end < a.length) { // check for start and end indices
			if (currSum == targetSum)
				return new int[] { start, end }; // return start and end indices if subarray found
			else if (currSum > targetSum) {
				currSum = currSum - a[start]; // update the currSum
				start++; // move start forward
			} else {
				end++; // move end forward
				if (end < a.length) // make sure the end index doesn't exceed array length
					currSum = currSum + a[end]; // update the currSum
			}
		}
		return new int[] { -1 }; // if subarray not found
	}

}
