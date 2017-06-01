/**
Problem :  Given a linked list of UNKNOWN length
           find the Kth node from END (including) of the list.
           Note :  Assuming the list will have minimum k elements
*/
public class KthNodeInLinkedList {
  public static void main(String args[]) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    //head.next.next.next.next.next = new Node(6);
    System.out.print("Original List     = " );
    print(head);
    int k = 5; // 4
    Node kthNode = findKthNodeFromEnd(head, k);
    if(kthNode != null)
      System.out.println( k + "th Node from end = " +kthNode.data);
  }
  /**
    Solution 1: Take two pointer front and back
    move the front pointer k positions forward
    then start the back pointer from start of the list
    the back pointer will be at kth position from end when front pointer reached the end.
    Runtime : O(N)
    Space   : O(1)
  */
  private static Node findKthNodeFromEnd(Node node, int k) {
    if(node == null)
        throw new IllegalArgumentException();
    Node back = node;
    Node front = node;

    if(k == 0) { // if k = 0, means last node
        while(front.next != null)
          front = front.next;
        return front;
    }
    // move the front pointer k positions
    for(int i = 0; i < k; i++) {
      front = front.next;
    }
    while(front != null) {
      front = front.next; //move forward the front pointer
      back = back.next; // move the back pointer forward
    }
    return back;
  }

  private static void print(Node node) {
    if(node == null)
        return;
    Node temp = node;
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
}
