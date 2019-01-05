package leetcode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 * 
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2

 */
public class SearchBST {

	//Recursive solution: Time O(H) | Space : O(H)
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;
		
		if (root.val == val)
			return root;
		
		else if (val < root.val)
			return searchBST(root.left, val);
		else
			return searchBST(root.right, val);
	}

	//Recursive solution; Time : O(H) | Space : O(1)
	public TreeNode searchBSTIterative(TreeNode root, int val) {
		if (root == null)
			return null;
		
		if (root.val == val)
			return root;
		
		TreeNode current = root;
		
		while (current != null) {
			if (current.val == val)
				return current;
			else
				current = (val < current.val) ? current.left : current.right;
		}
		return null;
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
