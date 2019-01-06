package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** https://leetcode.com/problems/majority-element-ii/description/
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 * Example 1:
 * Input: [3,2,3] Output: [3]
 * Example 2:
 * Input: [1,1,1,3,3,2,2,2] Output: [1,2]
 */
public class MajorityElementII {
	/**
	 * Soultuion: Since the majorityElement is > array length/3 There will be a MAXIMUM of two majority
	 * elements exists. So track the count of two majority elements Runtime : O(N), Space : O(1)
	 */
	private static List<Integer> findMajorityElements(int[] arr) {
		Set<Integer> majorityElements = new HashSet<Integer>(); // set to avoid duplicates
		if (arr == null || arr.length == 0)
			return new ArrayList<Integer>(majorityElements);

		if (arr.length == 2) { // base case... two majority elements exists.
			majorityElements.add(arr[0]);
			majorityElements.add(arr[1]);
			return new ArrayList<Integer>(majorityElements);
		}
		int countOne = 1;
		int countTwo = 1;
		int majorityElementOne = arr[0];
		int majorityElementTwo = arr[0];
		int threshold = arr.length / 3;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == majorityElementOne) {
				countOne++;
			} else if (arr[i] == majorityElementTwo) {
				countTwo++;
			} else if (countOne == 0) {
				majorityElementOne = arr[i];
				countOne++;
			} else if (countTwo == 0) {
				majorityElementTwo = arr[i];
				countTwo++;
			} else {
				countOne--;
				countTwo--;
			}
		}
		countOne = 0;
		countTwo = 0;
		for (int i = 0; i < arr.length; i++) { // track the acutal count
			if (arr[i] == majorityElementOne)
				countOne++;
			else if (arr[i] == majorityElementTwo)
				countTwo++;
		}
		if (countOne > threshold) // check for threshold (length/3)
			majorityElements.add(majorityElementOne);
		
		if (countTwo > threshold)
			majorityElements.add(majorityElementTwo);

		return new ArrayList<Integer>(majorityElements);
	}

	public static void main(String[] args) {
		System.out.println(findMajorityElements(new int[] { 3, 2, 3 }));
		System.out.println(findMajorityElements(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 }));
	}
}
