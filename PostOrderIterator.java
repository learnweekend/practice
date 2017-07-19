/*
 Problem : Given a binary tree, Traverse the tree using postOrder Iterator
 post-order : Left, Right, Root
 */
import java.util.*;

 public class PostOrderIterator implements Iterator<Integer> {

   private Node root;
   private Stack<Node> stack;

   public PostOrderIterator(Node node){
     this.root = node;
     stack = new Stack<Node>();
   }

   @Override
   public boolean hasNext(){
     return root != null;
   }

   @Override
   public Integer next(){
    if (!hasNext()) {
       throw new NoSuchElementException("Tree is empty!");
     }
     if(stack.isEmpty()) {
       pushNodeAndLeafNodes(root);
     }
     Node node = stack.pop();
     if (!stack.isEmpty()) {
        Node top = stack.peek();
        if (node == top.left) {
            pushNodeAndLeafNodes(top.right); // find next leaf in right sub-tree
           }
      }
      if(stack.isEmpty()){
         root = null;
      }
      return node.data;
   }

   @Override
   public void remove(){
     throw new UnsupportedOperationException("This method is not supported");
   }

   private void pushNodeAndLeafNodes(Node node){
     Node curr = node;
     while (curr != null) {
       stack.push(curr);
       if (curr.left != null) {
         curr = curr.left;
       } else {
         curr = curr.right;
       }
     }
   }

   private static void postOrderRecursion(Node root){
     if(root == null)
        return;
     postOrderRecursion(root.left); // print left children
     postOrderRecursion(root.right); // print right children
     System.out.print(root.data + " "); // print current node
   }

   public static void main(String[] args){
     Node root = new Node(40);
     root.left = new Node(25);
     root.left.left = new Node(10);
     root.left.right = new Node(32);
     root.right = new Node(78);
     root.right.left = new Node(50);
     root.right.right = new Node(93);

     PostOrderIterator postOrderIterator = new PostOrderIterator(root);
     System.out.print("post-order with iterator  : ");
     for(Iterator<Integer> itr = postOrderIterator; itr.hasNext();){
       System.out.print(itr.next() + " ");
     }
     System.out.println();

     System.out.print("post order with recursion : ");
     postOrderRecursion(root);
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
