/*
  Problem : Given a singly linked list, check if the given list is palindrome or not.
*/
public class ListPalindrome<T> {
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next = new ListNode<Integer>(3);
		head.next.next = new ListNode<Integer>(2);
		head.next.next.next = new ListNode<Integer>(2);
		head.next.next.next.next = new ListNode<Integer>(2);
		//head.next.next.next.next.next = new ListNode<Integer>(3);
		//head.next.next.next.next.next.next = new ListNode<Integer>(1);

		System.out.println(isListPalindrome(head));
	}
	/* Solution :
	 * 1. Find the middle of the list, divide the list into two halves.
	 * 2. Reverse the second half of the list.
	 * 3. Compare the first list with reversed list.
	 * 4. Return True if both are equal else return False
   *    Runtime  : O(N), Space : O(1)
	 */
	private static boolean isListPalindrome(ListNode<Integer> list1) {
		ListPalindrome<Integer> testMain = new ListPalindrome<Integer>();

		if(list1 != null && testMain.size(list1) <= 1) {  // base case
			return true;
		}
		ListNode<Integer>  list2 = testMain.divideListToHalf(list1); // divide list into two halves
		ListNode<Integer> list2Reversed = testMain.reverse(list2); // reverse the second half list
		boolean isPalindrome = testMain.checkListsForPalindrome(list1, list2Reversed);

		return isPalindrome;
	}
	/*
	 *  Find the middle and divide the list into two halves.
	 */
	private ListNode<T> divideListToHalf(ListNode<T> node) {
	    if(node == null)
	      return null;

	    ListNode<T> slow = node.next;
	    ListNode<T> fast = node.next;
	    ListNode<T> prev = node; // to cut the first half

	    while(slow != null && fast != null && fast.next != null) {
	      prev = slow;
	      slow = slow.next;
	      fast = fast.next.next;
	    }
	    prev.next = null;  // cut the first half
	    return slow;
	  }
	/*
	 *  Find the size of the list
	 */
	private int size(ListNode<T> list) {
		int length = 0;
		ListNode<T> temp = list;
		while (temp != null) { // get length of list
			length++;
			temp = temp.next;
		}
		return length;
	}
	/*
	 * Reverse the list and return the head of reversed list
	 */
	private ListNode<Integer> reverse(ListNode<Integer> listToReverse) {
		ListNode<Integer> prev = null;
		ListNode<Integer> nextPtr = null;
		ListNode<Integer> curr = listToReverse;

		while (curr != null) {
			nextPtr = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextPtr;
		}
		return prev;
	}
	/*
	 * Check if given two lists are palindrome
	 */
	private boolean checkListsForPalindrome(ListNode<T> list1, ListNode<T> list2) {

		if(list1 == null || list2 == null)
			return false;

		ListNode<T> temp1 = list1;
		ListNode<T> temp2 = list2;

		while(temp1 != null && temp2 != null) {
		  if(!(list1.data.equals(list2.data)))
			 return false;
		   temp1 = temp1.next;
		   temp2 = temp2.next;
		}
		return true;
	}
	/*
	 *  Linked List node
	 */
	private static class ListNode<T> {
		private T data;
		private ListNode<T> next;

		private ListNode(T value) {
			this.data = value;
		}
	}

}
