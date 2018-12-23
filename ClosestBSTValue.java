/**
 *  https://leetcode.com/problems/closest-binary-search-tree-value/description/
 *  
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
Note:
    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:
Input: root = [4,2,5,1,3], target = 3.714286
    4
   / \
  2   5
 / \
1   3
Output: 4
 */
public class ClosestBSTValue {

	public static int closestValueI(TreeNode root, double target) {
		return closestValueInBSTIterative(root, Double.MAX_VALUE, target);
	}

	public static int closestValueR(TreeNode root, double target) {
		return closestValueInBSTRecursive(root, Double.MAX_VALUE, target);
	}

	// Average : O(log n) | O(log n)
	// Worst : O(N) | O(N)
	private static int closestValueInBSTRecursive(TreeNode node, double closest, double target) {
		if (Math.abs(target - closest) > Math.abs(target - node.val))
			closest = node.val;
		if (target < node.val && node.left != null) {
			return closestValueInBSTRecursive(node.left, closest, target);
		} else if (target > node.val && node.right != null) {
			return closestValueInBSTRecursive(node.right, closest, target);
		} else {
			return (int) closest;
		}
	}

	// Average : O(log n) | O(1)
	// Worst : O(N) | O(1)
	private static int closestValueInBSTIterative(TreeNode node, double closest, double target) {
		TreeNode curr = node;
		while (curr != null) {
			if (Math.abs(target - closest) > Math.abs(target - curr.val)) {
				closest = curr.val;
			}
			if (target < curr.val) {
				curr = curr.left;
			} else if (target > curr.val) {
				curr = curr.right;
			} else {
				break;
			}
		}
		return (int) closest;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(closestValueI(root, 3.71));
		System.out.println(closestValueR(root, 3.71));
		
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
