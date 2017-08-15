/*
 problem : sort linked list
 */
 public class SortLinkedList {
 /* solution : Recursive merge  1. divide the list into two halves (recursively)
    2. sort and merge the sorted sub lists, Runtime : O( N log N),  Space : O(1);
  */
  public static Node sort(Node list) {
    if(list == null ||  list.next == null) {
      return list;
    }
    Node middle = getMiddleNode(list);
    Node nextToMiddle = middle.next;
    middle.next = null; // cut the list
    Node leftHalf = sort(list); // list holds the first half
    Node rightHalf = sort(nextToMiddle);
    Node sortedList = merge(leftHalf, rightHalf);
    return sortedList;
  }
  /* Helper method to Sort and Merge two sub lists */
  private static Node merge(Node left, Node right) {
    if(left == null) return right;
    if(right == null) return left;
    Node head = null; // holds the merged list
    if(left.data < right.data){
      head = left;
      head.next = merge(left.next, right);
    } else {
      head = right;
      head.next = merge(left, right.next);
    }
    return head;
  }

  private static Node getMiddleNode(Node list) {
      if(list == null || list.next == null)
        return list; // note : return list ( NOT null)
      Node slow = list;
      Node fast = list.next;  // point the fast to 2nd node
      while(fast != null) {
          fast = fast.next;
          if(fast != null) {
            slow = slow.next; // increment slow and fast pointers
            fast = fast.next;
          }
      }
      return slow;  // slow is middle
  }
  // print the list
  private static void printList(Node node) {
    Node current = node;
    while(current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
  }
  // list node class
  private static class Node {
    private int data;
    private Node next;
    private Node(int data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    Node list = new Node(4);
    list.next = new Node(3);
    list.next.next = new Node(2);
    list.next.next.next = new Node(1);
    System.out.print("original = ");
    printList(list);
    System.out.println();
    Node sorted = sort(list);

    System.out.print("sorted   = ");
    printList(sorted);
    System.out.println();
  }

 }
