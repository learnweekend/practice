import java.util.Arrays;

public class SearchTwoDMatrix {
	
	//Runtime : O(N + M) | space : O(1)
	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		int rowIndex = 0;
		int colIndex = matrix[0].length - 1;

		while (rowIndex >= 0 && rowIndex < matrix.length && colIndex >= 0 && colIndex < matrix[0].length) {
			int value = matrix[rowIndex][colIndex];
			if (target == value) {
				return new int[] { rowIndex, colIndex };
			} else if (target < value) {
				colIndex--;
			} else {
				rowIndex++;
			}
		}
		return new int[] { -1, -1 };
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,   4,  7, 12, 15, 1000 },
				{2,   5, 19, 31, 32, 1001 },
				{3,   8, 24, 33, 35, 1002 },
				{40, 41, 42, 44, 45, 1003 },
				{99,100,103, 106,128,1004 },
		};
		System.out.println(Arrays.toString(searchInSortedMatrix(matrix, 44)));
	}
}
