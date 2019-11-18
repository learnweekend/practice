package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/submissions/ Given a set of candidate numbers
 * (candidates) (without duplicates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set must not contain
 * duplicate combinations.
 * 
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7, A solution set is: [ [7], [2,2,3] ]
 * 
 * Example 2:
 * Input: candidates = [2,3,5], target = 8, A solution set is: [ [2,2,2,2], [2,3,3], [3,5] ]
 */
public class CombinationSum {
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(candidates, 0, target, new ArrayList<Integer>(), result);
		return result;
	}

	private static void combinationSum(int[] array, int start, int target, List<Integer> subList,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(subList));
			return;
		}

		for (int i = start; i < array.length; i++) {
			if (array[i] <= target) {
				subList.add(array[i]);
				combinationSum(array, i, target - array[i], subList, result);
				subList.remove(subList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));  // [ [7], [2,2,3] ]
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));  // [ [2,2,2,2], [2,3,3], [3,5] ]
	}

}
