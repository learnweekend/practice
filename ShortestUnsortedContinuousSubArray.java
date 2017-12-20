/**
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1: Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You need to
 * sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in
 * ascending order. Note: Then length of the input array is in range [1,
 * 10,000]. The input array may contain duplicates, so ascending order here
 * means <=.
 */
public class ShortestUnsortedContinuousSubArray {
	
	
	/** solution :
	   1. Get the index where first dip from the start of the array(i)
	   2. get the index where bump from last of the array.(j)
	   3. get the min and max in the range (i and j)
	   4. Move the index i to left if there are any elements greater than min.
	   5. Move the index j to right if there are any elements lesser than max.
	   6. The final indices i and j indicate the array needs to be sorted.
	   */

	public static int findUnsortedSubarray(int[] arr) {
		
		if (arr == null || arr.length == 0)
			return 0;

		int start = 0;
		int end = arr.length - 1;

		// 1. get the index i where the first dip (start)
		while (start < arr.length - 1 && arr[start] <= arr[start + 1])   // note : <= for duplicates
			start++;
		
		if (start == arr.length - 1)  // to verify if array is already sorted
			return 0;
		
		// 2. get the index where bump from last of the array(end)
		while (end > 0 && arr[end] >= arr[end - 1])  // note <= to handle duplicates
			end--;
		
		// 3. get the min and max in the range (start and end)
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int k = start; k <= end; k++) {
			if (arr[k] > max) {
				max = arr[k];
			} else if (arr[k] < min) {
				min = arr[k];
			}
		}
		// 4. Move the index i to left if there are any elements greater than min
		while (start >= 0 && arr[start] > min)
			start--;
		
		// 5. Move the index j to right if there are any elements lesser than max.
		while (end < arr.length && arr[end] < max)
			end++;

		return (end - start - 1);
	}

	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
		System.out.println(findUnsortedSubarray(new int[] { 1, 2, 3, 4 }));
		System.out.println(findUnsortedSubarray(new int[] { 1, 2, 3, 3, 3 }));
	}

}
