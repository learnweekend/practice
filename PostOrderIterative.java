/*
 Problem : Pre order Traversal of Binary Search Tree
 */
 import java.util.*;
 public class PostOrderIterative {
   public static void main(String[] args){
     Node root = new Node(20);
     root.left = new Node(8);
     root.left.left = new Node(4);
     root.left.right = new Node(12);
     root.left.right.left = new Node(10);
     root.left.right.right = new Node(14);
     root.right = new Node(22);

     System.out.print("Post order recursion  = ");
     postOrderRecursion(root);
     System.out.println();
     System.out.print("Post order iterative  = ");
     postOrderIterative(root);
     System.out.println();
   }
   /* Solution : Using recursion (Left, Right, Root)
      Runtime  : O(N); Space O(H) - internal stack space.
    */
   private static void postOrderRecursion(Node root){
     if(root == null)
        return;
     postOrderRecursion(root.left); // print left children
     postOrderRecursion(root.right); // print right children
     System.out.print(root.data + " "); // print current node
   }
   /* Solution : Using Iterative approach, external stack
      Runtime  : O(N), Space : O(H) - max height of tree
    */
   private static void postOrderIterative(Node root){
     if(root == null)
       return;
     Stack<Node> stack = new Stack<>();

     pushNodeAndLeftNodes(root, stack); // push node and leaf nodes

     while(!stack.isEmpty()) {
       Node node = stack.pop();
       System.out.print(node.data + " ");
       if (!stack.isEmpty()) {
          Node top = stack.peek();
          if (node == top.left) {
              pushNodeAndLeftNodes(top.right, stack); //push node and leaf nodes from right sub-tree if any
           }
        }
     }
   }

   private static void pushNodeAndLeftNodes(Node node, Stack<Node> stack){
     while (node != null) {
       stack.push(node);
       if (node.left != null) {
          node = node.left;
       } else {
          node = node.right;
       }
     }
   }

   private static class Node {
     private int data;
     private Node left;
     private Node right;

     private Node(int value){
       this.data = value;
     }
   }
 }
