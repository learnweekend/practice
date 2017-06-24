/*
  Problem :  Remove a given elements from linked list.
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list,
Given a singly linked list of integers l and a non-negative integer k,
remove all elements from list l that have a value equal to k.
  Example : For list = [3, 1, 2, 3, 4, 5] and k = 3, the output should be list = [1, 2, 4, 5];
            For l = [1, 2, 3, 4, 5, 6, 7] and k = 10,the output should be list = [1, 2, 3, 4, 5, 6, 7]
*/
public class RemoveKFromList{
  public static void main(String args[]) {
    Node head = new Node(3);
    head.next = new Node(1);
    head.next.next = new Node(2);
    head.next.next.next = new Node(3);
    head.next.next.next.next = new Node(4);
    head.next.next.next.next.next = new Node(5);
    int elementToRemove = 3;
    removeKFromList(head, elementToRemove);
    Node curr = head;
    while(curr != null) {  // print list elements
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
  }
  /* Solution : Traverse the list and remove nodes if node data == k
     Runetime : O(N), Space : O(1)
  */
  private static void removeKFromList(Node list, int k) {
    if(list == null)
      return;
    Node temp = list;
    while(temp != null) { // Remove if first node(s) == K,
      if(temp.data == k) {
        list = list.next; // removed the node from original list
        temp = temp.next;
      } else
          break;  // no more starting nodes with value K
    }

   Node curr = list;
    while(curr != null && curr.next != null) {
      if(curr.next.data == k){
        curr.next = curr.next.next; // delete the node and move the pointer forward
      } else {
        curr = curr.next; // move the pointer forward
      }
    }
  }

  private static class Node {
    private int data;
    private Node next;

    private Node(int data){
      this.data = data;
    }
  }
}
