package leetcode;

/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 * 
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right
 * pointers as synonymous to the previous and next pointers in a doubly-linked list.
 * 
 */
public class ConvertBSTToDoublyLinkedList {

	private Node prev = null;

	public Node treeToDoublyList(Node root) {
		if (root == null)
			return null;

		Node dummy = new Node();
		prev = dummy;
		inorder(root);
		prev.right = dummy.right;
		dummy.right.left = prev;
		return prev.right;
	}

	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);

		prev.right = root;
		root.left = prev;
		prev = prev.right;

		inorder(root.right);
	}

	public static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}
}
