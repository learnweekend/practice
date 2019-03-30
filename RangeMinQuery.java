package leetcode;

/**
 * Given a array of integer and a range of indices
 * find the min of a given range.
 * The query can be called many times, hence optimize the query
 */
public class RangeMinQuery {
	
	/**
	 * Bruteforce solution 1 - use for loop and do leanear search and get the min.
	 *  Runtime : O(N), for M queries = O(M * N).
	 */
	
	/**
	 * Brute-foce solution 2
	 *  Use precpompution and Construct a 2D grid with minimum value of a given range.
	 *  and return the query in O(1) time.
	 *  Runtime : O(N ^ 2) to construct the 2D array
	 *  Space :   O(N ^ 2)
	 *  Queries can be answered in O(1).
	 */

	private int[] segmentTree = null;
	
	/**
	 * Solution 3 :  Use segment trees
	 * Runtime : O(N) for segment tree constuction
	 * O(log N) for finding the min in a given range.
	 * Sapce : O(N).
	 */

	public int getMinRange(int[] array, int startPosition, int endPosition) {
		if(startPosition < 0 || endPosition > array.length - 1)
			throw new IllegalArgumentException("start or end positions cannot be out of range");
		
		if (segmentTree == null) {
			int segmentTreeSize = getTreeSize(array.length);
			segmentTree = new int[segmentTreeSize];
			buildSegmentTree(array, 0, array.length - 1, 0);
		}
		return getMinRange(startPosition, endPosition, 0, array.length - 1, 0);
	}
	
	private int getMinRange(int queryLow, int queryHigh, int low, int high, int position) {
		
		if(queryLow <= low && queryHigh >= high) {  // Total overlap
			return segmentTree[position];
		}
		
		if(queryLow > high || queryHigh < low) {  // no overlap, then return max value
			return Integer.MAX_VALUE;
		}
		
		int mid = (low + high)/2;
		
		return Math.min(
					getMinRange(queryLow, queryHigh, low, mid, 2 * position + 1),
					getMinRange(queryLow, queryHigh, mid + 1, high, 2 * position + 2)
				);
	}

	private void buildSegmentTree(int[] array, int low, int high, int position) {
		if (low == high) {
			segmentTree[position] = array[low];
			return;
		}
		int mid = (low + high) / 2;
		buildSegmentTree(array, low, mid, 2 * position + 1);
		buildSegmentTree(array, mid + 1, high, 2 * position + 2);
		segmentTree[position] = Math.min(segmentTree[2 * position + 1], segmentTree[2 * position + 2]);
	}
	
	private static int getTreeSize(int length) {
		if(isPowerOf2(length)) {
			return length * 2 - 1;
		}
		int value = 1;
		while (value <= length) {
			value = value << 1;
		}
		return (value * 2 - 1);
	}
	
	public static boolean isPowerOf2(int number) {
		number = number & number - 1; 
		if(number == 0)
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		int[] array = { -1, 2, 4, 0 };
		RangeMinQuery rmq = new RangeMinQuery();
		System.out.println(rmq.getMinRange(array, 0, 2)); //-1
		System.out.println(rmq.getMinRange(array, 0, 3)); //-1
		System.out.println(rmq.getMinRange(array, 1, 2)); // 2
		System.out.println(rmq.getMinRange(array, 1, 3)); // 0
	}
}
