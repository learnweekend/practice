/*
Problem : 1. Given a string, print all permutations of the given string.
          2. Given an integer array, print all permutation arrays
*/

import java.util.*;

public class Permutations {
	public static void main(String[] args) {

		// Case 1 : String permutations
		String str = "abcd";
		List<String> permutations = stringPermutations(str);
		System.out.println("# of permutaions of string length " + str.length() + " = " + permutations.size());
		for (String s : permutations) {
			System.out.println(s);
		}

		// Case 2 : Array Permutations
		int[] arr = { 1, 2, 3, 4 };
		List<int[]> arrayPermutations = arrayPermutations(arr);
		System.out.println("# of permutaions of array length " + arr.length + " = " + permutations.size());
		for (int[] a : arrayPermutations) {
			System.out.println(Arrays.toString(a));
		}
	}
	/*
	 * string permutations,  Runtime : O(N!), Space : O(1)
	 */
	private static List<String> stringPermutations(String str) {
		if (str == null || str.length() == 0) throw new IllegalArgumentException();
		List<String> permutations = new ArrayList<String>();
		stringPermutations("", str, permutations);
		return permutations;
	}

	private static void stringPermutations(String prefix, String suffix, List<String> permutations) {
		if (suffix.length() == 0)
			permutations.add(prefix);
		else {
			for (int i = 0; i < suffix.length(); i++) {
				stringPermutations(prefix + suffix.charAt(i),
						suffix.substring(0, i) + suffix.substring(i + 1),
						permutations);
			}
		}
	}
	/*
	 * integer/char array permutations,  Runtime : O(N!), Space : O(1)
	 */
	private static List<int[]> arrayPermutations(int[] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException();
		List<int[]> permutations = new ArrayList<int[]>();
		arrayPermutations(arr, 0, permutations);
		return permutations;
	}

	private static void arrayPermutations(int[] arr, int start, List<int[]> permutations) {
		if(start >= arr.length)
			permutations.add(arr.clone());
		else {
			for(int i = start; i < arr.length; i++) {
				swap(arr, start, i);
				arrayPermutations(arr, start + 1, permutations);
				swap(arr, start, i);
			}
		}
	}

	private static void swap(int[] a, int i , int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
