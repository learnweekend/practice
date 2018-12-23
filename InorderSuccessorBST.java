/**
 * https://leetcode.com/problems/inorder-successor-in-bst/description/
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Example 1:

Input: root = [2,1,3], p = 1

  2
 / \
1   3

Output: 2
 */
public class InorderSuccessorBST {
	/*
	 *  Solution :  Iterative solution
	 *  1. base case : if the root is null, return null
	 *  2. if right child is present - get the minimum on right sub tree.
	 *  3. else get the successor(next greater element) - traversing towards root.
	 *  Runtime : O(H), space O(1)
	 */
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
		if (node == null)
			return null;

		if (node.right != null)
			return getMinimum(node.right);

		return getSuccessor(root, node);
	}

	private static TreeNode getMinimum(TreeNode node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	private static TreeNode getSuccessor(TreeNode root, TreeNode node) {
		TreeNode successor = null;
		while (root != null) {
			if (root.val > node.val) {
				successor = root;
				root = root.left;
			} else if (root.val < node.val) {
				root = root.right;
			} else {
				break;
			}
		}
		return successor;
	}
	
	public static TreeNode inorderSuccessorParent(TreeNode root, TreeNode node) {
		if (node == null)
			return null;
		if (node.right != null) // case 1 when right != null, get the minimum on right subtree
			return getMinimum(node.right);

		return findParent(node);  // get parent who's value is just greater than node.val
	}

	private static TreeNode findParent(TreeNode node) {
		TreeNode temp = node;
		while (temp.parent != null) {
			temp = temp.parent;
			if (temp.val > node.val)
				return temp;
		}
		return null;
	}
	
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		private TreeNode parent;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.left.parent = root;
		
		root.right = new TreeNode(13);
		root.right.parent = root;
		
		root.left.left = new TreeNode(4);
		root.left.left.parent = root.left;
		
		root.left.right = new TreeNode(7);
		root.left.right.parent = root.left;
		
		root.left.left.left = new TreeNode(5);
		root.left.left.left.parent = root.left.left;
		
		System.out.println(inorderSuccessor(root, root.left.left.left).val);
		System.out.println(inorderSuccessorParent(root, root.left.left.left).val);
	}

}
