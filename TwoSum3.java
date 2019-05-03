package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * 
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * 
 * add - Add the number to an internal data structure. find - Find if there exists any pair of
 * numbers which sum is equal to the value.
 * 
 * Example 1:
 * 
 * add(1); add(3); add(5); find(4) -> true find(7) -> false
 * 
 * Example 2:
 * 
 * add(3); add(1); add(2); find(3) -> true find(6) -> false
 *
 */
public class TwoSum3 {

	private Map<Integer, Integer> map = null; // To store the element and number of occurances

	public TwoSum3() {
		map = new HashMap<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		if (map.containsKey(number)) {
			map.put(number, map.get(number) + 1);
		} else {
			map.put(number, 1);
		}
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		for (Integer key : map.keySet()) {
			int num2 = value - key;
			if ((key == num2 && map.get(key) > 1) || (key != num2 && map.containsKey(num2))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TwoSum3 obj = new TwoSum3();
		obj.add(1);
		obj.add(3);
		obj.add(5);
		System.out.println(obj.find(4));
	}
}
