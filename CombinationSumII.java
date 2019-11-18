package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * Given a collection of candidate numbers (candidates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set must not contain
 * duplicate combinations.
 * 
 * Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1, 7], [1, 2, 5], [2, 6],
 * [1, 1, 6] ]
 * 
 * Example 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5, A solution set is: [ [1,2,2], [5] ]
 *
 */
public class CombinationSumII {
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum2(candidates, 0, target, new ArrayList<Integer>(), result);
		return result;
	}

	private static void combinationSum2(int[] array, int start, int target, List<Integer> subList,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(subList));
			return;
		}

		for (int i = start; i < array.length; i++) {
			if (array[i] <= target) {
				if(i == start || array[i] != array[i - 1]) {
					subList.add(array[i]);
					combinationSum2(array, i + 1, target - array[i], subList, result);
					subList.remove(subList.size() - 1);
				}
			} 
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8)); // [ [1, 7], [1, 2, 5], [2, 6],[1, 1, 6] ]
		System.out.println(combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5)); // [ [1,2,2], [5] ]
	}
}
