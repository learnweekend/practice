
public class LCA {

	/**
	 * 1. Check the root element, if it matches with any of the nodes then root is the LCA
	 * 2. Recursively move towards left and right.
	 * 3. if both left and right are present then root is the LCA
	 * 4. if left == null then return right
	 * 5. right == null then return left
	 */
	
	public static Node lca(Node root, Node node1, Node node2) {
		
		if(root == null) 
			return null;
		
		//1.  check if any of the nodes are equal to "root"
		if(root.data == node1.data || root.data == node2.data) {
			return root;
		}
		
		Node left = lca(root.left, node1, node2); // check on left
		Node right = lca(root.right, node1, node2); // check on right
		
		//3.  if both are present, then root is the LCA
		if(left != null && right != null) 
			return root;
		
		if(left == null)
			return right; 
		
		return left;
	}
	
	private static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(6);
		root.right = new Node(8);
		root.left.left = new Node(2);
		root.left.right = new Node(11);
		root.left.right.left = new Node(9);
		root.left.right.right = new Node(5);
		root.right.right = new Node(13);
		root.right.right.left = new Node(7);
		
		System.out.println(lca(root, root.left.left, root.left.right.right).data);
		
	}

}
