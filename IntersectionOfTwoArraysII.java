package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * Given two arrays, write a function to compute their intersection.
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:
    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.
Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {
	
	/*
	 * Take a hashmap<number, numberofOccurances> to store number of occurances of each digit in the input
	 * loop through the second array and check if map contains them.
	 * have a list to store the common elements along with duplicates
	 * if present decrement the value and move on.
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
      List<Integer> intersection = new ArrayList<>();
      if(nums1 == null || nums1.length == 0)
          return new int[0];
       if(nums2 == null || nums2.length == 0)
          return new int[0];
      
      Map<Integer, Integer> numCountMap = new HashMap<>();
      for(int val : nums1) {
          if(numCountMap.containsKey(val)) {
              numCountMap.put(val, numCountMap.get(val) + 1);
          } else {
              numCountMap.put(val, 1);
          }
      }
      for(int val : nums2) {  // check if 2nd array has any common elements with first array
          if(numCountMap.containsKey(val) && numCountMap.get(val) > 0) {
              intersection.add(val);   // add common elements to list
              numCountMap.put(val, numCountMap.get(val) - 1);
          }
      }
      if(intersection.size() > 0) {  // convert nums array to list
          int[] result = new int[intersection.size()];
          for(int i = 0; i < result.length; i++) {
              result[i] = intersection.get(i);
          }
         return result; 
      } 
      return new int[0];
  }
  
	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] {1,2,2,1} , new int[] {2,2})));
		System.out.println(Arrays.toString(intersect(new int[] {4,9,5} , new int[] {9,4,9,8,4})));
	}
	
	/*
	Q. What if the given array is already sorted? How would you optimize your algorithm?

	If both arrays are sorted, I would use two pointers to iterate, which somehow resembles the merge process in merge sort.

	Q. What if nums1's size is small compared to nums2's size? Which algorithm is better?

	Suppose lengths of two arrays are N and M, the time complexity of my solution is O(N+M) and the space complexity if O(N) considering the hash. So it's better to use the smaller array to construct the counter hash.

	Well, as we are calculating the intersection of two arrays, the order of array doesn't matter. We are totally free to swap to arrays.

	Q. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

	Divide and conquer. Repeat the process frequently: Slice nums2 to fit into memory, process (calculate intersections), and write partial results to memory

	*/
}
