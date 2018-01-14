package list;

import java.util.Stack;

public class ReverseList {
	
	/*
	 * Solution 0 :  Just print the list in reverse order
	 */
	private static void reverse(Node node) {
		if (node == null)
			return;
		reverse(node.next);
		System.out.print(node.data + "  ");
	}
	
	 /* Solution 1 : Use additional stack and push all nodes to stack
	 *  pop all nodes from stack and form the list
	 *  Runtime : O(N), space : O(1)
	 *  Note : This requires two passes
	 */ 
	private static Node reverseStack(Node node) {
		Stack<Node> stack = new Stack<>();
		// add the elements to the stack
		Node rest = null;
		while(node != null) {
			stack.push(node); // push the current node to stack.
			rest = node.next; // store the link to rest of the list
			node.next = null; // break the list into two parts
			node = rest; 
		}
		
		if(stack.isEmpty()) // if the list is empty
			return null;
		
		//remove the elements from stack and form the list
		Node head = stack.pop();
		Node temp = head;
		while(!stack.isEmpty()) {
			temp.next = stack.pop();
			temp = temp.next;
		}
		return head;
	}
	
	/*  Solution 2 : Use iterative approach with 3 pointers
	 *  Runtime : O(N), space : O(1) for stack
	 */
	private static Node reverseI(Node node) {
		Node next = null;
		Node prev = null;
		Node curr = node;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	/*  Solution 3 : Recursive solution 
	 *  1. Have overloaded helper function to reverse.
	 *  2. call the reverse on the head and pass the prev node as null.
	 *  3. if the node is last node, then return the node;
	 *  4. divide the list into two parts firstNode  and reverse(rest)
	 *  5. call the reverse on second part, join with prev.
	 *   Runtime : O(N), space : O(N) for call stack
	 */
	public static Node reverseR(Node node) {
		return reverseR(node, null);
	}
	
	private static Node reverseR(Node node, Node prev) {
		
		if(node.next == null) {  // base case - last node
			node.next = prev;   // to join the previous list
			return node;  // return the head of the final list
		}
		Node rest = node.next;  // divide the list into two parts
		node.next = prev;  // break the link
		prev = node;
		
		return reverseR(rest, prev);
	}
	
	private static void print(Node node) {
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
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		
		print(head);
		Node reversed = reverseStack(head);
		print(reversed);
	}

}
