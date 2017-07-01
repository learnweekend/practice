/*
 Problem : InOrder Traversal of Binary Search Tree
 */
 import java.util.*;
 public class InOrderTraversal {
   public static void main(String[] args){
     /*Node root = new Node(5);
     root.left = new Node(3);
     root.left.left = new Node(1);
     root.right = new Node(7); */

     Node root = new Node(20);
     root.left = new Node(8);
     root.left.left = new Node(4);
     root.left.right = new Node(12);
     root.left.right.left = new Node(10);
     root.left.right.right = new Node(14);
     root.right = new Node(22);

     System.out.print("In order iterative  = ");
     inOrderIterative(root);
     System.out.println();
     System.out.print("In order recursion  = ");
     inOrderRecursion(root);
     System.out.println();
   }
   /* Solution : Using recursion
      Runtime  : O(N); Space O(N) - internal stack space.
    */
   private static void inOrderRecursion(Node root){
     if(root == null)
        return;
     inOrderRecursion(root.left); // print left children
     System.out.print(root.data + " "); // print current node
     inOrderRecursion(root.right); // print right children
   }
   /* Solution : Using Iterative using external stack
      Runtime  : O(N), Space : O(N)
    */
   private static void inOrderIterative(Node root){
     if(root == null)
       return;
     Stack<Node> stack = new Stack<>();
     addLeftChildsToStack(stack, root); // add root and all left childs to stack

     while(!stack.isEmpty()) {
        Node temp = stack.pop();
        System.out.print(temp.data + " ");
        if(temp.right != null){
          addLeftChildsToStack(stack, temp.right); // add left children of righ child
        }
      }
   }
   // Add current node and all left children to stack
   private static void addLeftChildsToStack(Stack<Node> stack, Node node){
     if(stack == null)
       return;
     while(node != null){
       stack.push(node);
       node = node.left;
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
