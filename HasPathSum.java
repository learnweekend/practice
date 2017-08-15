/*
 problem : Has Pathsum in Binary tree (https://leetcode.com/problems/path-sum/description/)
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 all the values along the path equals the given sum.
 For example: Given the below binary tree and sum = 22
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 */
 public class HasPathSum {
   public static void main(String[] args) {
     Node root = new Node(5);
     root.left = new Node(4);
     root.right = new Node(8);
     root.left.left = new Node(11);
     root.left.left.left = new Node(7);
     root.left.left.right = new Node(2);

     root.right.left = new Node(13);
     root.right.right = new Node(4);
     root.right.right.right = new Node(1);

     int sum = 22;
     boolean hasPathSum = checkPathSum(root, sum);
     System.out.println(hasPathSum);
   }

   /*public static boolean hasPathSum(Node root, int sum){
     if(root == null) return sum == 0; // to check base case if root is null and sum is 0
     return checkPathSum(root, sum);
   }*/
   // Runtme : O(N), Space : O(N) - due to recursive call stack
   private static boolean checkPathSum(Node root, int sum){
     if(root == null) return false;
     if(isLeaf(root) && root.data == sum) return true;
     return checkPathSum(root.left, sum - root.data) || checkPathSum(root.right, sum - root.data);
   }

   private static boolean isLeaf(Node node){
     return (node.left == null && node.right == null);
   }

   private static class Node{
     private int data;
     private Node left;
     private Node right;
     private Node(int val){
       this.data = val;
     }
   }
 }
