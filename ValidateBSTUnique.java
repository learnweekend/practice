**
 * # 98 : https://leetcode.com/problems/validate-binary-search-tree/
 * 
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
	Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    
Example 1:
Input:
    2
   / \
  1   3
Output: true
Example 2:
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 */

public class ValidateBSTUnique {
	// Average : O(N) | O(H)
	public boolean validateBSTUnique(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode node, long min, long max) {
		if (node == null)
			return true;

		if (node.val <= min || node.val >= max) { // Note : >= to avoid duplicates
			return false;
		}
		return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
	}

	private Integer prev = null;

	// Average : O(N) | O(H)
	private boolean isValidBST(TreeNode node) {
		if (node == null)
			return true;

		if (!isValidBST(node.left))
			return false;

		if (prev != null && node.val <= prev)
			return false;

		prev = node.val;

		return isValidBST(node.right);
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ValidateBSTUnique obj = new ValidateBSTUnique();
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(3);
		System.out.println(obj.validateBSTUnique(root1)); // true
		System.out.println(obj.isValidBST(root1)); // true

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(5);
		root.right = new TreeNode(4);
		System.out.println(obj.validateBSTUnique(root)); // false
		System.out.println(obj.isValidBST(root)); // false

		TreeNode root2 = new TreeNode(1);
		root2.right = new TreeNode(1);
		System.out.println(obj.validateBSTUnique(root2)); // false
		System.out.println(obj.isValidBST(root2)); // false
	}
}
