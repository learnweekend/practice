package leetcode;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the
 * two sorted arrays. The overall run time complexity should be O(log (m+n)). You may assume nums1
 * and nums2 cannot be both empty.
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2] The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int[] X, int[] Y) {
		double median = 0.0;

		// make sure the X is smaller so that we can apply the binary search on this array
		if (X.length > Y.length) {
			return findMedianSortedArrays(Y, X);
		}

		int xLength = X.length;
		int yLength = Y.length;

		int start = 0;
		int end = xLength;

		int totalMiddle = (xLength + yLength + 1) / 2;

		while (start <= end) {
			int partitionX = (start + end) / 2;
			int partitionY = totalMiddle - partitionX;

			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : X[partitionX - 1];
			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : Y[partitionY - 1];

			int minRightX = partitionX == xLength ? Integer.MAX_VALUE : X[partitionX];
			int minRightY = partitionY == yLength ? Integer.MAX_VALUE : Y[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // found the correct partion
				if ((xLength + yLength) % 2 == 0) { // even numbers
					median = (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
					return median;
				} else {  // odd number of elements
					median = Math.max(maxLeftX, maxLeftY) / 1.0;
					return median;
				}
			} else if (maxLeftX > minRightY) {
				end = partitionX - 1;
			} else {
				start = partitionX + 1;
			}
		}
		return median;
	}

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 })); // 2
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 })); // 2.5
	}

}
