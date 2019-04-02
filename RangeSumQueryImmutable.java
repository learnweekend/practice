package leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change. There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
	//Runtime : O(1) | Space : O(N)
	private int[] cumSum;
	public RangeSumQueryImmutable(int[] array) {
		cumSum = new int[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			cumSum[i + 1] = cumSum[i] + array[i];
		}
	}
	
	public int sumRangeOptimized(int i, int j) {
		return cumSum[j + 1] - cumSum[i];
	}

	/** 
	 * Runtime : O(N), for M queries = O(M * N). | sapce : O(1)
	
		private int[] array;
		public RangeSumQueryImmutable(int[] nums) {
			this.array = nums;
		}
	
		public int sumRange(int i, int j) {
			int sum = 0;
			for (int start = i; start <= j; start++) {
				sum += array[start];
			}
			return sum;
		}
	 */
	
	/**
	 * Runtime : O(N), for M queries = O(M * N) | sapce : O(1)
	 * 
	private Map<String, Integer> sumMap;
	
	public RangeSumQueryImmutable(int[] array) {
		sumMap = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			int sum = 0;
			for(int j = i; j <= array.length - 1; j++) {
				sum += array[j];
				sumMap.put(i+"-"+j, sum);
			}
		}
	 }
	
	public int sumRangeUsingMap(int i, int j) {
		return sumMap.get(i + "-" + j);
	}
	 */
	
	public static void main(String[] args) {
		int[] array = { -2, 0, 3, -5, 2, -1 };
		RangeSumQueryImmutable obj = new RangeSumQueryImmutable(array);
		//System.out.println(obj.sumRange(1, 4)); // 0
		//System.out.println(obj.sumRangeUsingMap(1, 4)); // 0
		System.out.println(obj.sumRangeOptimized(1, 4)); // 0
	}
}
