package leetcode;

/**
 * https://leetcode.com/problems/flatten-2d-vector/description/
 * 
 * Design and implement an iterator to flatten a 2d vector. It should support the following
 * operations: next and hasNext. Example:
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * iterator.next();      // return 1 
 * iterator.next();      // return 2 
 * iterator.next();      // return 3
 * iterator.hasNext();   // return true 
 * iterator.hasNext();   // return true 
 * iterator.next();      // return 4
 * iterator.hasNext();   // return false
 */
public class Flatten2DVector {

	private int[][] vector = null;
	private int rowIndex;
	private int colIndex;

	public Flatten2DVector(int[][] v) {
		this.vector = v;
		this.rowIndex = 0;
		this.colIndex = 0;
	}

	public int next() {
		if (hasNext()) {
			int val = vector[rowIndex][colIndex];
			colIndex++;
			return val;
		}
		return -1;
	}

	public boolean hasNext() {
		if (rowIndex >= vector.length)
			return false;

		if (colIndex >= vector[rowIndex].length) {
			rowIndex++;
			colIndex = 0;
			return hasNext();
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] twoDVector = {{1,2},{3},{4}};
		Flatten2DVector obj = new Flatten2DVector(twoDVector);
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
	}
}
