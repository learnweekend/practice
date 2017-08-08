 /*
  problem : Add two linked list that represents a number
  You are given two linked lists representing two non-negative numbers.
  The digits are stored in reverse order and each of their nodes contain a single digit.
  Add the two numbers and return it as a linked list.
  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  Output: 7 -> 0 -> 8,   342 + 465 = 807
  Make sure there are no trailing zeros in the output list
  So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
  https://leetcode.com/problems/add-two-numbers/description/
  https://www.interviewbit.com/courses/programming/topics/linked-lists/
  */
  public class AddTwoNumbers {

    public static Node addTwoListsIterative(Node a, Node b){
      if(a == null) return b;
      if(b == null) return a;
      Node dummy = new Node(0);
      Node result = dummy;
      int carry = 0;
      while(a != null || b != null) {
        int sum = carry;
        if(a != null) {
           sum += a.data;
           a = a.next;
        }
        if(b != null){
          sum += b.data;
          b = b.next;
        }
        result.next = new Node(sum % 10); // add the node data
        carry = sum >= 10 ? 1 : 0; // carry
        result = result.next; // move the current list forward
      }
      if(carry > 0){
        result.next = new Node(carry);
      }
      return dummy.next;
    }
    /* Iterative solution, Runtime : O(max(a.length, b.length)), Space : O(1) */
    private static Node addTwoLists(Node a, Node b){
      Node result = new Node(0); // dummy node
      Node curr = result;
      int carry = 0;
      int sumValue = 0;
      int nodeValue = 0;

      // process smaller list first.
      while(a != null && b != null){
        sumValue = a.data + b.data + carry;
        carry = 0; // reset the carry after using.
        nodeValue = sumValue % 10;
        if(sumValue >= 10) {
           carry = sumValue/10; // or assign carry = 1 directly and it it cannot be more than 1
        }
        curr.next = new Node(nodeValue);
        curr = curr.next;
        a = a.next;
        b = b.next;
      }

      while(a != null) { // process the remaining elements from list a
        sumValue = a.data + carry;
        carry = 0; // reset to zero after using
        nodeValue = sumValue % 10;
        if(sumValue >= 10) {
           carry = sumValue/10;
        }
        curr.next = new Node(nodeValue);
        curr = curr.next;
        a = a.next;
      }

      while(b != null) { // process remaining elements from list b
        sumValue = b.data + carry;
        carry = 0; // reset to zero after using
        nodeValue = sumValue % 10;
        if(sumValue >= 10) {
           carry = sumValue/10;
        }
        curr.next = new Node(nodeValue);
        curr = curr.next;
        b = a.next;
      }
      if(carry > 0 ) { // after processing all nodes, add new node if carry is > 0 (1).
    	   curr.next = new Node(carry);
      }
      return result.next;  // return the start of result node
    }

    /* solution : Recursive
       Runtime : O(max(a.length, b.length)), Space : O(N) - call stack
     */
    private static Node addTwoListsRecursive(Node a, Node b, int carry) {
      if(a == null && b == null && carry == 0) return null;
      Node sumList = new Node(0); // start of the node
      int value = carry;
      if(a != null) {
          value = value + a.data;
      }
      if(b != null) {
        value = value + b.data;
      }
      sumList.data = value % 10;
      if(a!= null || b != null) {
          Node moreNodes = addTwoListsRecursive(a == null ? null : a.next,
                                                b == null ? null : b.next,
                                                value >= 10 ? 1 : 0);
          sumList.next = moreNodes;
      }
     return sumList;
    }

    private static void print(Node node){
      while(node != null){
        System.out.print(node.data + " ");
        node = node.next;
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
      Node a  = new Node(2);
      a.next = new Node(4);
      a.next.next = new Node(3);
      Node b = new Node(5);
      b.next = new Node(6);
      b.next.next = new Node(4);
      print(a);
      print(b);
      Node sumList = addTwoLists(a, b);
      print(sumList);
      Node sumListR = addTwoListsRecursive(a, b, 0);
      print(sumListR);

      Node iterativeSum = addTwoListsIterative(a, b);
      print(iterativeSum);
    }
  }
