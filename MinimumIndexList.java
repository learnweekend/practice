package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * #599 https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 * 
 *  Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:

Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 *
 */

public class MinimumIndexList {

	public static String[] findRestaurant(String[] array1, String[] array2) {
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> resultMap = new HashMap<>();

		for (int i = 0; i < array1.length; i++) {
			map.put(array1[i], i);
		}

		String prevKey = null; // To track the previous Key in the result Map.

		for (int i = 0; i < array2.length; i++) {
			String str = array2[i];
			if (map.containsKey(str)) {
				int indexSum = map.get(str) + i;
				if (resultMap.isEmpty()) {
					resultMap.put(str, indexSum);
					prevKey = str;
				} else {
					int prevIndexSum = resultMap.get(prevKey);
					if (indexSum < prevIndexSum) {
						resultMap.put(str, indexSum);
						resultMap.remove(prevKey);
						prevKey = str;
					} else if (indexSum == resultMap.get(prevKey)) { // if there is a tie
						resultMap.put(str, indexSum);
					}
				}
			}
		}
		return resultMap.keySet().toArray(new String[map.size()]);
	}

	public static void main(String[] args) {

		// String[] array1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		// String[] array2 = {"KFC","Burger King","Tapioca Express","Shogun"};

		// String[] array1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		// String[] array2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

		String[] array1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] array2 = { "KFC", "Shogun", "Burger King" };

		String[] result = findRestaurant(array1, array2);
		System.out.println(Arrays.toString(result));
	}
}
