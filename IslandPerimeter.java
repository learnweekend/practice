package leetcode;

/**
 * https://leetcode.com/problems/island-perimeter/
 * 
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
 *
 */

public class IslandPerimeter {

	public static int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int perimeter = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == 1) {
					int up = row - 1 < 0 ? 0 : grid[row - 1][col];
					int down = row + 1 >= grid.length ? 0 : grid[row + 1][col];
					int left = col - 1 < 0 ? 0 : grid[row][col - 1];
					int right = col + 1 >= grid[row].length ? 0 : grid[row][col + 1];
					
					perimeter = perimeter + (4 - up - down - left - right); // each square has four sides, deduct the sides if present on up, down, left and right
				}
			}
		}
		return perimeter;
	}

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},
		                {1,1,1,0},
		                {0,1,0,0},
		                {1,1,0,0}};
		
		System.out.println(islandPerimeter(grid));
	}
}
