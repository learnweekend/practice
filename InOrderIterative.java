/*
 problem :
    1. Iterative in-order traversal of binary(search) tree.
    2. Reverse Iterative in-order traversal of binary(search) tree.
 */
 import java.util.*;

 public class InOrderIterative{
   public static void main(String[] args) {
     Node root = new Node(20);
     root.left = new Node(15);
     root.right = new Node(30);
     root.left.left = new Node(10);
     root.left.right = new Node(16);
     root.right.left = new Node(25);
     root.right.right = new Node(35);

     System.out.print("inorder recursion : ");
     inOrderRecursion(root);
     System.out.println();

     System.out.print("inorder iterative : ");
     inOrderIterative(root);
     System.out.println();

     System.out.print("reverse inorder   : ");
     reverseInOrderIterative(root);
     System.out.println();
   }

   /* Solution : Using recursion (Left, Root, Right)
      Runtime  : O(N); Space O(H) - internal stack space.
    */
   private static void inOrderRecursion(Node root){
     if(root == null)
        return;
     inOrderRecursion(root.left); // print left children
     System.out.print(root.data + " "); // print current node
     inOrderRecursion(root.right); // print right children
   }

   /*
     Solution 1: InOrder Iterative Approach, Runtime : O(N), space : O(H), H = max height of tree
    */
   private static void inOrderIterative(Node node){
     if(node == null)
        return;
     Stack<Node> stack = new Stack<>();
     pushNodeAndLeftChildren(node, stack); // push root and all left parent nodes to stack
     while(!stack.isEmpty()){
       node = stack.pop();
       System.out.print(node.data + " ");
       if(node.right != null){ //push right node(if exists) and all left parent nodes to stack
         node = node.right;
         pushNodeAndLeftChildren(node, stack);
       }
     }
   }
   private static void pushNodeAndLeftChildren(Node node, Stack<Node> stack){
     while(node != null){
       stack.push(node);
       node = node.left;
     }
   }

   /*
     Solution 2: Reverse InOrder Iterative Approach, Runtime : O(N), space : O(H), H = max height of tree
    */
   private static void reverseInOrderIterative(Node node){
     if(node == null)
        return;
     Stack<Node> stack = new Stack<>();
     pushNodeAndRightChildren(node, stack); // push root and all right parent nodes to stack
     while(!stack.isEmpty()){
       node = stack.pop();
       System.out.print(node.data + " ");
       if(node.left != null){ //push left node(if exists) and all right parent nodes to stack
         node = node.left;
         pushNodeAndRightChildren(node, stack);
       }
     }
   }
   private static void pushNodeAndRightChildren(Node node, Stack<Node> stack){
     while(node != null){
       stack.push(node);
       node = node.right;
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
