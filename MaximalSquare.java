package leetcode;

/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */
public class MaximalSquare {
	
	public static int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] cache = new int[rows + 1][cols + 1];
		int maxSquare = 0;

		for (int row = 1; row <= rows; row++) {
			for (int col = 1; col <= cols; col++) {
				if (matrix[row - 1][col - 1] == '1') {
					int min = Math.min(cache[row][col - 1], cache[row - 1][col]);
					cache[row][col] = 1 + Math.min(min, cache[row - 1][col - 1]);
					maxSquare = Math.max(maxSquare, cache[row][col]);
				}
			}
		}
		return maxSquare * maxSquare;
	}

	public static void main(String[] args) {
		//char[][] matrix = { {'1'} }; // 1
		//char[][] matrix = { {} }; // 0
		
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1' ,'1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
			};
		
		System.out.println(maximalSquare(matrix));  // 4
	}
}
