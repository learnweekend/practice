package leetcode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/ 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed. Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode newHead = head.next;
		ListNode temp = head.next.next;
		newHead.next = head;
		head.next = swapPairs(temp);
		return newHead;
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int x) {
			this.val = x;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = swapPairs(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
