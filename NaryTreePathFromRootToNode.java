package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an N-ary tree and a given node find the path from root to given node
 */
public class NaryTreePathFromRootToNode {

	public static List<Node> pathToNode(Node root, Node node) {
		if (root == null || node == null) {
			return null;
		}
		if (root == node) {
			List<Node> path = new ArrayList<>();
			path.add(root);
			return path;
		}

		if (root.children != null) {
			for (Node curr : root.children) {
				List<Node> currPath = pathToNode(curr, node);
				if (currPath != null) {
					currPath.add(0,root);
					return currPath;
				}
			}
		}
		return null;
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

		List<Node> path = pathToNode(root, root.children.get(2).children.get(0).children.get(1).children.get(0));
		for (Node node : path) {
			System.out.print(node.val + " ");
		}
	}

	private static class Node {
		private int val;
		private List<Node> children;

		private Node(int val) {
			this.val = val;
		}
	}
}
