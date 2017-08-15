/*
 problem : longest consecutive decreasing sequence in binary tree
 */
 public class LongestConsecutiveDecreasingSequenceInBinaryTree {

   public static int consecutive(Node root) {
     if(root == null) return 0;
     return max(consecutive(root.left, root.data, 1), consecutive(root.right, root.data,1));
   }

   private static int consecutive(Node root, int previousValue, int length) {
     if(root == null) return length;
     if(root.data == previousValue - 1){
       int left = consecutive(root.left, root.data, length + 1);
       int right = consecutive(root.right, root.data, length + 1);
       return max(left, right);
     } else {
       int left = consecutive(root.left, root.data, 1);
       int right = consecutive(root.right, root.data, 1);
       return max(left, right, length);
     }
   }

   private static int max(int... values){
     int max = Integer.MIN_VALUE;
     for(int i : values){
       if(i > max){
         max = i;
       }
     }
     return max;
   }

   public static int maxConsecutiveDecreasingSequence(Node root){
     if(root == null) return 0;
     //previousValue -> stores the value of the parent node.
     //Initialize previousValue with one MORE than value of root node so that the
     //path starting at root can be of length at least 1.
     return maxConsecutiveDecreasingSequence(root, root.data + 1, 0);
   }

   private static int maxConsecutiveDecreasingSequence(Node node, int previousValue, int previousLength){
     if(node == null) return previousLength;
     int currValue = node.data;
     if(currValue == previousValue - 1) { // the currValue should be greater by 1
       return Math.max(maxConsecutiveDecreasingSequence(node.left, currValue, previousLength + 1),
                       maxConsecutiveDecreasingSequence(node.right, currValue, previousLength + 1));
     }
     // reset the count to 1,
     int pathLength = Math.max(maxConsecutiveDecreasingSequence(node.left, currValue, 1),
                     maxConsecutiveDecreasingSequence(node.right, currValue, 1));

     return Math.max(previousLength, pathLength);
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
     Node root = new Node(8);
     root.left = new Node(6);
     root.right = new Node(3);
     root.left.left = new Node(5);
     root.left.right = new Node(7);
     root.right.left = new Node(2);
     root.right.right = new Node(2);
     root.right.right.left = new Node(1);
     root.right.right.left.right = new Node(0);
     root.right.right.right = new Node(0);
     root.left.left.left = new Node(1);
     root.left.left.right = new Node(4);
     root.left.left.right.left = new Node(3);
     root.left.left.right.right = new Node(1);
     root.left.left.right.right.left = new Node(1);
     root.left.left.right.right.right = new Node(0);

     int consecutiveDec = consecutive(root);
     System.out.println("consecutive = " +consecutiveDec);

     int longestDecSequence = maxConsecutiveDecreasingSequence(root);
     System.out.println(longestDecSequence);
   }

 }
