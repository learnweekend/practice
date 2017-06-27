/*
In a Binary Search Tree (BST), an Inorder Successor of a node is defined as the node with the smallest
key greater than the key of the input node (see examples below). Given a node inputNode in a BST,
you’re asked to write a function findInOrderSuccessor that returns the Inorder Successor of inputNode.
If inputNode has no Inorder Successor, return null
*/
public class InOrderSuccessorInBST {
  public static void main(String[] args){
  /*  Node tree = new Node(20);
    tree.left = new Node(9); tree.left.parent = tree;
    tree.left.left = new Node(5); tree.left.left.parent = tree.left;
    tree.left.right = new Node(12); tree.left.right.parent = tree.left;
    tree.left.right.left = new Node(11); tree.left.right.left.parent = tree.left.right;
    tree.left.right.right = new Node(14); tree.left.right.right.parent = tree.left.right;
    tree.right = new Node(25); tree.right.parent = tree;

    Node result = findInOrderSuccessor(tree.left.right.left); // 12
    System.out.println(result == null ? "Not found" :  "In order successor = " + result.data); */

    /*Node root = new Node(15);
		root.left = new Node(6);  root.left.parent = root;
		root.left.left = new Node(3); root.left.left.parent = root.left;
		root.left.right = new Node(7); root.left.right.parent = root.left;
		root.left.right.right = new Node(13); root.left.right.right.parent = root.left.right;
		root.left.right.right.left = new Node(9); root.left.right.right.left.parent = root.left.right.right;

		root.right = new Node(18); root.right.parent = root;
		root.right.left = new Node(17);  root.right.left.parent = root.right;
		root.right.right = new Node(20); root.right.right.parent = root.right;
		//3, 6, 7, 9, 13, 15, 17, 18, 20 null*/

    Node root = new Node(5);
    root.left = new Node(3); root.left.parent = root;
    root.left.left = new Node(1); root.left.left.parent = root.left;
    root.right = new Node(7); root.right.parent = root;

		Node result = findInOrderSuccessor(root.left);
		System.out.println(result == null ? "Not found" :  "In order successor = " + result.data);
  }
  /* Solution : This is Iterative Solution
    0. check of node is null, then return null.
    1. Check for right child, if found return the minimum node of right subtree.
    2. If right child is null, return the parent whos value is greater than given node.
    Runtime : O(H), Space : O(1)
    */
  private static Node findInOrderSuccessor(Node node) {
    if(node == null)
      return null;

    if(node.right != null) { // get the minimum on right subtree
      return findMinimum(node.right);
    } else {
      return findParent(node); // find parent whos value is greater than given node
    }
  }

  // Find the parent whos value is greater than the given node.
  private static Node findParent(Node node){
    Node temp = node;
    while(temp.parent != null) {
      temp = temp.parent;
      if(temp.data > node.data)
        return temp;
    }
    return null;
  }

  // Find minimum value node (left most) of a given node.
  private static Node findMinimum(Node node){
    Node temp = node;
    while(temp.left != null) {
      temp = temp.left;
    }
    return temp;
  }

  private static class Node {
    private int data;
    private Node left;
    private Node right;
    private Node parent;

    private Node(int val){
      this.data = val;
    }
  }

}
