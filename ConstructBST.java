package samples.tree;

/*

 problem :  Construct a BST from a given array of integers
 */
 import java.util.*;
 public class ConstructBST {
  private Node root;
  public static void main(String[] args){
    //int[] arr = {15, 10, 20,8, 12, 18, 25};
    int[] arr = {4, 3, 5, 2, 0, 7,8, 6, 1, 9, 10};
    ConstructBST bst = new ConstructBST();
    Arrays.sort(arr);
    Node tmp = bst.constructBalancedBSTV2(arr, 0, arr.length - 1);
    System.out.println();
    bst.inOrder(tmp);
    System.out.println();
  }

  public void constructBalancedBSTV1(int[] arr, int low, int high){
    if(low > high) return ;
    int mid = low + (high - low)/2;
    insert(arr[mid]);
    constructBalancedBSTV1(arr, low, mid - 1);
    constructBalancedBSTV1(arr, mid + 1, high);
  }
  public void insert(int data){
    root = insert(root, data);
  }
  private Node insert(Node node, int data){
    if(node == null) return new Node(data);
    if(data < node.data){
      node.left = insert(node.left, data);
    } else if(data > node.data){
      node.right = insert(node.right, data);
    } else {
      node.data = data;
    }
     return node;
  }

  public Node constructBalancedBSTV2(int[] arr, int low, int high) {
    if(low > high) return null;
    int mid = low + (high - low)/2;
    Node temp = new Node(arr[mid]);
    temp.left = constructBalancedBSTV2(arr, low, mid - 1);
    temp.right = constructBalancedBSTV2(arr, mid + 1, high);
    return temp;
  }

  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node){
    if(node == null)
      return;
    inOrder(node.left);
    System.out.print(node.data + " ");
    inOrder(node.right);
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
