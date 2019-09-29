package leetcode;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's 
 * (representing land) connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.

	Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */
public class MaxAreaOfIsland {
	
	public static int maxAreaOfIsland(int[][] grid) {
		if (grid == null)
			return 0;

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int maxArea = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				maxArea = Math.max(maxArea, area(grid, i, j, visited));
			}
		}
		return maxArea;
	}
	
	private static int area(int[][] grid, int row, int col, boolean[][] visited) {
		
		if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || visited[row][col] || grid[row][col] == 0)
			return 0;
		
		visited[row][col] = true;
		
		return (1 + area(grid, row + 1, col, visited)
					 + area(grid, row - 1, col, visited)
					 + area(grid, row, col + 1, visited)
					 + area(grid, row, col - 1, visited));
	}
	
	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                {0,1,1,0,1,0,0,0,0,0,0,0,0},
		                {0,1,0,0,1,1,0,0,1,0,1,0,0},
		                {0,1,0,0,1,1,0,0,1,1,1,0,0},
		                {0,0,0,0,0,0,0,0,0,0,1,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                {0,0,0,0,0,0,0,1,1,0,0,0,0}
		               };
		
		System.out.println(maxAreaOfIsland(grid));
	}
}
