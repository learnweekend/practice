/*
 problem : Identify if linked list has cycle, return true or false.
 https://leetcode.com/problems/linked-list-cycle/description/
 */
 import java.util.*;

public class CycleInList {

   private static boolean detectCycleV1(Node list) {
      Set<Node> visited = new HashSet<Node>();
      Node curr = list;
      while(curr != null) {
        if(visited.contains(curr)){
          return true;
        } else {
          visited.add(curr);
        }
      }
      return false;
    }
    /* Solution : take two pointers slow and fast, check both pointers meet then list has cycles.
       Runtime : O(N), Space : O(1)
    */
    private static boolean detectCycleV2(Node list) {
      if(list == null)
        return false;
      Node slow = list;
      Node fast = list.next;

      while(fast != null && fast.next != null) {
        if(slow == fast) { // it works if first node has cycle
          return true;
        }
        slow = slow.next; // move slow one position forward
        fast = fast.next.next; // move fast two positions forward
      }
      return false;
    }

    public static class Node {
      private int value;
      private Node next;
      private Node(int data) {
        this.value = data;
      }
     @Override
      public int hashCode(){
        return value.hashCode();
      }

      @Override
      public boolean equals(Object o){
        return (o instanceof Node) && ((Node)o.value == this.value);
      }
    }
    public static void main(String args[]) {
      Node head = new Node(1);
      head.next = new Node(2);
      /*head.next.next = head;
      head.next.next = new Node(3);
      head.next.next.next = head.next; //new Node(4);
      head.next.next.next.next = new Node(5);
      head.next.next.next.next.next = new Node(6);
      //head.next.next.next.next.next.next = head.next.next.next; */ // loop
      System.out.println("cycle present ? : " + detectCycleV1(head));
      System.out.println("cycle present ? : " + detectCycleV2(head));
    }

}
