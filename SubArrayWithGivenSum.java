/*
  You're given an unsorted array arr of positive integers and a number s.
  Your task is to find a contiguous subarray that has a sum equal to s,
  and return an array containing the two integers that represent its inclusive bounds.
  If there are several possible answers, return the one with the smallest left bound.
  If there are no answers, return [-1].
*/
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
		int[] a = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28,	162, 92, 196, 143, 28, 37, 192,
      5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12,123, 134 };
		int targetSum = 468;

		int[] subarray = subArrayWithGivenSum(a, targetSum);
		if (subarray == null)
			System.out.println("subarray not found for a given sum");
		else
			System.out.println(Arrays.toString(Arrays.copyOfRange(a, subarray[0], subarray[1] + 1)));
	}
  /*
  Solution : Have two pointers start at first element and calculate the currSum
             Loop through the array and check currSum with targetSum.
             Move start pointer forward if currSum > targetSum and update the currSum
             Move the end pointer forward if currSum < targetSum and update the currSum
             Make sure the start and end pointer doesn't fall out of array bound exception.
  Runtime  : O(N)
  Space    : O(1)
  */
  private static int[] subArrayWithGivenSumV2(int[] arr, int targetSum) {
    int startIndex = 0;
    int endIndex = 0;
    int currSum = arr[0];
    while (true) {
        if (currSum < targetSum) {
            endIndex++;  // move endIndex forward
            if (endIndex == arr.length)  // check of endIndex out of array
                return new int[] {-1};  // not found if reach end of array
            currSum += arr[endIndex];  // update currSum
        } else if (currSum > targetSum) {
            currSum -= arr[startIndex];   // update the currSum
            startIndex++;   // move startIndex forward
        } else {  // found
            return new int[] {startIndex, endIndex};  // match found, return indices
        }
    }
  }

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
				currSum = currSum - a[start];  // update the currSum
				start++;   // move start forward
			} else {
				end++;  // move end forward
				if (end < a.length)   // make sure the end index doesn't exceed array length
					currSum = currSum + a[end]; // update the currSum
			}
		}
		return new int[] { -1 };  // if subarray not found
	}

}
