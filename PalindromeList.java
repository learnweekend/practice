/*
 problem : List Palindrome
 Given a singly linked list, determine if it is a palindrome.
 Follow up: Could you do it in O(n) time and O(1) space?
 */
 public class PalindromeList {
   /* solution : Iterative
      1. find the middle and devide the list into two parts
      2. reverse the second half.
      3. traverse the reversedlist and first half and compare elements.
      4. return true if all of them match otherwise false
    */
   private static boolean isListPalindrome(Node a){
     if(a == null) return true;
     Node part2 = getSecondHalfOfList(a);
     Node reversedPart2 = reverseList(part2);
     while(a != null && reversedPart2 != null){
       if(a.data != reversedPart2.data)
          return false;
        a = a.next;
        reversedPart2 = reversedPart2.next;
     }
     return true;
   }

   private static Node reverseList(Node node) {
    if(node == null) return node;
    Node curr = node;
    Node prev = null;
    Node next = null;
    while(curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
  }

   private static Node getSecondHalfOfList(Node list) {
       if(list == null || list.next == null)
         return null;
       Node slow = list;
       Node fast = list.next;  // point the fast to 2nd node
       while(fast != null) {
           fast = fast.next;
           if(fast != null) {
             slow = slow.next; // increment slow and fast pointers
             fast = fast.next;
           }
       }
       Node partTwo = slow.next;
       slow.next = null;
       return partTwo;
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
     Node a  = new Node(1);
     a.next = new Node(2);
     a.next.next = new Node(1);
     //a.next.next.next = new Node(2);
     //a.next.next.next.next = new Node(2);
     print(a);
     //Node part2 = getSecondHalfOfList(a);
     //print(a);
     //print(part2);

     boolean isPalindrome = isListPalindrome(a);
     System.out.println("is list palindrome ? : " + isPalindrome);
   }
 }
