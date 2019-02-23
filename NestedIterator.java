package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Input: [[1,1],2,[1,1]] Output: [1,1,2,1,1] Explanation: By calling next repeatedly until hasNext
 * returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * Input: [1,[4,[6]]] Output: [1,4,6] Explanation: By calling next repeatedly until hasNext returns
 * false, the order of elements returned by next should be: [1,4,6].
 */
public class NestedIterator implements Iterator<Integer> {

	private List<Integer> list = null; // to hold the final list of values
	private Iterator<Integer> iterator = null;

	public NestedIterator(List<NestedInteger> nestedList) {
		list = new LinkedList<Integer>();
		flattenList(nestedList);
		iterator = list.iterator();
	}

	private void flattenList(List<NestedInteger> nestedList) {
		for (NestedInteger nested : nestedList) {
			if (nested.isInteger()) {
				list.add(nested.getInteger());
			} else {
				flattenList(nested.getList());
			}
		}
	}

	@Override
	public Integer next() {
		return iterator.next();
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such: NestedIterator i = new
 * NestedIterator(nestedList); while (i.hasNext()) v[f()] = i.next();
 */