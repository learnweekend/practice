/*
 Problem : Given a BinaryTree, Traverse the tree using InOrder Iterator.
 */
import java.util.*;

 public class InOrderIterator implements Iterator<Integer> {

   private Node root;
   private Stack<Node> stack;

   public InOrderIterator(Node node){
     this.root = node;
     stack = new Stack<Node>();
   }

   @Override
   public boolean hasNext() {
     return root != null;
   }

   @Override
   public Integer next(){

     if(!hasNext()){
       throw new NoSuchElementException("Tree is Empty!");
     }
     if(stack.isEmpty()) {
        pushNodeAndLeftParentNodes(root); // push node and left parent nodes to stack.
     }
     Node node = stack.pop();  // pop from stack
     if(node.right != null){
       pushNodeAndLeftParentNodes(node.right); // if it has right children, push node and all its left parent nodes.
     }
     if(stack.isEmpty())
        root = null;

     return node.data;
   }

   @Override
   public void remove(){
     throw new UnsupportedOperationException("This method is not supported..");
   }

   private void pushNodeAndLeftParentNodes(Node node){
      while(node != null){
        stack.push(node);
        node = node.left;
      }
   }

   public static void main(String[] args){
     Node root = new Node(40);
     root.left = new Node(25);
     root.left.left = new Node(10);
     root.left.right = new Node(32);
     root.right = new Node(78);
     root.right.left = new Node(50);
     root.right.right = new Node(93);

     InOrderIterator inOrderIterator = new InOrderIterator(root);
     System.out.print("In-order traversal using iterator  : ");
     for(Iterator<Integer> itr = inOrderIterator; itr.hasNext(); ){
       System.out.print(itr.next() + " ");
     }
     System.out.println();
   }

   private static class Node{
     private int data;
     private Node left;
     private Node right;

     private Node(int value){
       this.data = value;
     }
   }
 }
