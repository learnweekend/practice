/*
 Problem :  Write an PreOrder Iterator for binary tree
 pre-order  : Root, Left, Right
*/
import java.util.*;

public class PreOrderIterator implements Iterator<Integer> {

  private Node root;
  private Stack<Node> stack;

  public PreOrderIterator(Node node){
    this.root = node;
    stack = new Stack<Node>();
  }

  @Override
  public boolean hasNext(){
    return root != null;
  }

  @Override
  public Integer next() {
    if(!hasNext()){
      throw new NoSuchElementException("Tree is Empty!");
    }
    if(stack.isEmpty())
      stack.push(root); // Note :just push root alone as "root" will be first element to visit in pre-order.

    Node node = stack.pop();

    if(node.right != null) {
        stack.push(node.right); // push right node first
    }
    if(node.left != null) {
        stack.push(node.left); // push right node first
    }
    if(stack.isEmpty()) { // no more elements and mark root is null.
      root = null;
    }
    return node.data;
  }

  @Override
  public void remove(){
    throw new UnsupportedOperationException("This method is not supported");
  }

  public static void main(String[] args){
    Node root = new Node(40);
    root.left = new Node(25);
    root.left.left = new Node(10);
    root.left.right = new Node(32);
    root.right = new Node(78);
    root.right.left = new Node(50);
    root.right.right = new Node(93);

    PreOrderIterator preOrderIterator = new PreOrderIterator(root);
    System.out.print("pre-order traversal with iterator :  ");
    for(Iterator<Integer> itr = preOrderIterator; itr.hasNext();){
      System.out.print(itr.next() + " ");
    }
    System.out.println();
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
