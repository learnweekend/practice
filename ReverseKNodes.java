/*
 problem : reverse linked list group of 'k' nodes
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 You may not alter the values in the nodes, only nodes itself may be changed.
 Only constant memory is allowed.
 For example,
 Given this linked list: 1->2->3->4->5
 For k = 2, you should return: 2->1->4->3->5
 For k = 3, you should return: 3->2->1->4->5
 */

 public class ReverseKNodes {

  public static Node reverseKNodes(Node node, int k){
     if(node == null) return null;
     if(k == 0) return node;
     Node curr = node;
     Node prev = null;
     Node next = null;
     int count = 0;
     while(curr != null && count < k) {
       next = curr.next;
       curr.next = prev;
       prev = curr;
       curr = next;
       count++;
     }
      if(next != null){
        node.next = reverseKNodes(next, k);
      }
      return prev;
   }

   private static void print(Node list){
     while(list != null){
       System.out.print(list.data + " ");
       list = list.next;
     }
     System.out.println();
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
     head.next.next = new Node(3);
     head.next.next.next = new Node(4);
     head.next.next.next.next = new Node(5);
     head.next.next.next.next.next = new Node(6);
     head.next.next.next.next.next.next = new Node(7);
     print(head);
     int k = 1;
     Node reversed = reverseKNodes(head, k);
     print(reversed);
   }
 }
