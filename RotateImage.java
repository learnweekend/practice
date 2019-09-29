package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class RotateImage {

	public static void rotate(int[][] matrix) {
		Collections.reverse(Arrays.asList(matrix));
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotate(matrix);
		for (int[] arr : matrix) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
