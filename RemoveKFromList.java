/*
 Problem :  Remove a given elements from linked list.
 Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list,
 Given a singly linked list of integers l and a non-negative integer k,
 remove all elements from list l that have a value equal to k.
 Example : For list = [3, 1, 2, 3, 4, 5] and k = 3, the output should be list = [1, 2, 4, 5];
 For l = [1, 2, 3, 4, 5, 6, 7] and k = 10,the output should be list = [1, 2, 3, 4, 5, 6, 7]

 https://leetcode.com/problems/remove-linked-list-elements/description/
 */
 public class RemoveKFromList {

    /* solution : Create one dummy node and return dummy.next
       Runtime : O(N), Space : O(1);
    */
    private static Node removeKFromListV2(Node list, int k) {
       if (list == null) return null;
       Node dummy = new Node(0); // dummy node
       dummy.next = list;
       Node temp = dummy;

       while (temp.next != null) {
          if (temp.next.data == k) {
              temp.next = temp.next.next; // remove the node
          } else {
              temp = temp.next;
          }
       }
       return dummy.next;
    }

   /* solution : iterative solution withour dummy node
      Runtime : O(N), Space : O(1);
   */
   private static Node removeKFromList(Node list, int k) {
      if (list == null)
          return null;
      Node temp = list;

      while (temp != null) { // Remove if first node(s) == K,
         if (temp.data == k) {
              list = list.next; // removed from original list
              temp = temp.next;
         } else
              break;
         }
      Node curr = list;

      while (curr != null && curr.next != null) {
         if (curr.next.data == k) {
            curr.next = curr.next.next; // delete the node and move the  pointer forward
         } else {
             curr = curr.next; // move the pointer forward
         }
      }
      return temp;
  }

  private static void print(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
    System.out.println();
	}

  private static class Node {
     private int data;
     private Node next;
     private Node(int data) {
         this.data = data;
     }
  }

  public static void main(String args[]) {
     Node head = new Node(1);
     head.next = new Node(2);
     head.next.next = new Node(3);
     head.next.next.next = new Node(4);
     head.next.next.next.next = new Node(5);
     head.next.next.next.next.next = new Node(6);
     head.next.next.next.next.next.next = new Node(7);
     print(head);
     int elementToRemove = 2;
     //removeKFromList(head, elementToRemove);
     Node removedList = removeKFromListV2(head, elementToRemove);
     print(removedList);
   }
}
