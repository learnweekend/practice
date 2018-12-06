import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/spiral-matrix/description/
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * Example 1:
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return result;

		int rows = matrix.length;
		int cols = matrix[0].length;

		int top = 0;
		int bottom = rows - 1;

		int left = 0;
		int right = cols - 1;

		while (result.size() < rows * cols) {

			for (int i = left; i <= right; i++) {  // print top row
				result.add(matrix[top][i]);
			}

			top++;
			for (int i = top; i <= bottom; i++) {  // print right col
				result.add(matrix[i][right]);
			}
			
			if (bottom < top)   // avoid duplicate rows
				break;

			right--;
			for (int i = right; i >= left; i--) {  // print bottom row
				result.add(matrix[bottom][i]);
			}

			if (right < left)  // avoid duplicate clumn
				break;

			bottom--;
			for (int i = bottom; i >= top; i--) {  // print left col
				result.add(matrix[i][left]);
			}
			left++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		SpiralMatrix obj = new SpiralMatrix();
		List<Integer> result = obj.spiralOrder(matrix);
		System.out.println(result);
	}
}
