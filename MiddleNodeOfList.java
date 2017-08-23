
public class MiddleNodeOfList {

  /* Soultion 1 : Brute-force solution to find the middle node in the linked list
     if the number of nodes are even, return first element
     if the number of nodes are odd, return the middle element
     runtime : o(N), space : O(1)
     Note : This requires two iterations of the 2 iterations
  */
  public static Node getMiddleNodeV1(Node head){
    if(head == null) return null;
    int size = size(head);
    Node curr = head;
    int middle = 0;

    if(size % 2 == 0)
        middle = size/2;
    else
        middle = size/2 + 1;

    while(--middle > 0) {
      curr = curr.next;
    }
    return curr;
  }

  /* Soultion 2 : Use slow and fast pointers
     slow pointer starts at head, fast pointer starts at next node of head.
     move the slow pointer one step and fast pointer two steps.
     Note : this is fast and required one iteration of list.
     runtime : o(N), space : O(1)
  */

  public static Node getMiddleNodeV2(Node head){
    if(head == null) return null;
    Node slow = head;
    Node fast = head.next; // fast is referring to next node of head

    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private static int size(Node head){
    int size = 0;
    if(head == null) return size;
    Node curr = head;
    while(curr != null) {
      size++;
      curr = curr.next;
    }
    return size;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    System.out.println("Middle Node V1 = "  +getMiddleNodeV1(head).data);
    System.out.println("Middle Node V2 = "  +getMiddleNodeV2(head).data);
  }

  private static class Node {
    private int data;
    private Node next;
    private Node(int data){
      this.data = data;
    }
  }
}
