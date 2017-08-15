/*
 problem : Identify if linked list has cycle and return the node where cycle starts.
 https://leetcode.com/problems/linked-list-cycle-ii/description/ */
 import java.util.*;

public class CyclicNode {

  /* Solution : Using hash, store the nodes in HashSet as we traverse and check Set before adding.
     If the node is already present then list has cycle and starts at the same node.
     Runtime : O(N), Space : O(N)
  */
   private static Node cycleStartsAtV1(Node list) {
      Set<Node> visited = new HashSet<Node>();
      Node curr = list;
      while(curr != null) {
        if(visited.contains(curr)){
          return curr;
        } else {
          visited.add(curr);
        }
        curr = curr.next;
      }
      return null;
    }
    /* Solution : take two pointers slow and fast, check both pointers meet then list has cycles.
       Runtime : O(N), Space : O(1)
    */
    private static Node cycleStartsAtV2(Node list) {
      if(list == null)
        return null;
      Node slow = list;
      Node fast = list.next;
      boolean hasCycle = false;

      while(fast != null && fast.next != null) {
        if(slow == fast) { // list has cycles
          hasCycle = true;
          break;
        }
      slow = slow.next; // move slow one position forward
      fast = fast.next.next; // move fast two positions forward
     }

     if(hasCycle){
       slow = list;
       while(slow != fast){
         slow = slow.next;
         fast = fast.next;
       }
       return slow;
     }
     return null;
   }

    public static class Node {
      private int value;
      private Node next;
      private Node(int data) {
        this.value = data;
      }
    }
    public static void main(String args[]) {
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = head;
    /*  head.next.next = new Node(3);
      head.next.next.next = head.next; //new Node(4);
      head.next.next.next.next = new Node(5);
      head.next.next.next.next.next = new Node(6);
      //head.next.next.next.next.next.next = head.next.next.next; */ // loop
      Node cycleStartAt1 = cycleStartsAtV1(head);
      Node cycleStartAt2 = cycleStartsAtV2(head);
      if(cycleStartAt1 != null)
          System.out.println("cycle starts at node : " + cycleStartAt1.value);
      else {
         System.out.println("No Cycle Found");
      }
      if(cycleStartAt2 != null)
          System.out.println("cycle starts at node : " + cycleStartAt2.value);
      else {
         System.out.println("No Cycle Found");
      }
    }
}
