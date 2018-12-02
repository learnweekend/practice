/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along 
the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

 */
public class MaxPathSumBinaryTree {

	private int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		getMaxPathSum(root);
		return maxSum;
	}

	private int getMaxPathSum(TreeNode root) {
		if (root == null)
			return 0;

		int leftMax = getMaxPathSum(root.left);
		int rightMax = getMaxPathSum(root.right);

		int maxWithCurrNode = Math.max(root.val, Math.max(root.val + leftMax, root.val + rightMax));
		maxSum = Math.max(maxSum, Math.max(maxWithCurrNode, root.val + leftMax + rightMax));

		return maxWithCurrNode;
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.val = data;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		MaxPathSumBinaryTree obj = new MaxPathSumBinaryTree();
		System.out.println("Maxsum = " + obj.maxPathSum(root));

		TreeNode node = new TreeNode(-10);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);

		System.out.println("Maxsum = " + obj.maxPathSum(node));
	}
}
