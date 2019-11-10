package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
 * find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

 */
public class KthSmallestSortedMatrix {
	
	public static int kthSmallest(int[][] matrix, int k) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				pq.add(matrix[i][j]);
				if(pq.size() > k)
					pq.poll();
			}
		}
		return pq.poll();
   }

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest(matrix, 8));
	}
}
