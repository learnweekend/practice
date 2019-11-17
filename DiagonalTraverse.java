package leetcode;

import java.util.Arrays;

/**
 	https://leetcode.com/problems/diagonal-traverse/
 	
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in
 * diagonal order as shown in the below image.
 * 
 * Example: Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
 * 
 * Output: [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalTraverse {

	/**
	 *  Note : ZIG ZAG diagonal traversal
	 */
	public static int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new int[0];

		int rows = matrix.length;
		int cols = matrix[0].length;

		int noOfdiagonals = rows + cols - 1;

		int[] result = new int[rows * cols];
		int index = 0;

		for (int diagonal = 0; diagonal < noOfdiagonals; diagonal++) {

			if (diagonal % 2 == 0) { // even traversal
				int row = diagonal < rows ? diagonal : rows - 1;
				int col = diagonal < rows ? 0 : diagonal - (rows - 1);

				while (row >= 0 && col < cols) {
					result[index++] = matrix[row--][col++];
					
				}
			} else { // odd traversal
				int row = diagonal < cols ? 0 : diagonal - (cols - 1);
				int col = diagonal < cols ? diagonal : cols - 1;

				while (row < rows && col >= 0) {
					result[index++] = matrix[row++][col--];
				}
			}
		}
		return result;
	}
	
	/**
	 *  Note : diagonal traversal
	 */
	public static int[] findDiagonalOrderBottomToTop(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new int[0];
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[] result = new int[rows * cols];
		int index = 0;
		
		for(int row = 0; row < rows; row++) { // this loop completes all diagonals = number of rows, starting from 0, 0 position
			int i = row;
			int j = 0;
			
			while(i >= 0 && j < cols) {
				result[index++] = matrix[i--][j++];
			}
		}
		
		for(int col = 1; col < cols; col++) {  // this loop completes the remaining diagonals starting from 2nd column
			int i = rows - 1;
			int j = col;
			
			while(i >= 0 && j < cols) {
				result[index++] = matrix[i--][j++];
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3}, 
								 { 4, 5, 6}, 
								 { 7, 8, 9}
								};
		int[] result = findDiagonalOrder(matrix);
		System.out.println(Arrays.toString(result));
		
		int[] diagonalTraversal = findDiagonalOrderBottomToTop(matrix);
		System.out.println(Arrays.toString(diagonalTraversal));
	}

}
