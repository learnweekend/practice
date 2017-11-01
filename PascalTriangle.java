//1
//1 1
//1 2 1
//1 3 3 1
//1 4 6 4 1
//1 5 10 10 5 1

// Problem :  Given a level, print the pascal's triangle those many rows

public class PascalTriangle {

	/**
	 * Solution 1 : Pascal Triangle Using Iterative and array based implementation
	 */
	public static int[] pascalRow(int level) {

		if(level < 0)
			throw new IllegalArgumentException("Level cannot be less than 0");

		if (level == 0) {
			return new int[] { 1 };
		}
		if (level == 1) {
			return new int[] { 1, 1 };
		}

		int[] previousRow = { 1, 1 };
		for (int row = 2; row <= level; row++) {
			int[] nextRow = new int[level + 1];
			nextRow[0] = 1;  // first and last elements are 1 always
			nextRow[row] = 1;

			for (int k = 1; k < row; k++) {  // loop throught between elements
				nextRow[k] = previousRow[k - 1] + previousRow[k];
			}
			previousRow = nextRow;
		}
		return previousRow;
	}

	/**
	 * Solution 2 : Pascal Triangle Using Recursion
	 */
	private static void pascalTraingleRecursion(int level) {

		for(int i = 0; i < level ; i++) {
			for(int k = 0; k <= i; k++) {
				System.out.print(pascalTraingleRecursion(i, k) + " ");
			}
			System.out.println();
		}
	}

	private static int pascalTraingleRecursion(int level, int nextElement) {
		if(nextElement == 0)  // first element
			return 1;
		else if(level == nextElement)  // last element
			return 1;
		else {
			return pascalTraingleRecursion(level - 1, nextElement - 1) + pascalTraingleRecursion(level - 1, nextElement);
		}
	}

	/**
	 * Solution 3 : Pascal Triangle Using Iterative - Factorial NCr formula
	 */
	private static void pascalTriangleIterative(int level) {
		for(int i = 0; i < level; i++) {
			for(int k = 0; k <= i; k++) {
				System.out.print(findNcr(i, k) + " ");
			}
			System.out.println();
		}
	}

	// Helper method to find Ncr

	private static int findNcr(int N, int R) {

		return factorial(N)/(factorial(N-R) * factorial (R));
	}

	// Helper method to calculate factorial

	private static int factorial(int number) {

		int result = 1;

		for(int i = 1; i <= number; i++) {
			result *= i;
		}
		return result;
	}

  public static void main(String[] args) {
		int level = 4;

		System.out.println("\n======= Using Array & Iterative =========\n");
		for (int i = 0; i < level; i++) {
			printArray(pascalRow(i));
		}
		System.out.println("\n======= Using Recursion =========\n");
		pascalTraingleRecursion(level);

		System.out.println("\n======= Using Factorial =========\n");
		pascalTriangleIterative(level);
	}

	private static void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");

		System.out.println();
	}

}
