package leetcode;

import java.util.ArrayList;
import java.util.Collections;
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

Return its preorder traversal as: [1,3,5,6,2,4]. 
 * 
 */
public class NaryTreePreorder {
	
	// preorder - recursion
	public static List<Integer> preorderRecursion(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		preorderRecursion(root, result);
		return result;
	}

	private static void preorderRecursion(Node root, List<Integer> result) {
		if (root == null)
			return;

		result.add(root.val);

		if (root.children != null) {
			for (Node node : root.children) {
				preorderRecursion(node, result);
			}
		}
	}

	//preorder iterative
	public static List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			result.add(curr.val);

			if (curr.children != null) {
				Collections.reverse(curr.children); // Same as preorder of Binary Tree (push nodes from right to left in stack
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

		System.out.print(preorderRecursion(root));
		System.out.print(preorder(root));
	}

	private static class Node {
		private int val;
		private List<Node> children;

		private Node(int val) {
			this.val = val;
		}
	}
}

