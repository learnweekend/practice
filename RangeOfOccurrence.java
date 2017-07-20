/*
Given a sorted array of integers that contains each entry multiple times, find the start and end position of a target integer.
e.g:
input:
	sorted array: 1, 2, 3, 7, 7, 7, 9, 9
	target: 7
output:
	start position: 3
	end position  : 5
*/
import java.util.*;

public class RangeOfOccurrence  {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 7, 7, 7, 9, 9};
		int target = 9;
		int[] range = findRangeOfOccurence(arr, target);
		System.out.println("Original array  = " + Arrays.toString(arr));
		System.out.println("Target"+"(" + target+") Range = " + Arrays.toString(range));
		System.out.println("Target elements = " + Arrays.toString(Arrays.copyOfRange(arr, range[0], range[1]+1)));
	}

	/* Solution :
	1. Do a binary search and find start index with "target" element to search = (target - 0.5)
	2. Do a binary search and find end index with "target" element to search = (target + 0.5)
	3. Note : The end index will be "1" more than acutal index.
		Runtime : O(log N), Space : O(1);
	*/

	private static int[] findRangeOfOccurence(int[] arr, int target){

		if(arr == null)
			throw new IllegalArgumentException();

		int startIndex = findIndexBinarySearch(arr, target - 0.5);

		if(startIndex >= arr.length || arr[startIndex] != target){
			return new int[]{-1, -1};
		}
		int endIndex = findIndexBinarySearch(arr, target + 0.5);

		return new int[]{startIndex, endIndex - 1}; //  less 1.
	}

	private static int findIndexBinarySearch(int[] arr, double target){
		int start = 0;
		int end = arr.length - 1;
		while(start <= end){   // Note:   start <= end
			int mid = (start + end) /2;  // Note : (start + end)/2, calculate the middle inside the while loop
			if(target > arr[mid]) {
				start = mid + 1;  // update start
			} else {
				end = mid - 1;  // update end
			}
		}
		return start;
	}

}
