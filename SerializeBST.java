package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeBST {

	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private static void serialize(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("null,");
			return;
		} else {
			sb.append(node.val + ",");
			serialize(node.left, sb);
			serialize(node.right, sb);
		}
	}

	public static TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
		return deserialize(list);
	}

	private static TreeNode deserialize(List<String> list) {
		if (list != null && list.get(0).equals("null")) {
			list.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		root.left = deserialize(list);
		root.right = deserialize(list);
		return root;
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int x) {
			this.val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(serialize(root));
		System.out.println(deserialize(serialize(root)).left.val);
	}

}
