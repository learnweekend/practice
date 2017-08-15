/*
 problem : Merge Two Sorted lists
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
 For example, given following linked lists :
  5 -> 8 -> 20  and 4 -> 11 -> 15
 The merged list should be : 4 -> 5 -> 8 -> 11 -> 15 -> 20

 https://www.interviewbit.com/problems/merge-two-sorted-lists/
 https://leetcode.com/problems/merge-two-sorted-lists/description/

*/
public class MergeTwoSortedLists {

  /* Solution : Iterative, loop while one of the list is empty and compare the elements and move curr node pointers based on condition
     Runtime : O(N), Space : O(1)
     https://www.interviewbit.com/problems/merge-two-sorted-lists/
  */
  private static Node mergeTwoSortedLists(Node a, Node b){
    if(a == null && b == null) return null;
    if(a == null) return b;
    if(b == null) return a;

    Node head = new Node(-1); // dummy node
    Node curr = head;
    while(a != null && b != null) {
      if(a.data < b.data){
        curr.next = a;
        a = a.next;
      } else {
        curr.next = b;
        b = b.next;
      }
      curr = curr.next;
    }
    if(a == null) {
      curr.next = b;
    } else {
      curr.next = a;
    }
    head = head.next;
    return head;
  }

  /* Solution : Recursive approach.
     Runtime : O(N), Space : O(N) - due to call stack.
  */
 private static Node merge(Node list1, Node list2) {
   if(list1 == null && list2 == null) return null;
   if(list1 == null) return list2;
   if(list2 == null) return list1;
   Node head = null; // holds the merged list
   if(list1.data < list2.data){
     head = list1;
     head.next = merge(list1.next, list2);
   } else {
     head = list2;
     head.next = merge(list1, list2.next);
   }
   return head;
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
   Node list1 = new Node(4);
   list1.next = new Node(8);
   list1.next.next = new Node(10);
   list1.next.next.next = new Node(12);
   System.out.print("list1 = ");
   printList(list1);
   System.out.println();

   Node list2 = new Node(5);
   list2.next = new Node(6);
   list2.next.next = new Node(9);
   list2.next.next.next = new Node(11);
   list2.next.next.next.next = new Node(14);
   list2.next.next.next.next.next = new Node(15);
   list2.next.next.next.next.next.next = new Node(18);
   System.out.print("list2 = ");
   printList(list2);
   System.out.println();

  /* Node mergedList = merge(list1, list2);
   System.out.print("sorted   = ");
   printList(mergedList);
   System.out.println();*/

   Node mergeTwoSortedLists = mergeTwoSortedLists(list1, list2);
   printList(mergeTwoSortedLists);
   System.out.println();
 }

}
