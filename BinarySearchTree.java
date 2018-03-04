package samples.tree;

/* Problem :  Insertion in Binary Search Tree */

 public class BinarySearchTree {

  private Node root;

  public void insert(int data) {
    Node newNode = new Node(data);
    if(root == null) {
      root = newNode;
      return;
    } else {
        Node curr = root;
        while(true) {
          Node parent = curr; // to track the parent of new node
          if(data < curr.data){
            curr = curr.left;
            if(curr == null){
              parent.left = newNode;
              return;
            }
          } else {
            curr = curr.right;
            if(curr == null){
              parent.right = newNode;
              return;
            }
          }
        }
      }
    }


    public Node search(int data) {
      if(root == null) {
        return null;
      } else {
          Node curr = root;
          while(curr != null) {
            if(data < curr.data){
              curr = curr.left;
            } else if(data > curr.data){
              curr = curr.right;
            } else {
              return curr;
            }
          }
          return null;
        }
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

  public static void main(String[] args){
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10);
    bst.insert(9);
    bst.insert(11);
    bst.insert(8);
    bst.insert(12);
    bst.insert(10);

    bst.inOrder();
    System.out.println();

    Node searchNode = bst.search(15);
    if(searchNode == null)
      System.out.println("Not Found ");
    else
      System.out.println("Found =  " +searchNode.data);
    bst.insert(1);

    bst.inOrder();
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
