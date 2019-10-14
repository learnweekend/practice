package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

     1
   / \ \
  3  2  4
 / \
5   6

Return its preorder traversal as: [5,6,3,2,4,1]. 
 * 
 */
public class NaryTreePostorder {
	
// postorder - recursion
	public static List<Integer> postorderRecursion(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		postorderRecursion(root, result);
		return result;
	}

	private static void postorderRecursion(Node root, List<Integer> result) {
		if (root == null)
			return;

		if (root.children != null) {
			for (Node node : root.children) {
				postorderRecursion(node, result);
			}
		}
		result.add(root.val);
	}
	
	// postorder - iterative
	public static List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			//result.add(curr.val);   // uncomment this for preorder
			result.add(0, curr.val);  // for postorder

			if (curr.children != null) {
				//Collections.reverse(curr.children);  // uncomment this for preorder
				for (Node node : curr.children) {
					stack.push(node);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.children = new ArrayList<Node>();
		root.children.add(new Node(3));
		root.children.add(new Node(2));
		root.children.add(new Node(4));

		root.children.get(0).children = new ArrayList<Node>();
		root.children.get(0).children.add(new Node(5));
		root.children.get(0).children.add(new Node(6));

		System.out.print(preorder(root));
		System.out.print(postorderRecursion(root));
	}

	private static class Node {
		private int val;
		private List<Node> children;

		private Node(int val) {
			this.val = val;
		}
	}
}


