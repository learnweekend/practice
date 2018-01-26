package all;

import java.util.HashSet;
import java.util.Set;

public class CyclicList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = head.next.next; //new Node(7);
		/*head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = head.next.next; */
		System.out.println(startOfLoopV2(head));
	}
	
	/* Solution 1 using additional memory , runtime O(N), space : O(N)*/
	
	public static boolean startOfLoop(Node node) {
		Set<Node> visited = new HashSet<>();
		Node curr = node;
		while(curr != null) {
			if(visited.contains(curr)) {
				System.out.println("Start of Loop = " + curr.data);
				return true;
			} else {
				visited.add(curr);
			}
			curr = curr.next;
		}
		return false;
	}
	
	/* solution 2: runtime O(N) and space : O(1) */
	
	public static boolean startOfLoopV2(Node node) {
		Node slow = node;
		Node fast = node.next;
		
		while(fast != null && fast.next != null) { //check if first node has cycle
			if(slow == fast) {
				fast = node;
				slow = slow.next;
				while(true) {
					if(slow == fast) {
						System.out.println("loop is at = " + fast.data);
						break;
					}
					fast = fast.next;
					slow = slow.next;
				}
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
	
	private static class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
