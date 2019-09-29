package leetcode;

/**
 * https://leetcode.com/problems/sort-list/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * Input: 4->2->1->3 Output: 1->2->3->4
 * 
 * Example 2:
 * 
 * Input: -1->5->3->4->0  Output: -1->0->3->4->5
 *
 */
public class SortList {

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode middle = getMiddle(head);
		ListNode secondHalf = middle.next;
		middle.next = null; // cut the node

		ListNode sortedLeft = sortList(head);
		ListNode sortedRight = sortList(secondHalf);

		ListNode sortedList = merge(sortedLeft, sortedRight);
		return sortedList;
	}

	private static ListNode getMiddle(ListNode node) {
		if (node == null || node.next == null)
			return node;

		ListNode slow = node;
		ListNode fast = node.next;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private static ListNode merge(ListNode first, ListNode second) {
		if (first == null)
			return second;

		if (second == null)
			return first;

		ListNode merged = null;

		if (first.val < second.val) {
			merged = first;
			merged.next = merge(first.next, second);
		} else {
			merged = second;
			merged.next = merge(first, second.next);
		}
		return merged;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);

		ListNode result = sortList(head);
		while (result != null) {
			System.out.print(result.val + "-");
			result = result.next;
		}
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
}
