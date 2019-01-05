package leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 * 
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * 
 * Basically, the deletion can be divided into two stages: Search for a node to remove. If the node
 * is found, delete the node.
 * 
 * Note: Time complexity should be O(height of tree).
 */
public class DeleteBST {

	public TreeNode deleteNode(TreeNode root, int value) {
		if (root == null)
			return null;

		if (value < root.val) {
			root.left = deleteNode(root.left, value);   // check on left sub tree
		} else if (value > root.val) {
			root.right = deleteNode(root.right, value); // check on right sub tree
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.val = findMin(root.right).val; // replaced min on right child
			root.right = deleteMinimum(root.right); // delete min on right subtree
		}
		return root;
	}

	private static TreeNode findMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	private static TreeNode deleteMinimum(TreeNode root) {
		if (root.left == null)
			return root.right;

		root.left = deleteMinimum(root.left);
		return root;
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int val) {
			this.val = val;
		}
	}
}
