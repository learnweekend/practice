package leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * 
 * #12 : This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, 
write a function that returns the number of unique ways you can climb the staircase. 
The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:
    1, 1, 1, 1
    2, 1, 1
    1, 2, 1
    1, 1, 2
    2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a 
set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 *
 */
public class ClimbingStaircase {
	
	/**
	 * Recursion with Memoization Runtime : O(2 ^ N) | Space : O(N)
	 */
	public static int climbStairsRecursion(int n) {
		if(n == 0 || n == 1) 
			return 1;
		return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
	}
	/**
	 * Recursion with Memoization Runtime : O(N) | Space : O(N)
	 */
	public static int climbStairs(int n) {
		if (n <= 1)
			return n;
		int[] cache = new int[n];
		cache[0] = 1;
		cache[1] = 2;
		if (cache[n - 1] > 0) {
			return cache[n - 1];
		}
		for (int i = 2; i < n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}
		return cache[n - 1];
	}

	/**
	 * Recursion with Memoization Runtime : O(N) | Space : O(N)
	 */
	public static int climbStairsMemo(int n) {
		int[] cache = new int[n + 1];
		cache[0] = 1;
		cache[1] = 1;
		return climbStairsRecursion(n, cache);
	}

	public static int climbStairsRecursion(int n, int[] cache) {
		if (cache[n] != 0) {
			return cache[n];
		}
		cache[n] = climbStairsRecursion(n - 1, cache) + climbStairsRecursion(n - 2, cache);
		return cache[n];
	}

	/**
	 * Recursion with Memoization Runtime : O(N) | Space : O(1)
	 */
	public static int climbStairsFibonacci(int n) {
		if (n <= 1)
			return n;

		int first = 1;
		int second = 2;

		for (int i = 3; i <= n; i++) {
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(5));
		System.out.println(climbStairsRecursion(5));
		System.out.println(climbStairsFibonacci(5));
	}
}
