package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/** # 314 : https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * 
 * Given a binary tree, return the vertical order traversal of its nodes' values. 
 * (ie, from top to bottom, column by column).

	If two nodes are in the same row and column, the order should be from left to right.
 * Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:
[
  [9],
  [3,15],
  [20],
  [7]
]
 */
public class VerticalOrderBinaryTree {
	/*
	 * Solution : Define a level 0 for root and -1 for left child and +1 for right child
	 * Queue<TreeNode> queue  ---> To store the TreeNodes
		Map<TreeNode, Integer> --->  <TreeNode, Level> (level = 0 for root for leftChild = -1, rightChild = +1)
		Map<Integer, List<Integer>> ---> <level, nodes_at_that_level>
	 */
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();  // to process all nodes
		Map<TreeNode, Integer> nodeMap = new HashMap<>();  // have the mappings for node and distance
		Map<Integer, List<Integer>> levelMap = new HashMap<>(); // the mapping of level - nodes

		queue.offer(root);
		nodeMap.put(root, 0);
		List<Integer> list = new LinkedList<>();
		list.add(root.val);
		levelMap.put(0, list);
		int min = 0;  // to store the farthest distance on left side of root
		int max = 0;  // to store the farthest distance on right side of root

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int distance = nodeMap.get(node);

			if (node.left != null) {  // process left child
				queue.offer(node.left);
				int nodeDistance = distance - 1;
				min = nodeDistance < min ? nodeDistance : min; // this is for traverse later
				nodeMap.put(node.left, nodeDistance); // add the distance for this node
				if (levelMap.get(nodeDistance) == null) {
					List<Integer> valList = new ArrayList<>();
					valList.add(node.left.val);
					levelMap.put(nodeDistance, valList);
				} else {
					levelMap.get(nodeDistance).add(node.left.val); 
				}
			}

			if (node.right != null) { // process right child
				queue.offer(node.right);
				int nodeDistance = distance + 1;
				max = nodeDistance > max ? nodeDistance : max; // this is for iteration later stage
				nodeMap.put(node.right, nodeDistance);
				if (levelMap.get(nodeDistance) == null) {
					List<Integer> valList = new ArrayList<>();
					valList.add(node.right.val);
					levelMap.put(nodeDistance, valList);
				} else {
					levelMap.get(nodeDistance).add(node.right.val);
				}
			}
		}
		for (int i = min; i <= max; i++) {
			result.add(levelMap.get(i));
		}
		return result;
	}

	public static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> verticalOrder = verticalOrder(root);
		for (List<Integer> level : verticalOrder) {
			System.out.println(level);
		}
	}
}
