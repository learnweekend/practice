/*
 problem : Remove duplicates from sorted list and return the node to the list(head)
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.

 https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
 https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
*/

public class RemoveAllDuplicateNodes {

  /* solution : have one additiona dummy node referring to start of the list
     have two inner while loops to keep track of move curr pointers based on duplicates
     have one deleteFlag variable which tells us which pointer we should move
     Runtime : O(N),  space : O(1)
  */
  private static Node removeAllDuplicatesV2(Node head) {

      if (head == null) return null;

      Node dummyHead = new Node(0);
      dummyHead.next = head;
      Node pre = dummyHead;
      Node curr = head;

      while (curr != null) {
           while (curr.next != null && curr.data == curr.next.data) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
   }

  /* solution : have one additiona dummy node referring to start of the list
     have two inner while loops to keep track of move curr pointers based on duplicates
     have one deleteFlag variable which tells us which pointer we should move
     Runtime : O(N),  space : O(1)
  */
  private static Node removeDuplicates(Node list){
     if(list == null) return null;
     Node dummy = new Node(0); // just dummy node refers to start of the list.
     dummy.next = list;
     Node gCurr = dummy;

     while(gCurr.next != null) {
       Node lCurr = gCurr.next;
       boolean deleteFlag = false;

       while(lCurr != null && lCurr.next != null) {
            if(lCurr.data == lCurr.next.data) {
              lCurr.next = lCurr.next.next; // remove the next duplicate element
              deleteFlag = true; // to remove the current element
            } else {
             break; // break the inner while loop, and its time to increment the global while condition
            }
       }
       if(deleteFlag) {
         gCurr.next = lCurr.next; // remove the duplicated node
       } else {
         gCurr = lCurr; // no duplicates found.
      }
     }
     return dummy.next;
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
     Node result = removeAllDuplicatesV2(head);
     print(result);
     System.out.println();
  }
}
