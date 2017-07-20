/*
 problem : given an pre-order traversal (array), construct the BST
 */
 import java.util.*;

 public class ConstructBSTFromPreOrder {

   public static void main(String[] args) {
     int[] preorder = {20, 15, 10, 16, 30, 25, 40};
     System.out.println("Given preorder : " + Arrays.toString(preorder));
     Node root = constructBSTFromPreOrder(preorder);
     System.out.print("in order   = ");
     inOrder(root);
     System.out.println();
     System.out.print("pre order  = ");
     preOrder(root);
     System.out.println();
     System.out.print("post order = ");
     postOrder(root);
     System.out.println();
   }

   private static Node constructBSTFromPreOrder(int[] preorder){
     if(preorder == null)
          return null;
     return constructBSTFromPreOrder(preorder, 0, preorder.length - 1);
   }
   /* Solution : Given preorder traversal(Root, Left, Right)
    1. The first element will be the root.
    2. Since its BST, the right subtree will be bigger than root, find the index of that element.
    3. all the elements before that index will be in left subtree (excluding root).
    4. The right subtree starts that index to end.
    5. Recursively follow the above steps for child nodes.
    Runtime :  O(N), Space : O(H) - call stack for recursion
    */
   private static Node constructBSTFromPreOrder(int[] preorder, int start, int end){
     if(start > end)
          return null;

     Node root = new Node(preorder[start]); // first element in pre-order would be the ROOT.
     if(start == end)
        return root;

     int index;
     for(index = start + 1; index <= end; index++){ // start + 1 because, root element is excluded
       if(preorder[index] > root.data) { // move the index "i" after the root.(where right substree starts)
         break;                      // the value will be bigger than root.
       }
     }
     root.left = constructBSTFromPreOrder(preorder, start + 1, index - 1); // left subtree starts after root and till the index
     root.right = constructBSTFromPreOrder(preorder, index, end); // right sub tree starts from index to end
     return root;
   }

   private static class Node {
     private int data;
     private Node left;
     private Node right;
     private Node(int value){
       this.data = value;
     }
   }

   private static void inOrder(Node node){
     if(node == null)
          return;
     inOrder(node.left);
     System.out.print(node.data + " ");
     inOrder(node.right);
   }

   private static void preOrder(Node node){
     if(node == null)
          return;
     System.out.print(node.data + " ");
     preOrder(node.left);
     preOrder(node.right);
   }

   private static void postOrder(Node node){
     if(node == null)
          return;
     postOrder(node.left);
     postOrder(node.right);
     System.out.print(node.data + " ");
   }

 }
