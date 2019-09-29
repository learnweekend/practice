package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/description/ 
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * Example:
 * 
 * Input: n = 4, k = 2 Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 */
public class Combinations {
	
	public List<List<Integer>> combine(int n, int k) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		List<List<Integer>> combinations = new ArrayList<>();
		int[] buffer = new int[k];
		combine(nums, 0, buffer, 0, combinations);
		return combinations;
	}
	
	/**
	 *  1. base case when bufferInex == buffer.length - print the array and return;
	 *  2. Check the termination case, when startIndex == nums.length, then return
	 *  3. Find the candiate element to go in buffer
	 *  4. insert the candiate element in buffer
	 *  5. recurse the next buffer index
	 *  Runtime : O( 2 ^ N), Space : O(N);
	 */
	public void combine(int[] nums, int startIndex, 
			int[] buffer, int bufferIndex, 
			List<List<Integer>> result) {
		 
		if (bufferIndex == buffer.length) {   // 1. basecase
			List<Integer> list = new ArrayList<>(buffer.length);
			for (int i = 0; i < buffer.length; i++) {
				list.add(buffer[i]);
			}
			result.add(list);
			return;
		}

		if (startIndex == nums.length)   // 2. program temination case
			return;

		for (int i = startIndex; i < nums.length; i++) {  // 3 next candidate to buffer
			buffer[bufferIndex] = nums[i];   // 4. insert candidate into buffer
			combine(nums, i + 1, buffer, bufferIndex + 1, result);  // 5. recurse for next bufferIndex
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int k = 2;
		Combinations obj = new Combinations();
		List<List<Integer>> combos = obj.combine(n, k);  
		for(List<Integer> combo : combos)
			System.out.println(combo);
	}
}
