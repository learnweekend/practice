public class RemoveNNodesAfterMNodes {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(5);
		head.next.next.next = new Node(9);
		head.next.next.next.next = new Node(10);
		head.next.next.next.next.next = new Node(11);
		print(head);
		Node afterDelete = removeNNodesAfterM(head, 2, 3);
		print(afterDelete);
	}

	public static Node removeNNodesAfterM(Node head, int m, int n) {

		if (head == null)
			return head;

		if (n == 0)
			return head;

		Node curr = head;

		for (int i = 0; i < m - 1; i++) {
			curr = curr.next;
		}

		Node nextNode = null;
		while (n >= 1 && curr.next != null) {
			nextNode = curr.next.next;
			curr.next = nextNode; // curr.next --> 9
			n--;
		}
		return head;
	}

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private static void print(Node n) {
		Node curr = n;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
