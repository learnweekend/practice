/*
Problem :
  1. Given a string, print all permutations of the given string.
  2. Given an integer array, print all permutation arrays
 */
import java.util.*;

public class Permutations {
	public static void main(String[] args) {
		// Case 1 : String permutations
		String str = "abc";
		List<String> permutations = stringPermutations(str);
		System.out.println("permutaions of a string " + str.length()
				+ " = " + permutations.size());
		for (String s : permutations) {
			System.out.println(s);
		}
		// Case 2 : Array Permutations
		int[] arr = { 1, 2, 3 };
		List<int[]> arrayPermutations = arrayPermutations(arr);
		System.out.println("permutaions of an array " + arr.length + " = " + permutations.size());
		for (int[] a : arrayPermutations) {
			System.out.println(Arrays.toString(a));
		}
		// Case 3 : char Array Permutations
		System.out.println("permutaions of an array - random order ");
		arrayPermutationsV2(arr);

		char[] charArr = {'a', 'b', 'c'};
		System.out.println("permutaions of a char array (convert to string)") ;
		stringPermutationsV3(charArr);
	}

	private static void stringPermutationsV3(char[] charArr) {
		stringPermutationsV3("", new String(charArr));
	}

	private static void stringPermutationsV3(String prefix, String suffix) {
		if (suffix.length() == 0)
			System.out.println(Arrays.toString(prefix.toCharArray()));
		else {
			for (int i = 0; i < suffix.length(); i++) {
				stringPermutationsV3(prefix + suffix.charAt(i),
						            suffix.substring(0, i) + suffix.substring(i + 1));
			}
		}
	}

	/*
	 * Solution 1 : string permutations, Runtime : O(N!), Space : O(1)
	 */
	private static List<String> stringPermutations(String str) {
		if (str == null || str.length() == 0)
			throw new IllegalArgumentException();
		List<String> permutations = new ArrayList<String>();
		stringPermutations("", str, permutations);
		return permutations;
	}

	private static void stringPermutations(String prefix, String suffix,
			List<String> permutations) {
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
	/* Solution 2: integer/char array permutations, Runtime : O(N!), Space : O(1)  */
		private static List<int[]> arrayPermutations(int[] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException();
		List<int[]> permutations = new ArrayList<int[]>();
		arrayPermutations(arr, 0, permutations);
		return permutations;
	}

	private static void arrayPermutations(int[] arr, int start,
			List<int[]> permutations) {
		if (start >= arr.length)
			permutations.add(arr.clone());
		else {
			for (int i = start; i < arr.length; i++) {
				swap(arr, start, i);
				arrayPermutations(arr, start + 1, permutations);
				swap(arr, start, i);
			}
		}
	}
	/* Solution 3: integer/char array permutations, Runtime : O(N!), Space :
	 * O(1) Note : The resulted array elements are in random order
	 */
	private static void arrayPermutationsV2(int[] arr) {
		arrayPermutationsV2(arr, arr.length);
	}

	private static void arrayPermutationsV2(int[] arr, int n) {
		if (n == 1) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(arr, i, n - 1);
			arrayPermutationsV2(arr, n - 1);
			swap(arr, i, n - 1);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
