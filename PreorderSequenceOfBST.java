package leetcode;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
You may assume each number in the sequence is unique.
Consider the following binary search tree: 
     5
    / \
   2   6
  / \
 1   3

Example 1:
Input: [5,2,6,1,3]
Output: false

Example 2:
Input: [5,2,1,3,6]
Output: true
 */
public class PreorderSequenceOfBST {

	public static boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0)
			return true;

		int[] rootIndex = new int[1];

		return verifyPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, rootIndex);
	}

	private static boolean verifyPreorder(int[] preorder, int min, int max, int[] rootIndex) {

		if (rootIndex[0] == preorder.length) { // basecase
			return true;
		}
		
		if (preorder[rootIndex[0]] < min || preorder[rootIndex[0]] > max) {
			return false;
		}
		
		int rootVal = preorder[rootIndex[0]];
		rootIndex[0] += 1;

		return verifyPreorder(preorder, min, rootVal, rootIndex) || verifyPreorder(preorder, rootVal, max, rootIndex);
	}

	public static void main(String[] args) {
		System.out.println(verifyPreorder(new int[] { 5, 2, 6, 1, 3 })); // false
		System.out.println(verifyPreorder(new int[] { 5, 2, 1, 3, 6 })); // true
	}
}
