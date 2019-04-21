package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game/
 * 
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Example 1:
 * Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to the
 * last index.
 * Example 2:
 * Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
	/**
	 * Solution 1: Recursion : Runtime : O( 2 ^ N), Sapce : O(N)
	 */
	public static boolean canJump(int[] nums) {
		return canJump(nums, 0);
	}

	private static boolean canJump(int[] array, int position) {
		if (position >= array.length - 1)
			return true;
		int maxJumps = Math.min(position + array[position], array.length - 1);  // take min
		for (int i = maxJumps; i > position; i--)
			if (canJump(array, i))
				return true;
		return false;
	}
	
	/**
	 * Solution 2: Recursion with Memo: Runtime : O(N ^ 2), Sapce : O(N)
	 */
	private static IndexStatus[] cache;
	
	public static boolean canJumpRecursionMemo(int[] nums) {
		cache = new IndexStatus[nums.length];
		Arrays.fill(cache, IndexStatus.UNKNOWN);
		cache[nums.length - 1] = IndexStatus.GOOD;
		return canJumpRecursionMemo(nums, 0);
	}

	private static boolean canJumpRecursionMemo(int[] array, int position) {
		if (cache[position] != IndexStatus.UNKNOWN) {
			return cache[position] == IndexStatus.GOOD ? true : false;
		}
		
		int maxJumps = Math.min(position + array[position], array.length - 1);  // Note : Take Min

		for (int i = position + 1; i <= maxJumps; i++)
			if (canJumpRecursionMemo(array, i)) {
				cache[position] = IndexStatus.GOOD;
				return true;
			}
		return false;
	}
	
	/**
	 * Solution 3: DP: Runtime : O(N ^ 2), Sapce : O(N)
	 */
	public static boolean canJumpDP(int[] nums) {
		IndexStatus[] cache = new IndexStatus[nums.length];
		Arrays.fill(cache, IndexStatus.UNKNOWN);
		cache[nums.length - 1] = IndexStatus.GOOD;
		
		for(int i = nums.length - 2; i >= 0; i--) {
			int maxJumps = Math.min(i + nums[i], nums.length - 1);
			for(int j = i + 1; j <= maxJumps; j++) {
				if(cache[j] == IndexStatus.GOOD) {
					cache[i] = IndexStatus.GOOD;
					break;
				}
			}
		}
		return cache[0] == IndexStatus.GOOD;
	}
	
	public enum IndexStatus {
		GOOD, BAD, UNKNOWN
	}
	
	/**
	 * Solution 4 : Greedy approach, Runtime : O(N), Space : O(1)
	 */
	public static boolean canJumpGreedy(int[] nums) {
		int prevValidPosition = nums.length - 1;
		
		for(int i = nums.length - 2; i >= 0; i--) 
			if(i + nums[i] >= prevValidPosition) 
				prevValidPosition = i;
		
		return prevValidPosition == 0;
	}

	public static void main(String[] args) {
		System.out.println(canJumpGreedy(new int[] {2,3,1,1,4}));  // true
		System.out.println(canJumpGreedy(new int[] {3,2,1,0,4}));  // false
	}
}
