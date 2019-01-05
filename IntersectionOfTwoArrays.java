package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 # 349 : https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:
    Each element in the result must be unique.
    The result can be in any order.
 */
public class IntersectionOfTwoArrays {
	
	/*
	 * Take a Set<number> to store each unique digit in the input
	 * loop through the second array and check if set contains them. make sure we are not adding duplicate elements to result
	 * have a list to store the common elements along with duplicates
	 * if present decrement the value and move on.
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> intersection = new ArrayList<>();
		Set<Integer> intElements = new HashSet<>();
		if (nums1 == null || nums1.length == 0)
			return new int[0];
		if (nums2 == null || nums2.length == 0)
			return new int[0];

		Set<Integer> set = new HashSet<>();
		for (int val : nums1) {
			if (!set.contains(val))
				set.add(val);
		}
		for (int val : nums2) {
			if (set.contains(val) && !intElements.contains(val)) {
				intersection.add(val);
				intElements.add(val);
			}
		}
		if (intersection.size() > 0) { // convert nums array to list
			int[] result = new int[intersection.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = intersection.get(i);
			}
			return result;
		}
		return new int[0];
	}
  
	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] {4,9,5} , new int[] {9,4,9,8,4})));
	}
}
