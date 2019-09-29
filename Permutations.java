package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations/description/
 * Given a collection of distinct integers, return all possible permutations.
 * 
Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations {

	// Runtime : O(n * n!)  |  space : O(n * n!)
	public static List<List<Integer>> getPermutations(ArrayList<Integer> array) {
		List<List<Integer>> permutations = new ArrayList<>();
		
		if (array == null || array.size() == 0)
			return permutations;

		permutations(array, permutations, 0);
		return permutations;
	}

	private static void permutations(List<Integer> array, final List<List<Integer>> permutations, int index) {
		if (index == array.size()) {
			ArrayList<Integer> permute = new ArrayList<>(array);
			permutations.add(permute);
			return;
		}
		Set<Integer> set = new HashSet<>(); // to handle duplicates
		for (int i = index; i < array.size(); i++) {
			if (set.add(array.get(i))) {   // to handle duplicate values in input array
				swap(array, index, i);
				permutations(array, permutations, index + 1);
				swap(array, index, i);
			}
		}
	}

	public static List<String> stringPermutations(String str) {
		if (str == null || str.length() == 0)
			throw new IllegalArgumentException();
		
		List<String> permutations = new ArrayList<String>();
		stringPermutations("", str, permutations);
		return permutations;
	}

	private static void stringPermutations(String prefix, String suffix, List<String> permutations) {
		if (suffix.length() == 0)
			permutations.add(prefix);
		else {
			for (int i = 0; i < suffix.length(); i++) {
				stringPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1),
						permutations);
			}
		}
	}

	private static void swap(List<Integer> array, int i, int j) {
		int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 2, 4));
		List<List<Integer>> permutations = getPermutations(array);
		
		for (List<Integer> permute : permutations)
			System.out.println(permute);
		
		System.out.println("Total number of permutations : " + permutations.size());
		
		System.out.println(stringPermutations("abcd"));
	}
}
