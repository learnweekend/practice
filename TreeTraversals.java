package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *  3 
 * / \ 
 *9  20 
 *   / \ 
 *  15  7
 */

public class TreeTraversals {

	// preorder recursion
	public static List<Integer> preorderR(TreeNode root, ArrayList<Integer> order) {
		if (root == null)
			return null;

		order.add(root.val);
		preorderR(root.left, order);
		preorderR(root.right, order);
		return order;
	}

	// preorder iterative
	public static List<Integer> preorderI(TreeNode root) {
		List<Integer> order = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			order.add(temp.val);
			
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
		return order;
	}

	//inorder recursion
	public static List<Integer> inorderR(TreeNode root, ArrayList<Integer> order) {
		if (root == null)
			return null;

		inorderR(root.left, order);
		order.add(root.val);
		inorderR(root.right, order);
		return order;
	}

	// inorder iterative
	public static List<Integer> inorderI(TreeNode root) {
		List<Integer> order = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode curr = root;
		while(curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			order.add(temp.val);
			
			if(temp.right != null) {
				curr = temp.right;
				while(curr != null) {
					stack.push(curr);
					curr = curr.left;
				}
			}
		}
		return order;
	}
	
	//postorder recursive
	public static List<Integer> postorderR(TreeNode root, ArrayList<Integer> order) {
		if (root == null)
			return null;

		postorderR(root.left, order);
		postorderR(root.right, order);
		order.add(root.val);
		return order;
	}

	//postorder iterative
	public static List<Integer> postorderI(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		
		pushNodeAndLeftNodes(root, stack); // push node and LEAF nodes

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (!stack.isEmpty()) {
				TreeNode top = stack.peek();
				if (node == top.left) {
					pushNodeAndLeftNodes(top.right, stack); // push node and leaf nodes from right sub-tree if any
				}
			}
		}
		return result;
	}

	private static void pushNodeAndLeftNodes(TreeNode node, Stack<TreeNode> stack) {
		while (node != null) {
			stack.push(node);
			if (node.left != null) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
	}
	
	// level order
	public static List<List<Integer>> levelorder(TreeNode root) {
		List<List<Integer>> levelorder = new LinkedList<>();

		if (root == null)
			return levelorder;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>(size);

			while (size-- > 0) {
				TreeNode curr = queue.poll();
				level.add(curr.val);

				if (curr.left != null)
					queue.add(curr.left);

				if (curr.right != null)
					queue.offer(curr.right);
			}
			levelorder.add(level);
		}
		return levelorder;
	}

	private static class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(preorderR(root, new ArrayList<Integer>()));
		System.out.println(preorderI(root));
		
		System.out.println();
		
		System.out.println(inorderR(root, new ArrayList<Integer>()));
		System.out.println(inorderI(root));
		
		System.out.println();
		
		System.out.println(postorderR(root, new ArrayList<Integer>()));
		System.out.println(postorderI(root));
	}
}