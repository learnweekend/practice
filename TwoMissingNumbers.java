public class TwoMissingNumbers {
	public static void main(String args[]) {
		// int[] A = {1, 2, 3, 4, 5};
		int[] A = { 2, 3, 4, 5, 7, 8, 9 }; // 1, 6
		int[] result = findTwoMissingNumbers(A);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int[] findTwoMissingNumbers(int[] A) {
		long actualSum = 0;   // actual sum of given array
		long expectedSum = 0; // expected sum if missing two elements present.
		int N = A.length;
		int actualSize = N + 2; //2 missing elements

		for (int i = 0; i < N; i++)
			actualSum += A[i];

		expectedSum = actualSize * (actualSize + 1) / 2;  // n * (n + 1)/2

		int sumOfTwoMissingElements = (int) (expectedSum - actualSum);

		int pivot = sumOfTwoMissingElements / 2; // 3

		int actualLeftXor = 0;  // xor of left side of pivot elements
		int expectedLeftXor = 0; // expected xor
		int actualRightXor = 0;  // actual xor of right side of pivot elements
		int expectedRightXor = 0;

		//[1, 2, 3]
		for (int i = 1; i <= pivot; i++) {
			expectedLeftXor ^= i;
		}
		//[4,5,6,7,8,9]
		for (int i = pivot + 1; i <= A.length + 2; i++) {
			expectedRightXor ^= i;
		}
		// [2, 3,        4, 5, 7, 8, 9]
		for(int i = 0; i < A.length; i++) {

			if(A[i] <= pivot)
				actualLeftXor ^= A[i];
			else
				actualRightXor ^= A[i];
		}
		return new int[] { expectedLeftXor ^ actualLeftXor, expectedRightXor ^ actualRightXor };
	}
}
