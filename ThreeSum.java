package com.ravi;
/*
 https://leetcode.com/problems/3sum/description/
 Problem : ThreeSum, Given an integer array (unsorted), return indices of three elements
 such that sum of three elements = 0
 */

import java.util.*;

public class ThreeSum {
	// Solution 1 : brute-force, Runtime : O(N^3), Space : O(1)
	private static List<int[]> threeSumV1(int[] a) {
		if (a == null || a.length < 3)
			throw new IllegalArgumentException("input array cannot be null or invalid");
		List<int[]> results = new ArrayList<int[]>();
		int N = a.length;

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						results.add(new int[] { a[i], a[j], a[k] });
					}
				}
			}
		}
		return results;
	}

	/*
	 * Solution 2: Sort the array and have pointers one at start and one at end
	 * and move accordingly Runtime : O(N^2) Space : O(1) This solutions handles
	 * duplicate elements. This is same as solution 3
	 */
	public static List<List<Integer>> threeSumV2(int[] a) {
		List<List<Integer>> result = new LinkedList<>();

		if (a == null)
			throw new IllegalArgumentException("array cannot be null or empty");

		if (a.length == 3) { // base case
			if (a[0] + a[1] + a[2] == 0)
				result.add(Arrays.asList(a[0], a[1], a[2]));
			return result;
		}
		Arrays.sort(a);

		for (int i = 0; i < a.length - 3; i++) {
			// to avoid duplicate elements if
			if (i == 0 || a[i] > a[i - 1]) {
				int start = i + 1;
				int end = a.length - 1;

				while (start < end) {
					int sum = a[i] + a[start] + a[end];
					if (sum == 0) {
						result.add(Arrays.asList(a[i], a[start], a[end]));

						int temp = start;
						// move start pointer forward
						while (a[start] == a[temp] && start < end) {
							start++;
						}
						temp = end;
						// move end pointer backward
						while (a[end] == a[temp] && start < end) {
							end--;
						}
					} else if (sum < 0) {
						int temp = start;
						// to avoid duplicate elements at start pointer position
						while (a[start] == a[temp] && start < end) {
							start++;
						}
					} else {
						int temp = end;
						// to avoid duplicate elements at end pointer position
						while (a[end] == a[temp] && start < end) {
							end--;
						}
					}
				}
			}
		}
		return result;
	}

	/*
	 * Solution 3: Sort the array and have pointers one at start and one at end
	 * and move accordingly Runtime : O(N^2) Space : O(1) This solutions handles
	 * duplicate elements. This is same as solution 2
	 */
	public static ArrayList<int[]> threeSumV3(int[] arr) {
		ArrayList<int[]> results = new ArrayList<int[]>();

		if (arr.length == 3) { // base case
			if (arr[0] + arr[1] + arr[2] == 0)
				results.add(new int[] { arr[0], arr[1], arr[2] });
			return results;
		}

		Arrays.sort(arr); // sort the array

		for (int i = 0; i < arr.length - 3; i++) {
			if (i == 0 || arr[i] > arr[i - 1]) {
				int start = i + 1;
				int end = arr.length - 1;

				while (start < end) {
					if (arr[i] + arr[start] + arr[end] == 0) {
						results.add(new int[] { arr[i], arr[start], arr[end] });
					}

					if (arr[i] + arr[start] + arr[end] < 0) {
						int currentStart = start;
						while (arr[start] == arr[currentStart] && start < end) {
							start++;
						}
					} else {
						int currentEnd = end;
						while (arr[end] == arr[currentEnd] && start < end) {
							end--;
						}
					}
				}
			}
		}
		return results;
	}

	/*
	 * Solution 4: Take the extra memory(HaMap) to store the value and indices
	 * Runtime : O(N^2) Space : O(N) NOTE: This solution doesn't handle the duplicate elements
	 */
	public static List<List<Integer>> threeSumV4(int[] a) {
		List<List<Integer>> result = new LinkedList<>();

		if (a == null || a.length == 0)
			throw new IllegalArgumentException("Input cannot be null or empty..");
		int N = a.length;

		if (N == 3) {
			if (a[0] + a[1] + a[2] == 0)
				result.add(Arrays.asList(a[0], a[1], a[2]));
			return result;
		}
		for (int i = 0; i < N; i++) {
			int sum = 0 - a[i];
			int[] twoSum = checkIfTwoSumExists(a, sum);
			if (twoSum != null && twoSum.length > 0)
				result.add(Arrays.asList(a[i], a[twoSum[0]], a[twoSum[1]]));
		}
		return result;
	}

	// helper method to solve TwoSum problem using extra memory
	private static int[] checkIfTwoSumExists(int[] a, int targetSum) {
		if (a == null || a.length == 0)
			throw new IllegalArgumentException("Input cannot be null or empty..");
		Map<Integer, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (indexMap.containsKey(targetSum - a[i]))
				return new int[] { indexMap.get(targetSum - a[i]), i };
			else
				indexMap.put(a[i], i);
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] a = { -1, 0, 1, 2, -1, -4 };
		// int[] a = { 0, 0, 0 };
		// int[] a = {-2,0,0,2,2 };
		// int[] a = {-2, -1, 3};
		System.out.println(" Version 1 ");
		List<int[]> result1 = threeSumV1(a);
		for (int[] list : result1) {
			System.out.println(Arrays.toString(list));
		}
		System.out.println();
		System.out.println(" Version  2 ");
		List<List<Integer>> result2 = threeSumV2(a);
		for (List<Integer> list : result2) {
			System.out.println(list);
		}
		System.out.println();
		System.out.println(" Version 3 ");
		List<int[]> result3 = threeSumV3(a);
		for (int[] list : result3) {
			System.out.println(Arrays.toString(list));
		}
		System.out.println();
		System.out.println(" Version 4 ");
		List<List<Integer>> result4 = threeSumV4(a);
		for (List<Integer> list : result4) {
			System.out.println(list);
		}
	}
}
