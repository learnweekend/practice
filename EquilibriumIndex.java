package arrays;

/* Problem : Equilibrium Index :
Given an array A, find all equilibrium indices t where 0 ≤ t < n such that:
A[0] + A[1] + ... + A[t - 1] = A[t + 1] + A[t + 2] + ... + A[n - 1]
For example : A = [-1, 3, -4, 5, 1, -6, 2, 1]
Output      : [1 3 7]
*/
public class EquilibriumIndex {
	public static void main(String args[]) {
		// int[] a = {1, 3, 5, 4, 2, 6, 1, 0}; // [3]
		// int[] a = {0, -3, 5, -4, -2, 3, 1, 0}; // [0, 3, 7]
		int[] a = { -1, 3, -4, 5, 1, -6, 2, 1 }; // [1,3, 7]
		getEquilibriumIndexV1(a);
		getEquilibriumIndexV2(a);
	}

	/*
	 * Solution 1 : Brute-force, Loop through the array and have and calculate the left sum and rightsum
	 * at each position and compare the both sums. Runtime : O(N^2); Space : O(1);
	 */
	private static void getEquilibriumIndexV1(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		int N = arr.length;

		long leftsum = 0l;
		long rightsum = 0l;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				leftsum += arr[j];
			}
			for (int k = i + 1; k < N; k++) {
				rightsum += arr[k];
			}
			if (leftsum == rightsum)
				System.out.print(i + " ");

			leftsum = 0;
			rightsum = 0;
		}
		System.out.println();
	}

	/*
	 * Solution 2 : Loop through the array and calculate the totalsum Loop through the array and
	 * calculate the running leftsum and rightsum (totalsum - leftsum) an compare both sums Runtime :
	 * O(N); Space : O(1);
	 */
	private static void getEquilibriumIndexV2(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		long totalSum = 0l;
		// calcualte the totalsum
		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
		}
		long leftsum = 0l;
		for (int i = 0; i < arr.length; i++) {
			long rightsum = totalSum - leftsum - arr[i]; // excluding current index
			if (leftsum == rightsum)
				System.out.print(i + " ");

			leftsum += arr[i]; // update running leftsum for each iteration
		}
		System.out.println();
	}
}