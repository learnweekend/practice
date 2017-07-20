/*
 problem : Level Order Iterator  */

import java.util.*;

 public class LevelOrderZigZag {

   public static void main(String[] args){
     Node root = new Node(1);

     root.left = new Node(2);
     root.right = new Node(3);

     root.left.left =	 new Node(4);
     root.left.right = new Node(5);
     root.right.left = new Node(6);
     root.right.right = new Node(7);

     root.left.left.left = new Node(8);
     root.left.left.right = new Node(9);
     root.left.right.left = new Node(10);
     root.left.right.right = new Node(11);
     root.right.left.left = new Node(12);
     root.right.left.right = new Node(13);
     root.right.right.left = new Node(14);
		 root.right.right.right = new Node(15);

     /*Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     root.right.left = new Node(6);
     root.right.right = new Node(7);*/

     System.out.print("zig zag level order traversal : ");
     zigzagLevelOrder(root);
     System.out.println();
   }

   private static void zigzagLevelOrder(Node root){
     Stack<Node> evenStack = new Stack<Node>();
     Stack<Node> oddStack = new Stack<Node>();
     evenStack.push(root); // root is at level = 0, evenStack

     while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
       while(!evenStack.isEmpty()) {
         Node temp = evenStack.pop();
         System.out.print(temp.data + " ");
         if(temp.left != null){
              oddStack.push(temp.left);
          }
          if(temp.right != null){
              oddStack.push(temp.right);
          }
        }

       while(!oddStack.isEmpty()){
         Node temp = oddStack.pop();
         System.out.print(temp.data + " ");
         if(temp.right != null){
            evenStack.push(temp.right);
         }
         if(temp.left != null){
            evenStack.push(temp.left);
         }
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
