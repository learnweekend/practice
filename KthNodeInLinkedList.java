/**
Problem :  Given a linked list of UNKNOWN length, find the Kth node from END (including) of the list.
           Note :  Assuming the list will have minimum k elements
*/
public class KthNodeInLinkedList {
    /**
    Solution 1: Take two pointer front and back, move the front pointer k positions forward
    then start the back pointer from start of the list the back pointer will be at kth position
    from end when front pointer reached the end.
    Runtime : O(N), Space   : O(1)
  */
  private static Node findKthNodeFromEnd(Node node, int k) {
    if(node == null)
        throw new IllegalArgumentException();
    Node back = node;
    Node front = node;

    if(k == 0) { // if k = 0, means last node, traverse till end
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
    while(node != null) {
        System.out.print(node.data + "  ");
        node = node.next;
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
    System.out.print("original list     = " );
    print(head);
    System.out.println("1th node = " +findKthNodeFromEnd(head, 1).data);
    System.out.println("2th node = " +findKthNodeFromEnd(head, 2).data);
    System.out.println("3nd node = " +findKthNodeFromEnd(head, 3).data);
    System.out.println("4rd node = " +findKthNodeFromEnd(head, 4).data);
    System.out.println("5th node = " +findKthNodeFromEnd(head, 5).data);
  }
}
