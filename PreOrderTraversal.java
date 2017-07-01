/*
 Problem : Pre order Traversal of Binary Search Tree
 */
 import java.util.*;
 public class PreOrderTraversal {
   public static void main(String[] args){
     /*Node root = new Node(5);
     root.left = new Node(3);
     root.left.left = new Node(1);
     root.right = new Node(7);*/

     Node root = new Node(20);
     root.left = new Node(8);
     root.left.left = new Node(4);
     root.left.right = new Node(12);
     root.left.right.left = new Node(10);
     root.left.right.right = new Node(14);
     root.right = new Node(22);

     System.out.print("Pre order recursion  = ");
     preOrderRecursion(root);
     System.out.println();
     System.out.print("Pre order iterative  = ");
     preOrderIterative(root);
     System.out.println();
   }
   /* Solution : Using recursion
      Traverse : Root, Left, Right
      Runtime  : O(N); Space O(N) - internal stack space.
    */
   private static void preOrderRecursion(Node root){
     if(root == null)
        return;
     System.out.print(root.data + " "); // print current node
     preOrderRecursion(root.left); // print left children
     preOrderRecursion(root.right); // print right children
   }
   /* Solution : Using Iterative approach, external stack
      Root, Left, Right
      Steps:  1. Push ROOT to stack and print.
              2. Push RIGHT child to stack
              3. Push LEFT child to stack
      Runtime  : O(N), Space : O(N)
    */
   private static void preOrderIterative(Node root){
     if(root == null)
       return;
     Stack<Node> stack = new Stack<>();
     stack.push(root);  // 1. push the root

     while(!stack.isEmpty()) {
        Node temp = stack.pop();
        System.out.print(temp.data + " ");
        if(temp.right != null) // 2. Push Right child to stack.(Note : RIGHT)
          stack.push(temp.right);
        if(temp.left != null) {
          stack.push(temp.left); //3. Push left child to stack (Note : LEFT)
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
