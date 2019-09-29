package leetcode;

import java.util.ArrayList;
import java.util.List;

 /**
  * https://leetcode.com/problems/factor-combinations/
  * 
  * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.

Write a function that takes an integer n and return all possible combinations of its factors.

Note:

    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.

Example 1:

Input: 1
Output: []

Example 2:

Input: 37
Output:[]

Example 3:

Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

Example 4:

Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
  *
  */
public class Factors {

	public static void main(String[] args) {
		System.out.println(getFactors(12));
	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> factors = new ArrayList<>();
		dfs(factors, new ArrayList<>(), n);
		return factors;
	}

	public static void dfs(final List<List<Integer>> factors, final List<Integer> factor, int n) {
		if (n == 1)
			return;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0 && i >= (factor.isEmpty() ? 1 : factor.get(factor.size() - 1))) {
				List<Integer> copy = new ArrayList<>(factor);
				copy.add(i);
				copy.add(n / i);
				factors.add(copy);
				factor.add(i);
				dfs(factors, factor, n / i);
				factor.remove(factor.size() - 1);
			}
		}
	}
}
