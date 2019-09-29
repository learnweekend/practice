package leetcode;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/design-hit-counter/
 * 
 * Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) 
and you may assume that calls are being made to the system in chronological order 
(ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 

Follow up:
What if the number of hits per second could be very large? Does your design scale?
 *
 */
public class HitCounter {

	/* solution 1
	private Queue<Integer> queue;

	public HitCounter() {
		queue = new LinkedList<Integer>();
	}

	public void hit(int timestamp) {
		queue.add(timestamp);
	}

	public int getHits(int timestamp) {
		int startRange = (timestamp - 300);
		while (queue.peek() <= startRange) {
			queue.poll();
		}
		return queue.size();
	}
	*/
	
	 TreeMap<Integer, Integer> map;

    public HitCounter() {
        map = new TreeMap<>();
        map.put(0, 0);
    }
    
    public void hit(int timestamp) {
        map.put(timestamp, map.get(map.lastKey()) + 1);
    }
    
    public int getHits(int timestamp) {
        return map.floorKey(timestamp - 300) == null ? map.get(map.floorKey(timestamp)) : map.get(map.floorKey(timestamp)) - map.get(map.floorKey(timestamp - 300));
    }
	 
	public static void main(String[] args) {
		HitCounter hitCounter = new HitCounter();
		hitCounter.hit(1);
		hitCounter.hit(2);
		hitCounter.hit(3);
		System.out.println(hitCounter.getHits(4)); // 3
		hitCounter.hit(300);
		System.out.println(hitCounter.getHits(300)); // 4
		System.out.println(hitCounter.getHits(301)); // 3
	}
}
