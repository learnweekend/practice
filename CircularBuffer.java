package arrays;

/*
 *  Implement Circular buffer (array) with the following operations.
 *  enque(data), deque(), Assume the default empty slot value = 0 
 */
import java.util.NoSuchElementException;

public class CircularBuffer {
	
	private int front;
	private int rear;
	private int capacity;
	private int[] buffer;
	
	public CircularBuffer(int capacity) {
		this.capacity = capacity;
		this.buffer = new int[capacity];
		this.front = -1;
		this.rear = -1;
	}
	
	/* Note :  Increment the rear pointer.
	 * 1. Check if buffer is FULL  ====>  (front == 0 && rear == capacity-1 || (rear = front-1)
	 * 2. Check if buffer is EMPTY ====> front == -1
	 * 3. Check if buffer has Empty Slots (rounded)  ====>  (rear == capacity - 1) && (front != 0)
	 * 4. increment the rear and fill the rear index with value.
	 */
	public void enque(int data) {
		// check if the buffer(queue) is full
		if((front == 0 && rear == capacity - 1 || (rear == front - 1))) {
			System.out.println("Buffer is Full !");
			return;
		}
		else if(front == -1) {  // check if its empty, then insert as first element
			front = rear = 0;  // update front and rear pointers.
			buffer[rear] = data; 
		}
		else if(rear == capacity - 1 && front != 0) {  // check if buffer has empty spaces
			rear = 0;  // rounded
			buffer[rear] = data;
		}
		else {
			buffer[++rear] = data;  // normal case.
		}
	}
	
	/* Note : Increment the front pointer.
	 * 1. Check if buffer is Empty  ====> front == -1
	 * 2. read the data.
	 * 3. Check if the buffer has only one element (front == rear), then deque makes front == rear == -1
	 * 4. Check if removing the last index (front == capacity-1)
	 * 5. increment the front pointer.
	 */
	public int deque() {
		
		if(front == -1) {  // check if buffer is empty
			throw new NoSuchElementException();
		}
		
		int data = buffer[front];
		buffer[front] = 0;   // mark the array slot to invalid (-1);
		
		if(front == rear) { //check if buffer has only one element
			front = -1;
			rear = -1;
		} 
		else if(front == capacity - 1) { // check if removing the last index
			front = 0;
		}
		else    // this is normal case, move the front forward.
			front++;
		
		return data;
	}
	
	public void printQ() {
		for(int i = 0; i < buffer.length; i++) {
			System.out.print(buffer[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CircularBuffer queue = new CircularBuffer(4);
		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.deque();
		queue.deque();
		queue.printQ();
		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.printQ();
		queue.deque();
	}

}
