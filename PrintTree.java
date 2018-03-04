package samples.tree; 

/* Print Tree */
 import java.util.*;

public class PrintTree {
		public static void main(String[] args){
	    Node root = new Node(4);
	    root.left = new Node(5);
	    root.left.left = new Node(7);
	    root.left.right = new Node(8);
	    root.right = new Node(3);
	    root.right.left = new Node(2);
	    root.right.right = new Node(6);

	    PrintTree.print(root);
	    System.out.println();
	  }

	private static class Node {
		private int data;
		private Node left;
		private Node right;

		private Node(int value) {
			this.data = value;
		}
	}

	public static void print(Node root) {
		int maxLevel = maxLevel(root);
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}
	private static void printNodeInternal(List<Node> nodes, int level,int maxLevel) {
		if (nodes.isEmpty() || isAllElementsNull(nodes)) return;
		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
		printWhitespaces(firstSpaces);
		List<Node> newNodes = new ArrayList<Node>();
		for (Node node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			printWhitespaces(betweenSpaces);
		}
		System.out.println("");
		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}
				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					printWhitespaces(1);
				printWhitespaces(i + i - 1);
				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					printWhitespaces(1);
				printWhitespaces(endgeLines + endgeLines - i);
			}
			System.out.println("");
		}
		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}
	private static int maxLevel(Node node) {
		if (node == null) return 0;
		return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
	}
	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}
		return true;
	}
}
