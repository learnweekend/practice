/*
 problem : given a binary tree, find the height of the tree using recursion & iterative approach
 */
 import java.util.*;

 public class TreeHeight {
   public static void main(String[] args) {
     Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.left.left = new Node(5);
     System.out.println("Recursive Height = " + heightRecursive(root));
     System.out.println("Iterative Height = " + heightIterative(root));
   }

   /* Recursive Solution : Runtime : O(N), Space O(H) */

   private static int heightRecursive(Node node){
     if(node == null)
        return 0;
     return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
   }

   /* Iterative Solution :
      1. Do the level order traversal and increment the count for each level
      2. Use external Queue to store the elements
      Runtime : O(N), Space O(H) */

   private static int heightIterative(Node node){
     if(node == null) return 0;
     Queue<Node> queue = new LinkedList<>();
     queue.add(node);
     int height = 0;

     while(!queue.isEmpty()) {
       int size = queue.size();  // get the size of the queue at each level.
       while(size-- > 0) {  // remove elements from queue one level at a time.
         Node temp = queue.poll();
         if(temp.left != null){
           queue.add(temp.left);
         }
         if(temp.right != null){
           queue.add(temp.right);
         }
       }
        height++;  // increment the count after one level traversal is complete
     }
     return height;
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
