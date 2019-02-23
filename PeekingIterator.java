package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/peeking-iterator/description/
 *  Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the
 * peek() operation -- it essentially peek() at the element that will be returned by the next call
 * to next(). Example: Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * 
 * Call next() gets you 1, the first element in the list. Now you call peek() and it returns 2, the
 * next element. Calling next() after that still return 2. You call next() the final time and it
 * returns 3, the last element. Calling hasNext() after that should return false.
 * 
 * Follow up: How would you extend your design to be generic and work with all types, not just
 * integer?
 */
class PeekingIterator implements Iterator<Integer> {

	private Integer peek;
	private Iterator<Integer> itr;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.itr = iterator;
		peek = itr.next();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer value = peek;

		if (itr.hasNext()) {
			peek = itr.next();
		} else {
			peek = null;
		}
		return value;
	}

	@Override
	public boolean hasNext() {
		return peek != null;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
		PeekingIterator peekItr = new PeekingIterator(list.iterator());
		
		System.out.println(peekItr.hasNext()); // true
		System.out.println(peekItr.peek());  	// 1
		System.out.println(peekItr.peek()); 		// 1
		System.out.println(peekItr.next()); 		// 1
		System.out.println(peekItr.next()); 		// 2
		System.out.println(peekItr.peek()); 		// 3
		System.out.println(peekItr.peek()); 		// 3
		System.out.println(peekItr.next()); 		// 3
		System.out.println(peekItr.hasNext());  // true
		System.out.println(peekItr.peek());   	 // 4
		System.out.println(peekItr.hasNext());  // true
		System.out.println(peekItr.next());     // 4
		System.out.println(peekItr.hasNext());  // false
	}
}