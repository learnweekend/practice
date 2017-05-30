
import java.util.*;
/**
  Problem :  Given an Integer array, find all sub arrays that sum to 0 (zero).
*/
public class SubArraysSumToZero {
  public static void main(String args[]) {
		int[] a = {1, 2, -5, 1, 2, -1};
		// int[] a = { 3, 3, 4, -9, -1 };
		// int[] a = {5, 3, 4, -9, 1, 1, 11 };
		// int[] a = { 5, 3, -4, -5, 1, 1, 11 };
		// int[] a = { 8, 4, 23, -10, 3, 2, 5};
		// int[] a = { 4, 6, 3, -9, -5, 1, 3, 0, 2 };
		System.out.println("output -> using brute-force..");
		List<int[]> results = findSubArraysSumToZeroV1(a);
		for (int[] result : results) {
			System.out.println(Arrays.toString(result));
		}
		System.out.println();
		System.out.println("output -> using hashmap .. ");
		results = findSubArraysSumToZeroV2(a);
		for (int[] result : results) {
			System.out.println(Arrays.toString(result));
		}
	}
  /* Solution 1 : brute-force : loop through the array and have anohter inner loop
    to scan entire array for sum to 0.
    Runtime : O(N^2)
    Space   : O(1)
  */
	private static List<int[]> findSubArraysSumToZeroV1(int[] arr) {
		List<int[]> subArrays = new ArrayList<>();
		int N = arr.length;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			if(arr[i] == 0){
				subArrays.add(new int[] {0});
			}
			sum = arr[i];
			for (int j = i + 1; j < N; j++) {
				sum += arr[j];
				if (sum == 0) {
					subArrays.add(Arrays.copyOfRange(arr, i, j + 1));
				}
			}
		}
		return subArrays;
	}
  /* Solution 2 : loop the array and with sum of each element and add current sum to hash map.
    if sum exists already in the map then subarray exists with sum to 0.
    Runtime : O(N)
    Space   : O(N)
  */
	private static List<int[]> findSubArraysSumToZeroV2(int[] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException();

		int N = arr.length;
		Map<Integer, Integer> sumIndexMap = new HashMap<Integer, Integer>();
		List<int[]> subArrays = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if (sum == 0) {
				subArrays.add(Arrays.copyOfRange(arr, 0, i + 1));
			} else if (sumIndexMap.containsKey(sum)) {
				int startIndex = sumIndexMap.get(sum);
				subArrays.add(Arrays.copyOfRange(arr, startIndex + 1, i + 1));
			} else {
				sumIndexMap.put(sum, i);
			}
		}
		return subArrays;
	}
}
