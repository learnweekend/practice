package leetcode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 * 
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, 
 * insert the value into the BST. Return the root node of the BST after the insertion. 
 * It is guaranteed that the new value does not exist in the original BST.

	Note that there may exist multiple valid ways for the insertion, 
	as long as the tree remains a BST after insertion. You can return any of them.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
 *
 */
public class InsertBST {
	
	//Recursive solution, Runtime : O(H) | space : O(H)
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		} else if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		} else {
			root.val = val;
		}
		return root;
	}
	
	//Iterative solution, Runtime : O(H) | space : O(1)
	public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);

		TreeNode curr = root;
		while (true) {
			if (val < curr.val) {
				if (curr.left != null)
					curr = curr.left;
				else {
					curr.left = new TreeNode(val);
					break;
				}
			} else {
				if (curr.right != null) {
					curr = curr.right;
				} else {
					curr.right = new TreeNode(val);
					break;
				}
			}
		}
		return root;
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
