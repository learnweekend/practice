package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-bounded-blocking-queue/
 * 
 * Implement a thread safe bounded blocking queue that has the following methods:

    BoundedBlockingQueue(int capacity) The constructor initializes the queue with a maximum capacity.
    void enqueue(int element) Adds an element to the front of the queue. If the queue is full, 
    the calling thread is blocked until the queue is no longer full.
    int dequeue() Returns the element at the rear of the queue and removes it. If the queue is empty, 
    the calling thread is blocked until the queue is no longer empty.
    int size() Returns the number of elements currently in the queue.

Your implementation will be tested using multiple threads at the same time. 
Each thread will either be a producer thread that only makes calls to the enqueue method or a consumer thread 
that only makes calls to the dequeue method. The size method will be called after every test case.
 *
 */
public class BlockingQueueList<T> {

	private List<T> queue;
	private int capacity;
	private Object lock = new Object();

	public BlockingQueueList(int capacity) {
		this.capacity = capacity;
		this.queue = new LinkedList<T>();
	}

	public void enqueue(T item) throws InterruptedException {
		synchronized (lock) {
			while (queue.size() >= capacity) {
				lock.wait();
			}
			queue.add(item);
			lock.notifyAll();
		}
	}

	public T dequeue() throws InterruptedException {
		synchronized (lock) {
			while (queue.size() < 1) {
				lock.wait();
			}
			T item = queue.remove(0);
			lock.notifyAll();
			return item;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		BlockingQueueList<Integer> blockingQueue = new BlockingQueueList<Integer>(1000);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						System.out.println("........enqueued ........ : " + i);
						blockingQueue.enqueue(i);
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Integer item = blockingQueue.dequeue();
						System.out.println("dequeued : " + item);
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t2.start();

		t1.join();
		t2.join();
		System.out.println(System.currentTimeMillis()-start);
	}
}
