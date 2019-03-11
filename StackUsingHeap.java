package leetcode;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Implement a stack API using only a heap. A stack implements the following methods:
 * 
 * push(item), which adds an element to the 
 * stack pop(), which removes and returns the most recently added element 
 * (or throws an error if there is nothing on the stack) 
 * Recall that a heap has the following operations:
 * push(item), which adds a new key to the heap pop(), which removes and returns the max value of the heap
 */
public class StackUsingHeap {

	private PriorityQueue<Pair> pqueue;
	private int count;  // To track the insertion order

	public StackUsingHeap() {
		pqueue = new PriorityQueue<Pair>();
		this.count = 0;
	}

	private static class Pair implements Comparable<Pair> {
		private int count;
		private int value;

		public Pair(int count, int value) {
			this.count = count;
			this.value = value;
		}

		// order the queue based on insertion order
		@Override
		public int compareTo(Pair o) {
			return o.count - this.count;
		}
	}

	public void push(int value) {
		pqueue.add(new Pair(++count, value));
	}

	public int pop() {
		if (pqueue.isEmpty()) {
			throw new NoSuchElementException("Stack is Empty");
		}
		count--;
		return pqueue.poll().value;
	}

	public static void main(String[] args) {
		StackUsingHeap stack = new StackUsingHeap();
		stack.push(5);
		stack.push(10);
		stack.push(20);
		stack.push(15);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
