package leetcode;

/**
 * https://leetcode.com/problems/design-circular-queue/
 * 
 * Design your implementation of the circular queue. The circular queue is a
 * linear data structure in which the operations are performed based on FIFO
 * (First In First Out) principle and the last position is connected back to the
 * first position to make a circle. It is also called "Ring Buffer".
 * 
 * One of the benefits of the circular queue is that we can make use of the
 * spaces in front of the queue. In a normal queue, once the queue becomes full,
 * we cannot insert the next element even if there is a space in front of the
 * queue. But using the circular queue, we can use the space to store new
 * values.
 * 
 * Your implementation should support following operations:
 * 
 * MyCircularQueue(k): Constructor, set the size of the queue to be k. Front:
 * Get the front item from the queue. If the queue is empty, return -1. Rear:
 * Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the
 * operation is successful. deQueue(): Delete an element from the circular
 * queue. Return true if the operation is successful. isEmpty(): Checks whether
 * the circular queue is empty or not. isFull(): Checks whether the circular
 * queue is full or not.
 */
public class CircularQueue {

	private int[] array;
	private int head;
	private int tail;

	/** Initialize your data structure here. Set the size of the queue to be k. */

	public CircularQueue(int k) {
		array = new int[k];
		head = -1;
		tail = -1;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}

		tail = (tail + 1) % array.length;
		array[tail] = value;

		if (head == -1) {
			head = tail;
		}
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		
		//int value = array[head];

		if (head == tail) {
			head = -1;
		} else {
			head = (head + 1) % array.length;
		}
		
		return true;  // return value;
	}

	/** Get the front item from the queue. */
	public int Front() {
		if (!isEmpty()) {
			return array[head];
		}
		return -1;
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if (!isEmpty()) {
			return array[tail];
		}
		return -1;
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return head == -1;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		int nextIndex = (tail + 1) % array.length;
		return nextIndex == head;
	}
}
