/*
 problem : find Kth largest element in Binary Search Tree (BST)
 Note : Solution 4, 3 and 2 are efficient compared to solution 1.
 The solutions gives Index out of bound exception when "k" is larger than number of elements in the tree.
 */
 import java.util.*;

 public class KthLargestInBST {

   private static int count = 0; // global counter

   public static void main(String[] args) {
     Node root = new Node(20);
     root.left = new Node(15);
     root.right = new Node(30);
     root.left.left = new Node(10);
     root.left.right = new Node(16);
     root.right.left = new Node(25);
     root.right.right = new Node(35);

     int k = 3;

     int kthLargest1 = kthLargestElementInBSTV1(root, k);
     System.out.println();
     System.out.println(k +"th Largest1 = " + kthLargest1);

     int[] count = {0};
     Node kthLargest2 = kthLargestElementInBSTV2(root, k, count);
     System.out.println();
     System.out.println(k +"th Largest2 = " + kthLargest2.data);

     Node kthLargest3 = kthLargestElementInBSTV3(root, k);
     System.out.println();
     System.out.println(k +"th Largest3 = " + kthLargest3.data);

     Node kthLargest4 = kthLargestElementInBSTV4(root, k);
     System.out.println();
     System.out.println(k +"th Largest4 = " + kthLargest4.data);

   }
  /* solution 1 : traverse the tree in-order and store all the elements to array(list) and return the
     kth element from end of the array.
     Runtime : O(N), Space : O(N) - to store the inorder traversal elements
   */
   private static int kthLargestElementInBSTV1(Node node, int k) {
     List<Integer> inorderList = new ArrayList<>();
     inOrder(node, inorderList);
     return inorderList.get(inorderList.size() - k);
   }
   private static void inOrder(Node node, List<Integer> result){
     if(node == null)
          return;
     inOrder(node.left, result);
     result.add(node.data);
     inOrder(node.right, result);
   }

   /* solution 2 : traverse the tree reverse of in-order and have a counter (for kth number);
      once the count reaches the kth, return the element.
      Runtime : O(K), Space : O(H) - to store recursive call stack.
      Note : count should be glogal so that its get updated in call stack, hence choosen count[] array
    */
    private static Node kthLargestElementInBSTV2(Node node, int k, int[] count){
      if(node == null)
         return null;

      Node kthLargest = null;
      kthLargest = kthLargestElementInBSTV2(node.right, k, count);

      if(kthLargest == null) {
        count[0] = count[0] + 1;
        if(count[0] == k) {
          kthLargest = node;
        }
      }
      if(kthLargest == null){
        kthLargest = kthLargestElementInBSTV2(node.left, k, count);
      }
      return kthLargest;
    }
    /* solution 3 : traverse the tree reverse of in-order and have a counter (for kth number);
       once the count reaches the kth, return the element.
       Runtime : O(K), Space : O(H) - to store recursive call stack.
       Note : The count is a "class" variable (static) so that it will get updated in method call stack.
     */
     private static Node kthLargestElementInBSTV3(Node node, int k){
       if(node == null)
          return null;

       Node kthLargest = null;
       kthLargest = kthLargestElementInBSTV3(node.right, k);

       if(kthLargest == null) {
         count = count + 1;
         if(count == k) {
           kthLargest = node;
         }
       }
       if(kthLargest == null){
         kthLargest = kthLargestElementInBSTV3(node.left, k);
       }
       return kthLargest;
     }

     /* solution 4 : Using Reverse InOrder Iterative traversal.
        Traverse the K elements in "reverse in-order iterative" and return the node after "k" elements traversed.
        Runtime : O(K), Space : O(H) - maximum height of tree
      */

      private static Node kthLargestElementInBSTV4(Node node, int k){
        if(node == null)
           return null;
        Stack<Node> stack = new Stack<>();
        int count = 0;
        pushNodeAndRightChildren(node, stack);
        while(!stack.isEmpty()){
          node = stack.pop();
          count++;
          if(count == k)
             return node;
          if(node.left != null){
            node = node.left;
            pushNodeAndRightChildren(node, stack);
          }
        }
        return null;
    }

    private static void pushNodeAndRightChildren(Node node, Stack<Node> stack){
      while(node != null){
        stack.push(node);
        node = node.right;
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
