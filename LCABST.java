package samples.tree;

/*
 problem : Lowest Common Ancestor in Binary(Search) tree
 */
 public class LowestCommonAncestorBST {
   public static void main(String[] args) {
     Node root = new Node(20);
     root.left = new Node(10);
     root.right = new Node(25);
     root.right.left = new Node(22);
     root.right.right = new Node(30);
     root.left.left = new Node(5);
     root.left.right = new Node(15);
     System.out.println(lcaBST(root, root.left.left, root.left).data);
   }
   /* Solution : Check the root and nodes values and recursively go left or right
      Runtime  :O(H) - since BST, Space O(H) - call stack.
    */
   private static Node lcaBST(Node root, Node node1, Node node2){
     if(root == null)
        return null;
    //1. if root node is greater than larger child, then go left.
    if(root.data > Math.max(node1.data, node2.data)){
      return lcaBST(root.left, node1, node2); // left side of root
      //2. if root node is smaller than small child then go right
    } else if(root.data < Math.min(node1.data, node2.data)){
      return lcaBST(root.right, node1, node2); // right side of root
    } else {
      return root; // root will be the lca.
    }
   }

   private static class Node{
     private int data;
     private Node left;
     private Node right;
     private Node(int val){
       this.data = val;
     }
     @Override
     public String toString(){
       return this.data + " ";
     }
   }
 }
