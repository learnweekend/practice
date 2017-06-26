import java.util.*;
/*
Problem :  Check if given two Binary Trees are equal.
   1
  /  \
 2    20
/ \   / \
3  30 40  50
*/
public class EqualBinaryTrees {
 public static void main(String[] args){
   // tree1
   Node tree1 = new Node(1);
   tree1.left = new Node(2);
   tree1.left.left = new Node(3);
   tree1.left.right = new Node(30);
   tree1.right = new Node(20);
   tree1.right.left = new Node(40);
   tree1.right.right = new Node(50);

   // tree2
   Node tree2 = new Node(1);
   tree2.left = new Node(2);
   tree2.left.left = new Node(3);
   tree2.left.right = new Node(30);
   tree2.right = new Node(20);
   tree2.right.left = new Node(40);
   tree2.right.right = new Node(50);

   boolean isEqual = areTwoTreesEqualRecursion(tree1, tree2);
   System.out.println("Recursive - isEqual = " + isEqual);

   boolean isEqual2 = areTwoTreesEqualIterative(tree1, tree2);
   System.out.println("Iterative - isEqual = " + isEqual2);
 }
 /* Solution : This is recursive Solution
   Check of data equality and recursively check of left and right subtrees.
   Runtime : O(smaller nodes tree)
   Space : O(1);
 */
 private static boolean areTwoTreesEqualRecursion(Node t1, Node t2) {

   if(t1 == null && t2 == null)
       return true;
   if(t1 == null || t2 == null)
       return false;

   return t1.data == t2.data &&
          areTwoTreesEqualRecursion(t1.left, t2.left) &&
          areTwoTreesEqualRecursion(t1.right, t2.right);
 }
 /* Solution : Iterative approach
    Take two queues (one queue for one tree root node) and process them tillthe queues are empty
    Runtime : O(smaller nodes tree)
    Space : O(N)
 */
 private static boolean areTwoTreesEqualIterative(Node t1, Node t2) {

   if(t1 == null && t2 == null)
       return true;
   if(t1 == null || t2 == null)
       return false;

   Queue<Node> queue1 = new LinkedList<Node>();
   Queue<Node> queue2 = new LinkedList<Node>();
   queue1.add(t1); // add tree root nodes
   queue2.add(t2);

   while(!queue1.isEmpty() && !queue2.isEmpty()) {
	   Node node1 = queue1.poll(); // remove from queues and process them
	   Node node2 = queue2.poll();
	   if(node1.data != node2.data)
		   return false;
       //left child
     if(node1.left != null && node2.left != null){  // if both left childs are not null, then add them to queue
		   queue1.add(node1.left);
		   queue2.add(node2.left);
	   } else if(node1.left != null || node2.left != null) { // if any leftchild is not null , return false
		   return false;
	   }
      // right child
	   if(node1.right != null && node2.right != null){ // if both right childs are not null, then add them to queue
		   queue1.add(node1.right);
		   queue2.add(node2.right);
	   } else if(node1.right != null || node2.right != null) { // if any rightchild is not null , return false
		   return false;
	   }
   }
   return true;
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
