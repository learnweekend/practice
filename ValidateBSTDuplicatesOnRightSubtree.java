/**
 * Binary Search Tree - Allowed duplicates on Right subtree.
 * 
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
	Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than to the node's key.
    The right subtree of a node contains only nodes with keys greater than  or EQUAL to the node's key.
    Both the left and right subtrees must also be binary search trees. 
Example 1:
Input:
    2
   / \
  1   3
Output: true

Example 2:
    10
      \
 		10   
   output : true
 *
 */
public class ValidateBSTDuplicatesOnRightSubtree {

	public static boolean isValidBSTDuplicatesOnRightSubTree(TreeNode node) {
		return isValidBSTHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValidBSTHelper(TreeNode node, int min, int max) {
		if(node == null)
			return true;
		
		if(node.val < min || node.val > max) {  // check the node value within min and max range
			return false;	
		}
		return isValidBSTHelper(node.left, min, node.val - 1) &&   // Note:  max = node.val - 1
				isValidBSTHelper(node.right, node.val, max);   
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(10);
		System.out.println(isValidBSTDuplicatesOnRightSubTree(root)); // true
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(3);
		System.out.println(isValidBSTDuplicatesOnRightSubTree(root1)); // true
		
		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(10);
		root2.left.right = new TreeNode(10);
		System.out.println(isValidBSTDuplicatesOnRightSubTree(root2)); // false
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

