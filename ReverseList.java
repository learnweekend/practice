/**
  Problem :  Given a Linked List, print the elements in reverse order using iterative and Recursion.
  */
public class ReverseList {
 /**
  Solution 1:  Reverse linked list recursive approach, Note : The origianl list is NOT modified.
  Runtime   : O(N), Space : O(N) - recursive call stack
 */
  private static void reverseRecursive(Node node) {
    if(node == null)
      return;
    reverseRecursive(node.next);
    System.out.print(node.data + "  ");
  }
  /**
    Solution 2:  Reverse linked list iterative approach, Note : The origianl list IS modified
    Runtime : O(N), Space  : O(1)
  */
  private static Node reverseIterative(Node node) {
    Node prevNode = null;  //refer to prev node`
    Node currNode = node;  //current node
    Node nextNode = null;  //next node

    while(currNode != null) {
      nextNode = currNode.next;
      currNode.next = prevNode; //change the link to prev node.
      prevNode = currNode; // move the prev node forward
      currNode = nextNode; // move the curr node forward
    }
    return prevNode;
  }

  private static void print(Node temp) {
    while(temp != null) {
        System.out.print(temp.data + "  ");
        temp = temp.next;
    }
    System.out.println();
  }

  private static class Node {
    private int data;
    private Node next;
    private Node(int val) {
      this.data = val;
    }
  }

  public static void main(String args[]) {
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);
      System.out.print("Original  = ");
      print(head);
      Node reversed = reverseIterative(head); // the original list will get modified
      System.out.print("Reverse using iterative = ");
      print(reversed);
      System.out.print("Reverse using recursion = " );
      reverseRecursive(reversed);
      System.out.println();
  }
}
