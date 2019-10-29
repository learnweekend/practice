package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/boundary-of-binary-tree/
 * 
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from
 * root. Boundary includes left boundary, leaves, and right boundary in order without duplicate
 * nodes. (The values of the nodes may still be duplicates.)
 * 
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined
 * as the path from root to the right-most node. If the root doesn't have left subtree or right
 * subtree, then the root itself is left boundary or right boundary. Note this definition only
 * applies to the input binary tree, and not applies to any subtrees.
 * 
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to
 * the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf
 * node.
 * 
 * The right-most node is also defined by the same way with left and right exchanged.
 * 
 * Example 1
 *  Input:
		  1
		   \
		    2
		   / \
		  3   4
 * 
 * 
 * Ouput: [1, 3, 4, 2]
 * 
 * Explanation: The root doesn't have left subtree, so the root itself is left boundary. The leaves
 * are node 3 and 4. The right boundary are node 1,2,4. Note the anti-clockwise direction means you
 * should output reversed right boundary. So order them in anti-clockwise without duplicates and we
 * have [1,3,4,2].
 * 
 */
public class BoundaryBinaryTree {

	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> boundaryNodes = new ArrayList<>();
		if (root == null) {
			return boundaryNodes;
		}

		boundaryNodes.add(root.val);

		if (root.left != null) {
			addLeftBoundaryNodes(root.left, boundaryNodes);
		}

		addLeaveNodes(root, boundaryNodes);

		if (root.right != null) {
			addRightBoundaryNodes(root.right, boundaryNodes);
		}
		return boundaryNodes;
	}

	private static void addLeaveNodes(TreeNode node, List<Integer> result) {
		if (node == null)
			return;

		if (isLeaf(node)) {
			result.add(node.val);
		}
		addLeaveNodes(node.left, result);
		addLeaveNodes(node.right, result);
	}

	private static void addLeftBoundaryNodes(TreeNode node, List<Integer> result) {
		TreeNode curr = node;
		while (curr != null) {
			if (!isLeaf(curr)) {
				result.add(curr.val);
			}
			if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
	}

	private static void addRightBoundaryNodes(TreeNode node, List<Integer> result) {
		TreeNode curr = node;
		List<Integer> temp = new LinkedList<>();

		while (curr != null) {
			if (!isLeaf(curr)) {
				temp.add(0, curr.val);
			}
			if (curr.right != null) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		result.addAll(temp);
	}

	private static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
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
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		System.out.println(boundaryOfBinaryTree(root));
	}
}
