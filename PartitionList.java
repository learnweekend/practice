package interviewcamp;
/**
 * https://leetcode.com/problems/partition-list/description/

	Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	You should preserve the original relative order of the nodes in each of the two partitions.
	Example:
	Input: head = 1->4->3->2->5->2, x = 3
	Output: 1->2->2->4->3->5
 */
public class PartitionList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(4);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(2);
		print(head);
		int pivotValue = 3;
		Node list = partitionList(head, pivotValue);
		print(list);
	}
	
	/* Solution : Have two separate pointers with dummy nodes, one points to less than pivot value and 
	 * another points to greater or equal to pivot value.
	 * traverse the list and check the value and assign the next pointers accordingly.
	 * after completion of the list, merge two lists and return the head which references lesser values.
	 * Runtime : O(N), 
	 */
	public static Node partitionList(Node head, int pivotVal) {

		Node curr = head;
		Node less = new Node(0);
		Node currLess = less;

		Node gt = new Node(0);
		Node currGt = gt;

		while (curr != null) {
			if (curr.data < pivotVal) {
				currLess.next = curr;
				curr = curr.next;
				currLess = currLess.next;
				currLess.next = null;
			} else {
				currGt.next = curr;
				curr = curr.next;
				currGt = currGt.next;
				currGt.next = null;
			}
		}
		currLess.next = gt.next;
		return less.next;
	}
	
	public static void print(Node node) {
		Node curr = node;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}

}
