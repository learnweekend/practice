/*
 problem : Remove duplicates from sorted list and return the node to the list(head)
 Given a sorted linked list, delete all duplicates such that each element appear only once.
 For example, Given 1->1->2, return 1->2.
              Given 1->1->2->3->3, return 1->2->3.

 https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
 https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
*/

public class RemoveDuplicatesFromSortedList {

  /* Solution : Iterative approach 
     Runtime : O(N), Space : O(1);
  */
  private static Node removeDuplicates(Node list){
     if(list == null) return null;
     Node curr = list;

     while(curr != null && curr.next != null){
         if(curr.data == curr.next.data){
            curr.next = curr.next.next;
         } else {
            curr = curr.next;
         }
     }
     return list;
  }

  private static void print(Node node){
    while(node != null){
       System.out.print(node.data + " ");
       node = node.next;
    }
  }

  private static class Node {
    private int data;
    private Node next;

    private Node(int data){
        this.data = data;
    }
  }

  public static void main(String[] args) {
     Node head = new Node(1);
     head.next = new Node(2);
     head.next.next = new Node(2);
     head.next.next.next = new Node(2);
     head.next.next.next.next = new Node(3);
     head.next.next.next.next.next = new Node(3);
     System.out.print("original list = ");
     print(head);
     System.out.println();
     Node result = removeDuplicates(head);
     print(result);
     System.out.println();
  }

}
