package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/ 
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4] Output: 24
 */
public class MaxProductOf3Numbers {

	// Runtime : O(N) | Space : O(1)
	public static int maxProductOf3Numbers(int[] array) {
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		int thirdLargest = Integer.MIN_VALUE;
		int firstSmallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			if (value >= firstLargest) { // >= to handle duplicates
				thirdLargest = secondLargest;
				secondLargest = firstLargest;
				firstLargest = value;
			} else if (value >= secondLargest) { // >= to handle duplicates
				thirdLargest = secondLargest;
				secondLargest = value;
			} else if (value >= thirdLargest) { // >= to handle duplicates
				thirdLargest = value;
			}

			if (value < firstSmallest) {
				secondSmallest = firstSmallest;
				firstSmallest = value;
			} else if (value < secondSmallest) {
				secondSmallest = value;
			}
		}
		return Math.max(firstSmallest * secondSmallest * firstLargest, 
            thirdLargest * secondLargest * firstLargest);
	}

	public static void main(String[] args) {
		System.out.println(maxProductOf3Numbers(new int[] { 1, 2, 3 }));  //6
		System.out.println(maxProductOf3Numbers(new int[] { 1, 2, 3, 4 })); // 24
		System.out.println(maxProductOf3Numbers(new int[] { -3, -5, 3, 4 })); // 60
	}
}
