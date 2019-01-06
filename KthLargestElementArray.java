package leetcode;

import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the
 * sorted order, not the kth distinct element.
 * 
 * Example 1: Input: [3,2,1,5,6,4] and k = 2 Output: 5
 * 
 * Example 2: Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
 */
public class KthLargestElementArray {

	public static int findKthLargest(int[] arr, int k) {
		k = arr.length - k;
		shuffle(arr);   // for randomness
		int low = 0;
		int high = arr.length - 1;

		while (high > low) {
			int j = partition(arr, low, high);
			if (j < k)
				low = j + 1;
			else if (j > k)
				high = j - 1;
			else
				return arr[k];
		}
		return arr[k];
	}

	private static int partition(int[] arr, int low, int high) {
		int index = low;
		int pivotValue = arr[low]; // 0th element is the pivot

		while (index <= high) {
			if (arr[index] < pivotValue && index <= high)
				swap(arr, low++, index++);
			else if (arr[index] > pivotValue)
				swap(arr, index, high--);
			else
				index++;
		}
		return index - 1;
	}

	private static void shuffle(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		for (int i = 0; i < arr.length; i++) {
			Random random = new Random();
			int randomInt = random.nextInt(i + 1);
			swap(arr, i, randomInt);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2)); // 5
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4)); // 4
	}
}
