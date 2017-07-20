/*
 Problem : Given pre-order & in-order of a binary tree, construct the tree
 */
 import java.util.*;

 public class ConstructTreeFromPreAndInOrder {

   private static int treeIndex = 0;  // to track the root index in inorder traversal

   public static void main(String[] args) {
     int[] inorder = {16, 30, 40, 20, 25, 15, 10};
     int[] preorder = {20, 30, 16, 40, 15, 25, 10};
     System.out.println();
     System.out.print("Given in order  = " + Arrays.toString(inorder));
     System.out.println();
     System.out.print("Given pre order  = " + Arrays.toString(preorder));
     System.out.println();
     Node root = constructTreeFromPreAndInOrder(preorder, inorder);
     System.out.print("in order   = ");
     inOrder(root);
     System.out.println();
     System.out.print("pre order  = ");
     preOrder(root);
     System.out.println();
     System.out.print("post order = ");
     postOrder(root);
     System.out.println();
   }

   private static Node constructTreeFromPreAndInOrder(int[] preorder, int[] inorder){
     return constructTreeFromPreAndInOrder(preorder, inorder, 0, preorder.length - 1);
   }

   private static Node constructTreeFromPreAndInOrder(int[] preorder, int[] inorder, int start, int end ){

     if((start > end) || (treeIndex >= preorder.length))
        return null;

     Node root = new Node(preorder[treeIndex]);
     treeIndex++; // go to next root element

     if(start == end){
       return root;
     }

     int inOrderIndex;
     for(inOrderIndex = start; inOrderIndex <= end; inOrderIndex++){
       if(inorder[inOrderIndex] == root.data){
         break;
       }
     }
     root.left = constructTreeFromPreAndInOrder(preorder, inorder, start, inOrderIndex - 1);
     root.right = constructTreeFromPreAndInOrder(preorder, inorder, inOrderIndex + 1, end);

     return root;
   }

   private static class Node {
     private int data;
     private Node left;
     private Node right;
     private Node(int value){
       this.data = value;
     }
   }

   private static void inOrder(Node node){
     if(node == null)
          return;
     inOrder(node.left);
     System.out.print(node.data + " ");
     inOrder(node.right);
   }

   private static void preOrder(Node node){
     if(node == null)
          return;
     System.out.print(node.data + " ");
     preOrder(node.left);
     preOrder(node.right);
   }

   private static void postOrder(Node node){
     if(node == null)
          return;
     postOrder(node.left);
     postOrder(node.right);
     System.out.print(node.data + " ");
   }

 }
