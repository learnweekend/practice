package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed, acyclic graph of N nodes. 
 * Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  
graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 */
public class AllPathsFromSourceToTarget {

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		return allPathsSourceTarget(graph, 0);
	}

	private static List<List<Integer>> allPathsSourceTarget(int[][] graph, int node) {

		List<List<Integer>> result = new ArrayList<>();
		int N = graph.length;

		if (node == N - 1) { // base case - if the target reached (last node reached)
			List<Integer> path = new ArrayList<>();
			path.add(node);
			result.add(path);
			return result;
		}

		int[] neighbors = graph[node];  // get the neighbors for the given node
		
		if(neighbors == null) {
			return result;
		}

		for (int neighbor : neighbors) {
			List<List<Integer>> subPaths = allPathsSourceTarget(graph, neighbor);

			for (List<Integer> path : subPaths) {
				path.add(0, node);
				result.add(path);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		System.out.println(allPathsSourceTarget(graph));
	}

}
