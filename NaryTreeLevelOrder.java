package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * 
 * Given an n-ary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * 
For example, given a 3-ary tree:
     1
   / \ \
  3  2  4
 / \
5   6

We should return its level order traversal:
[
     [1],
     [3,2,4],
     [5,6]
]
 */
public class NaryTreeLevelOrder {

	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null)
			return result;

		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<Integer>();
			while (size-- > 0) {
				Node curr = queue.poll();
				level.add(curr.val);

				if (curr != null && curr.children != null) {
					for (Node child : curr.children) {
						queue.offer(child);
					}
				}
			}
			result.add(level);
		}
		return result;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.children = new ArrayList<Node>();
		root.children.add(new Node(2));
		root.children.add(new Node(3));
		root.children.add(new Node(4));

		root.children.get(0).children = new ArrayList<Node>();
		root.children.get(0).children.add(new Node(5));
		root.children.get(0).children.add(new Node(6));
		root.children.get(0).children.add(new Node(7));

		root.children.get(1).children = new ArrayList<Node>();
		root.children.get(1).children.add(new Node(8));
		root.children.get(1).children.add(new Node(9));
		Node dest = new Node(10);
		root.children.get(1).children.add(dest);

		root.children.get(2).children = new ArrayList<Node>();
		root.children.get(2).children.add(new Node(11));
		root.children.get(2).children.add(new Node(12));
		root.children.get(2).children.add(new Node(13));

		root.children.get(0).children.get(1).children = Arrays.asList(new Node(14), new Node(15), new Node(16));
		root.children.get(2).children.get(0).children = Arrays.asList(new Node(17), new Node(18), new Node(19));

		root.children.get(2).children.get(0).children.get(1).children = Arrays.asList(new Node(20));

		System.out.println(levelOrder(root));
	}

	private static class Node {
		private int val;
		private List<Node> children;

		private Node(int val) {
			this.val = val;
		}
	}
}
