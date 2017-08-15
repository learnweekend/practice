/*
 problem : Left view/right  of binary tree
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 For example:
 Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4]
     1
    / \
  2     2
 / \   / \
3   4 4   3

https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
 import java.util.*;

 public class LeftView {

   /* recursive solution : level order traversal, first element in the level will be in LeftView
    last element in the level will be in right view
    runtime : O(N), Space : O(N);
    */
   public static void leftRightViews(Node root){
     if(root == null) throw new IllegalArgumentException();
     Node curr = root;
     Queue<Node> queue = new LinkedList<>();
     queue.add(curr);
     List<Integer> leftView = new ArrayList<>();
     List<Integer> rightView = new ArrayList<>();

     while(!queue.isEmpty()){
       int size = queue.size();
       for(int i = 0; i < size; i++) {
         Node node = queue.poll();
         if(i == 0)
            leftView.add(node.data);
         if(i == size - 1)
            rightView.add(node.data);
         if(node.left != null)
            queue.add(node.left);
         if(node.right != null)
            queue.add(node.right);
         }
       }
       System.out.println("leftView = " + leftView);
       System.out.println("rightView = " + rightView);
    }

    private static class Node {
      private int data;
      private Node left;
      private Node right;
      private Node(int value){
        this.data = value;
      }
    }

    public static void main(String[] args) {
       Node root = new Node(1);
       root.left = new Node(6);
       root.right = new Node(8);
       root.left.left = new Node(3);
       root.left.right = new Node(0);
       root.right.left = new Node(4);
       root.right.right = new Node(10);
       leftRightViews(root);
    }
 }
