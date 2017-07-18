 /*
  problem : Given a binary tree, create a linked list of all the nodes at each level and return.
  */
import java.util.*;
public class LevelOrder {
  public static void main(String[] args){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    /*
    1
    2 3
    4 5 6 7
    */
    System.out.println(" Solution 1 ");
    List<List<Node>> allNodesByLevel = getNodesByLevelV1(root);
    for(List<Node> byLevel : allNodesByLevel) {
      for(int i = 0; i < byLevel.size(); i++){
        System.out.print(byLevel.get(i).data + " ");
      }
      System.out.println();
    }
    System.out.println(" Solution 2 ");
    List<List<Node>> result = getNodesByLevelV2(root);
    for(List<Node> byLevel : allNodesByLevel) {
      for(int i = 0; i < byLevel.size(); i++){
        System.out.print(byLevel.get(i).data + " ");
      }
      System.out.println();
    }
  }
  /* Solution 1:  This uses Level Order Traversal using Queue (two queues)
     Runtime : O(N), Space : O(N); */
  private static List<List<Node>> getNodesByLevelV1(Node node){
    if(node == null) return null;
    Queue<Node> q = new LinkedList<>();
    q.add(node);
    List<List<Node>> allNodes = new LinkedList<>();
    List<Node> level = null;

    while(!q.isEmpty()) {
      level = new LinkedList<>();
      Queue<Node> childQ = new LinkedList<Node>(); // to store next level children
      while(!q.isEmpty()){
        Node curr = q.poll();
        level.add(curr);
        if(curr.left != null){  // add left and right children
          childQ.add(curr.left);
        }
        if(curr.right != null){
          childQ.add(curr.right);
        }
      }
      q = childQ; // process the children queue
      allNodes.add(level);
    }
    return allNodes;
  }

  /* Solution 2:  This uses Level Order Traversal using Queue (two queues)
     Runtime : O(N), Space : O(N) - for result,
     Note : This is more efficient in space as it doesn't need external storage */
   private static List<List<Node>> getNodesByLevelV2(Node node){
    if(node == null) return null;
    List<List<Node>> allNodes = new LinkedList<>();
    List<Node> level = new LinkedList<>();
    level.add(node);

    while(level.size() > 0) {
      allNodes.add(level);
      List<Node> parents = level;
      level = new LinkedList<Node>();
      for(Node n : parents){
        if(n.left != null){
          level.add(n.left);
        }
        if(n.right != null){
          level.add(n.right);
        }
      }
    }
    return allNodes;
  }

  private static class Node{
    private int data;
    private Node left;
    private Node right;
    private Node(int val){
      this.data = val;
    }
  }
}
