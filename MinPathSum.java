package tree;

/**
 *  Given a binary tree, find the minimum path sum from root to leaf node.
 *          5
           / \
          4   8
         /   / \
        11  13  4
       /  \      \
      7    2      1
 */
public class MinPathSum {

	// Runtime : O(N), Space : O(H) - due to recursive call stack
	int minSum = Integer.MAX_VALUE;

	public void minPathSum(TreeNode root, int sum) {
		if (root == null)
			return;

		sum += root.val;

		if (isLeaf(root)) {
			minSum = Math.min(minSum,  sum);
			return;
		}
		minPathSum(root.left, sum);
		minPathSum(root.right, sum);
	}

	private static boolean isLeaf(TreeNode node) {
		return (node.left == null && node.right == null);
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(2);
		
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(1);
		root.right.right.left = new TreeNode(-1);

		MinPathSum obj = new MinPathSum();
		obj.minPathSum(root, 0);
		System.out.println(obj.minSum);
	}
}
