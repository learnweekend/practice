package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
 */
public class KthSmallestElementBST {

	public static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		pushNodeAndLeft(root, stack);

		int count = 0;
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			count++;
			if (count == k)
				return curr.val;
			if (curr.right != null) {
				pushNodeAndLeft(curr.right, stack);
			}
		}
		return -1;
	}

	public static void pushNodeAndLeft(TreeNode node, Stack<TreeNode> stack) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		private TreeNode(int value) {
			this.val = value;
		}
	}
	
	public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(1);
      root.right = new TreeNode(4);
      root.left.right = new TreeNode(2);
      
      System.out.println(kthSmallest(root, 1));
      System.out.println(kthSmallest(root, 2));
      System.out.println(kthSmallest(root, 3));
      System.out.println(kthSmallest(root, 4));
    }
}
