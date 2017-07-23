/*
 problem : Check if a given tree is BST or not
 */
 public class CheckBST {
   public static void main(String[] args) {
     Node root = new Node(20);
     root.left = new Node(10);
     root.right = new Node(25);
     root.right.left = new Node(22);
     root.right.right = new Node(30);
     root.left.left = new Node(5);
     root.left.right = new Node(15);
     System.out.println("isBST = " +checkBSTV1(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
     System.out.println("isBST = " +checkBSTV2(root)); // 5 will be lowest node in the tree (leftmost node)
   }

   /* solution 1 :  Uses pre-order traversal */

   private static boolean checkBSTV1(Node node, int low, int max){
    if(node == null) return true;
    if(node.data > low && node.data < max){
      return checkBSTV1(node.left, low, node.data) && checkBSTV1(node.right, node.data, max);
    }
    return false;
   }

   /* solution 2 :  Uses in-order traversal , previousValue = leftmost node value(min element)
      In in-order traversal,
      The current node value should be greater than previous node value and
      the next node visited should be greater than the current node.
    */
   private static boolean checkBSTV2(Node root){
     Node node = root;
     while(node.left != null){
       node = node.left;
     }
     int previousValue = node.data;
     return checkBSTV2(root, previousValue);
   }

   private static boolean checkBSTV2(Node node, int previousValue){
    if(node == null)
        return true;
    return checkBSTV2(node.left, previousValue) && // left child
                     node.data >= previousValue && // current node, Note:  >=
                     checkBSTV2(node.right, previousValue = node.data); // right child
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
