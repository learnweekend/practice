package leetcode;

public class NthNodeFromLast {

	public static ListNode getNthNodeFromLast(ListNode head, int n) {
		if (head == null || n < 1)
			return null;

		ListNode back = head;

		while (n-- > 0)
			head = head.next;

		while (head != null) {
			head = head.next;
			back = back.next;
		}
		return back;
	}

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int val) {
			this.data = val;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);

		System.out.println(getNthNodeFromLast(head, 3).data); // 7
		/*System.out.println(getNthNodeFromLast(head, 2).data); // 6
		System.out.println(getNthNodeFromLast(head, 3).data); // 5
		System.out.println(getNthNodeFromLast(head, 4).data); // 4
		System.out.println(getNthNodeFromLast(head, 7).data); // 1
		// System.out.println(getNthNodeFromLast(head, 8).data); // 7*/
		
		System.out.println(head.data);
	}
}
