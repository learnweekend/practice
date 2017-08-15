/*
 Problem : Rotate LinkedList given number of rotations(k).
 Example :  list :  [1, 2, 3, 4, 5, 6]
 after k rotations :[4, 5, 6, 1, 2, 3]
 https://leetcode.com/problems/rotate-list/description/
 Given a list, rotate the list to the right by k places, where k is non-negative.
 For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 */
 import java.util.*;

public class RotateLinkedList {

  /* Solution : Divide the list into two parts (break the link at k from last);
     add the second link to the beginning of the first list
    Runtime :  O(N), Space O(1) */

    private static Node rotateLinkedList(Node node, int k) {
       if (node == null || k == 0)
          return node;

       int size = 0;
       Node temp = node;

       //1.calculate size
       while (temp != null) { // get the size of the list to check if k is out of range
         temp = temp.next;
         size++;
       }
       // 2. take the modulus if length is greater than k
       if (k > size)
          k = k % size;

       // 3. base-cases extra validation
       if(k == 0 || size == 1 || k == size )
          return node;

       temp = node;
       for(int i = 0; i < size - k - 1; i++) {  // note -1
          temp = temp.next;
       }
       Node newHead = temp.next; // head of rotated list
       temp.next = null; // cut into two parts
       temp = newHead;

       while (temp.next != null) { // go to end of the list
           temp = temp.next;
       }
       temp.next = node; //attach the first part
       return newHead;
     }


  private static void printList(Node head){
    Node node = head;
    while(node != null){
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  private static class Node {
    private int data;
    private Node next;

    private Node(int val){
      this.data = val;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    int k = 3;
    Node rotated = rotateLinkedList(head, k);
    printList(rotated);
    System.out.println();
  }

}
