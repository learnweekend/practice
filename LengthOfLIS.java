package interviewbit;

import java.util.Arrays;
/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
	Example:
	Input: [10,9,2,5,3,7,101,18]
	Output: 4 
	Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
	Note:
    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.
    
	Follow up: Could you improve it to O(n log n) time complexity?
 */

public class LengthOfLIS {

	public static void main(String[] args) {
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		//int[] arr = {10,9,2,5,3,7,101,18}; // 4
		//int[] arr = {1}; // 1
		System.out.println(lengthOfLISRecursion(arr));
		System.out.println(lengthOfLIS(arr));
	}
	
	public static int lengthOfLISRecursion(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		return lengthOfLISRecursion(arr, Integer.MIN_VALUE, 0);
	}
	
	/**
	 *  1. Loop through the array and consider the following cases
	 *  	a) Recursive call When the current element is greater than previous element  (1 + recursive())
	 *  	b) Recursive when the current element is not greater than previous element
	 *  2. Take the maximum of above two cases and return.
	 *  Runtime : O(2 ^ N)
	 *  Space : O(N);
	 */
	public static int lengthOfLISRecursion(int[] arr, int previousVal, int position) {
		if(position == arr.length)
			return 0;
		int lengthIncludeCurrent = 0;
		if(arr[position] > previousVal) {  // case 1, 
			lengthIncludeCurrent = 1 + lengthOfLISRecursion(arr, arr[position], position + 1);
		}
		int lengthExcludeCurrent = lengthOfLISRecursion(arr, previousVal, position + 1); // case2 - current is not included
		return Math.max(lengthIncludeCurrent, lengthExcludeCurrent);
	}
	
	/**
	 *  1. check for base case if array is empty or null
	 *  2. take addition space (cache) to store the intermediate results
	 *  3. keep moving for till the end of the array and calculate the LIS for each position in array
	 *  4. Loop through the cache and get the maximum number - which is longest LIS.
	 *  Runtime : O(N ^ 2)
	 *  Space : O(N);
	 */
	public static int lengthOfLIS(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int[] cache = new int[arr.length];  // to store the LIS count to that position
		Arrays.fill(cache,  1);  // defaulted to 1, since every element is LIS of length 1
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					cache[i] = Math.max(cache[i], cache[j] + 1);
			}
		}
		int max = 1;  
		for(int i = 0; i < cache.length; i++) {  // take the maximum value from the cache
			if(cache[i] > max)
				max = cache[i];
		}
		return max;
	}
}
