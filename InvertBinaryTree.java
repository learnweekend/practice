import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/
public class InvertBinaryTree {
	//Average : O(N) | O(d)
	public TreeNode invertTreeDFS(TreeNode root) {
		if (root == null)
			return null;
		swapLeftAndRightChildren(root);
		invertTreeDFS(root.left);
		invertTreeDFS(root.right);
		return root;
	}
	
	//Average : O(N) | O(N)
	public TreeNode invertTreeBFS(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr == null)
				continue;
			swapLeftAndRightChildren(curr);
			if (curr.left != null) {
				queue.offer(curr.left);
			}
			if (curr.right != null) {
				queue.offer(curr.right);
			}
		}
		return root;
	}

	private void swapLeftAndRightChildren(TreeNode node) {
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		inorder(root);
		System.out.println();
		InvertBinaryTree obj = new InvertBinaryTree();
		TreeNode node = obj.invertTreeDFS(root);
		inorder(node);
		System.out.println();
		
		obj.invertTreeBFS(root);
		inorder(node);
		System.out.println();
	}
	
	private static void inorder(TreeNode node) {
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
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
