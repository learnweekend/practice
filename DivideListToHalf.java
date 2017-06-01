public class DivideListToHalf {
  public static void main(String args[]) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    System.out.print("Original List  = ");
    print(head);
    Node secondHalf = divideListToHalf(head);
    System.out.print("First Half     = ");
    print(head);
    System.out.print("Second Half    = ");
    print(secondHalf);
  }
  /**
    Solution 1: Take two pointer slow and fast
    move the fast pointer two positions and move slow pointer one position forward,
    when fast pointer is reached at the end,
    the slow pointer will be at center of the list and return that node.
    If the number of elements are odd, the first list have one more element than 2nd half.
    Runtime : O(N)
    Space   : O(1)
  */
  private static Node divideListToHalf(Node node) {
    if(node == null)
      return null;
    Node slow = node.next;
    Node fast = node.next;
    Node prev = node; // to cut the first half

    while(slow != null && fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;  // cut the first half
    return slow;
  }

  private static void print(Node node) {
    if(node == null)
        throw new IllegalArgumentException();
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
