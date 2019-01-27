package leetcode;

import java.util.Stack;

/**
 *     9
	   / \	
	  3   20
	      / \
	    15  27
	     \
	     18  
 *
 */
public class KthLargestNodeBST {

	public static int kthLargest(TreeNode root, int k) {
		int[] count = { 0 };
		return kthLargest(root, k, count).val;
	}
	/** Recursive solution
	 * Use reverse inorder to get Kth largest element 
	 * Use inorder - to get kth smallest element
	 */
	private static TreeNode kthLargest(TreeNode node, int k, int[] counter) {
		if (node == null)
			return null;

		TreeNode result = kthLargest(node.right, k, counter); // use node.left for kth smallest element

		if (result == null) {
			counter[0] = counter[0] + 1;
			if (counter[0] == k) {
				result = node;
			}
		}
		if (result == null) {
			result = kthLargest(node.left, k, counter); // use node.right for kth smallest element
		}
		return result;
	}
	
	public static int kthLargestBSTIterative(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		pushNodes(root, stack);

		int counter = 0;
		int kthLargest = 0;

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			counter++;
			if (counter == k) {
				kthLargest = node.val;
				return kthLargest;
			}
			if (node.left != null) {
				pushNodes(node.left, stack);
			}
		}
		return kthLargest;
	}
	
	private static void pushNodes(TreeNode node, Stack<TreeNode> stack) {
		while(node != null) {
			stack.push(node);
			node = node.right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.right = new TreeNode(18);
		root.right.right = new TreeNode(27);
		
		System.out.println(kthLargest(root, 2)); // 20
		System.out.println(kthLargestBSTIterative(root, 2)); // 20
		System.out.println(kthLargestBSTIterative(root, 1)); // 27
		System.out.println(kthLargestBSTIterative(root, 3)); // 18
		System.out.println(kthLargestBSTIterative(root, 4)); // 15
		System.out.println(kthLargestBSTIterative(root, 5)); // 9
		System.out.println(kthLargestBSTIterative(root, 6)); // 3 
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.val = data;
		}
	}
}
