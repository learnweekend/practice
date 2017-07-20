/*
 problem : print the elements in reverse level order traversal
 */
 import java.util.*;

 public class LevelOrderReverse {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    printLevelOrderReverse(root);
    System.out.println();
  }

  /* solution : Traverse the tree in level order and store the elements in stack
     print the stack, the elements will be in reverse order of level order traversal
     Runtime : O(N), space : O(N) */

  private static void printLevelOrderReverse(Node node){
    if(node == null) return;
    Queue<Node> queue = new LinkedList<>(); // for level order traversal
    Stack<Integer> stack = new Stack<>(); //to print in reverse order
    queue.add(node); // add root
    while(!queue.isEmpty()) {
      Node temp = queue.poll();
      stack.push(temp.data);
      if(temp.left != null){
        queue.add(temp.left);
      }
      if(temp.right != null){
        queue.add(temp.right);
      }
    }
    while(!stack.isEmpty()){
      System.out.print(stack.pop() + " ");
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
