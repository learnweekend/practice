package leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid.
	The robot can only move either down or right at any point in time. 
	The robot is trying to reach the bottom-right corner of the grid.
	How many possible unique paths are there?

 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {

	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		System.out.println(uniquePaths(m,n, 1, 1));  // (1, 1) start position
		System.out.println(uniquePathsDP(m,n));
	}
	
	/**
	 * Solution : Recursion
	   1. start position (left most corner) is (1,1) , finish position is (m, n)
    	2. base case : when path reaches position m or n it counts 1 path
    	3. recursively move down (x + 1) and right  (y + 1) and sum both the paths.
    
	 * Runtime : The time complexity of above recursive solution is exponential. 
	 * There are many overlapping subproblems
	 */
	public static int uniquePaths(int rows, int cols, int x, int y) {
		if(x == rows || y == cols )  // when x or y position reaches destination, path count 1
			return 1;
		return uniquePaths(rows,cols, x + 1, y) + uniquePaths(rows, cols, x, y + 1); // + uniquePaths(x + 1, y + 1);
	}
	
	/**
	 *  Solution : Use cache to store intermediate results
	 *  1. Path to any cell in the first column is 1
	 *  2. path to any cell in the first row is 1
	 *  3. recursively update the paths - sum of previous paths from row and column
	 *  return the last cell value
	 *  Runtime : O(m * n)
	 *  space : O(m * n)
	 */
	public static int uniquePathsDP(int rows, int cols) {
		
		int[][] cache = new int[rows][cols];
		// Count of paths to reach any cell in first column is 1
		for(int i = 0; i < rows; i++) {
			cache[i][0] = 1;
		}
		// Count of paths to reach any cell in first row is 1
		for(int i = 0; i < cols; i++) {
			cache[0][i] = 1;
		}
		// Calculate count of paths for other 
      // cells in bottom-up manner using
      // the recursive solution
		for(int row = 1; row < rows; row++) {
			for(int col = 1; col < cols; col++) {
				cache[row][col] = cache[row - 1][col] + cache[row][col - 1];  //+ cache[row - 1][col - 1];
			}
		}
		return cache[rows - 1][cols - 1];
	}
	
}
