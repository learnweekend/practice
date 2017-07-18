/*
 Problem : Rotate LinkedList given number of rotations(k).
 Example :  list :  [1, 2, 3, 4, 5, 6]
 after k rotations :[4, 5, 6, 1, 2, 3]
 */
 import java.util.*;

public class RotateLinkedList {
  public static void main(String[] args) {

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);

    int k = 3;
    rotateLinkedList(head, k);
  }

  /* Solution :  divide the list into two parts (break the link at k from last);
     add the second link to the beginning of the first list
    Runtime :  O(N), Space O(1) */
  private static void rotateLinkedList(Node node, int k){
    if(node == null || k == 0)
      return;

    int size = 0;
    Node temp = node;
    while(temp.next != null) { // get the size of the list to check if k is out of range.
      temp = temp.next;
      size++;
    }
    if(k == size)
      return;
    if(k > size)
      k = k % size;  // take the modulus if length is greater than k

    System.out.print("original list = ");
    printList(node);
    System.out.println();
    temp = node;
    int i = 0;
    while(temp.next != null && i < (size - k)){
      temp = temp.next;
      i++;
    }
    Node newHead = temp.next;
    temp.next = null;

    temp = newHead;
    while(temp.next != null) {
      temp = temp.next;
    }
    temp.next = node;
    node = newHead;
    System.out.print("rotated list  = ");
    printList(node);
    System.out.println();
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
}
