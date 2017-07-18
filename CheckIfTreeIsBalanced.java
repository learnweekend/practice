/*
 problem :  given a binary tree, check if the tree is balanced or not.
 */
 public class CheckIfTreeIsBalanced {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.right.right = new Node(8);
    //root.right.right.right.right = new Node(7); // not balanced
    System.out.println("isBalanced = " + isTreeBalancedV1(root));
    System.out.print("isBalanced = ");
    System.out.println(isTreeBalancedV2(root) == -1 ? false : true);
  }

  /* Solution 1 : Recursively check the height of left sub tree and right right subtree.
  return false if the difference is greater than 1 else return true.
  Runtime : O(N log N) as the height is get called more number of times (N).  Space : O(N)- recursive call stack.
  */

  private static boolean isTreeBalancedV1(Node node){
    if(node == null) return true;
    if(Math.abs(height(node.left) - height(node.right)) > 1){
      return false;
    } else {
      return isTreeBalancedV1(node.left) && isTreeBalancedV1(node.right);
    }
  }
  private static int height(Node node){
    if(node == null) return 0;
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  /* Solution 2: The above solution can be optimized by combining the height and recursive call in one method.
    Runtime : O(N) as the height is get called more number of times (N).  Space : O(N)- recursive call stack.
    value -1 means...not balanced
  */
  private static int isTreeBalancedV2(Node node){
    if(node == null) return 0; // 0 means balanced, -1 mean not balanced

    int leftTreeHeight = isTreeBalancedV2(node.left);
    if(leftTreeHeight == -1) return -1;

    int rightTreeHeight = isTreeBalancedV2(node.right);
    if(rightTreeHeight == -1) return -1;

    if(Math.abs(leftTreeHeight - rightTreeHeight) > 1){
      return -1;
    }
    return Math.max(leftTreeHeight, rightTreeHeight) + 1;
  }

  private static class Node {
    private int data;
    private Node left;
    private Node right;
    private Node(int val){
      this.data = val;
    }
  }
 }
