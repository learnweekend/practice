package com.all;

import java.util.Arrays;

public class PascalTriangleV2 {
	
	private static void pascalTriangle(int level){
		for(int row = 0; row <= level; row++){
			int c = 1;
			for(int i = 1; i <= row; i++){
				System.out.print(" " + c);
				c = c * (row - i)/i;
			}
			System.out.println();
		}
	}
	
	private static int[] pascalRow(int level){
		if(level == 0) return new int[] {1};
		int[] previousRow = new int[] {1, 1};
		if(level == 1) return previousRow;
		
		for(int row = 2; row <= level; row++){
			int[] nextRow = new int[row + 1];
			nextRow[0] = 1;
			nextRow[row] = 1;
			
			for(int k = 1; k < row; k++){
				nextRow[k] = previousRow[k - 1] + previousRow[k];
			}
			previousRow = nextRow;
		}
		return previousRow;
	}

	public static void main(String[] args) {
		int rows = 5;
		for(int row = 0; row < rows; row++){
			System.out.println(Arrays.toString(pascalRow(row)));
		}
		System.out.println("==============Version 2 ================");
		pascalTriangle(rows);
	}
}
