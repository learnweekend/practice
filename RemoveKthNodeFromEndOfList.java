/**
Problem :  Given a linked list of UNKNOWN length, find the Kth node from END (including) of the list.
           Note :  Assuming the list will have minimum k elements
 Given a linked list, remove the nth node from the end of list and return its head.
 For example, Given linked list: 1->2->3->4->5, and n = 2.
 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note: Given n will always be valid. Try to do this in one pass.

  https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
  https://www.interviewbit.com/problems/remove-nth-node-from-list-end/
*/
public class RemoveKthNodeFromEndOfList {
    /**
    Solution 1: Take two pointers slow and fast, move the fast pointer k positions forward
    then start the slow pointer from start of the list the back pointer will be at kth position
    from end when front pointer reached the end.
    Runtime : O(N), Space  : O(1)
  */
   private static Node removeKthNodeFromEndV1(Node node, int k){
		  Node start = new Node(0); // dummy node.
	    Node slow = start;
	    Node fast = start;
	    slow.next = node; // beginning of the list
	    //Move fast pointer forward 'k' positions so that the gap between slow and fast becomes 'k'
	    for(int i = 0; i <= k; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, and slow maintaining the gap of 'k'
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    slow.next = slow.next.next; //remove the desired node
	    return start.next;
  }

  /* Solution without using the dummy node
     Runtime : O(N), Space : O(1);
   */
  private static Node removeKthNodeFromEnd(Node node, int k) {
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
    for(int i = 0; i < k - 1; i++) {
      front = front.next;
    }
    while(front != null) {
      front = front.next; //move forward the front pointer
      back = back.next; // move the back pointer forward
    }
   // remove the kth node
    Node temp = back.next.next;
    back.next = temp;

    return node;
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
    Node removedOne = removeKthNodeFromEndV1(head, 1);
    print(removedOne);
  }
}
