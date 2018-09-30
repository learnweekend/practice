package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  #281 : https://leetcode.com/problems/zigzag-iterator/description/
 * Given two 1d vectors, implement an iterator to return their elements alternately.

Example:

Input:
v1 = [1,2]
v2 = [3,4,5,6] 

Output: [1,3,2,4,5,6]

Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,3,2,4,5,6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 *
 */

public class ZigZagIterator {
	
	Queue<Iterator<Integer>> queue = new LinkedList<Iterator<Integer>>();
	Iterator<Integer> itr1 = null;
	Iterator<Integer> itr2 = null;
	
	public ZigZagIterator(List<Integer> l1, List<Integer> l2) {
		if(!l1.isEmpty()) {
			itr1 = l1.iterator();
			queue.offer(itr1);
		}
		if(!l2.isEmpty()) {
			itr2 = l2.iterator();
			queue.offer(itr2);
		}
	}
	
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	
	public int next() {
		Iterator<Integer> it = queue.poll();
		int val = it.next();
		if(it.hasNext()) {
			queue.add(it);
		}
		return val;
	}
	
	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		List<Integer> l2 = new LinkedList<>();
		l2.add(11);
		l2.add(22);
		l2.add(33);
		l2.add(44);
		
		ZigZagIterator zigZag  = new ZigZagIterator(l1, l2);
		
		while(zigZag.hasNext() ) {
			System.out.println(zigZag.next());
		}
	}

}
