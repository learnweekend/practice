package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:

11000
11000
00011
00011

Given the above grid map, return 1.

Example 2:

11011
10000
00001
11011

Given the above grid map, return 3
 *
 */
public class DistinctIslands {
	
	public static int numDistinctIslands(int[][] grid) {
      Set<String> distinctIslands = new HashSet<>();
      
      if(grid == null || grid.length == 0)
      	return distinctIslands.size();
      
      int rows = grid.length;
      int cols = grid[0].length;
      
      for(int row = 0; row < rows; row++) {
      	for(int col = 0; col < cols; col++) {
      		if(grid[row][col] == 1) {
      			StringBuilder sb = new StringBuilder();
      			exploreNeighbors(grid, row, col, rows, cols, sb);
      			System.out.println(distinctIslands);
      			distinctIslands.add(sb.toString());
      		}
      	}
      }
      return distinctIslands.size();
   }
	
	private static void exploreNeighbors(int[][] grid, int row, int col, int rows, int cols, StringBuilder sb) {
		if(row < 0 || row >= rows || col < 0 || col >= cols ) {
			return;
		}
		
		if(grid[row][col] == 0) {
			return;
		}
		
		grid[row][col] = 0;  // marking the visited cell 0, 0 - so that we cannot revisit again
		
		exploreNeighbors(grid, row + 1, col, rows, cols, sb.append("b"));
		
		exploreNeighbors(grid, row - 1, col, rows, cols, sb.append("t"));
		
		exploreNeighbors(grid, row, col - 1, rows, cols, sb.append("l"));
		
		exploreNeighbors(grid, row, col + 1, rows, cols, sb.append("r"));

	}

	public static void main(String[] args) {
		int[][] grid =  { 
				{ 1,1,0,1,1 },
				{ 1,0,0,0,0 },
				{ 0,0,0,0,1 },
				{ 1,1,0,1,1 }
		 };
		
		System.out.println(numDistinctIslands(grid));
	}

}
