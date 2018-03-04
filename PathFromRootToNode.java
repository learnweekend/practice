package samples.tree;

/*


 problem : Given a binary (search) tree and node n1, find the path from root to given node
 */
import java.util.*;

 public class PathFromRootToNode {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    Stack<Node> path1 = pathFromRootToNode(root, root.left.right);
    Stack<Node> path2 = pathFromRootToNode(root, root.right);
    System.out.println(path1);
    System.out.println(path2);
  }

  /* store the path in stack */
  private static Stack<Node> pathFromRootToNode(Node root, Node node){
    if(root == null || node == null)
        return null;

    if(root.equals(node)) { // root will be the apth
      Stack<Node> stack = new Stack<>();
      stack.push(root);
      return stack;
    }
    Stack<Node> leftStack = pathFromRootToNode(root.left, node);
    Stack<Node> rightStack = pathFromRootToNode(root.right, node);

    if(leftStack != null) { // found the node on left sub-tree
      leftStack.push(root);
      return leftStack;
    }
    if(rightStack != null){ // found the node on right sub-tree
      rightStack.push(root);
      return rightStack;
    }
    return null;  // node not found
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
