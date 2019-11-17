package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar
 * is 1, find the area of largest rectangle in the histogram.
 * 
 * Input : [2,1,5,6,2,3] Output : 10
 * Runtime : O(N), Space : O(N)
 */
public class LargestRectangleHistogram {

	public static int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Integer> indexStack = new Stack<>();
		int index;
		for (index = 0; index < heights.length;) {
			if (indexStack.isEmpty() || heights[indexStack.peek()] <= heights[index]) {
				indexStack.push(index++);
			} else {
				maxArea = calculateArea(heights, maxArea, indexStack, index);
			}
		}
		while (!indexStack.isEmpty()) {
			maxArea = calculateArea(heights, maxArea, indexStack, index);
		}
		return maxArea;
	}

	/**
	 * If the indexStack is empty, the area = index * input[top];
	 * If not empty, then area = heights[top] * (index - indexStack.peek() - 1);
	 */
	private static int calculateArea(int[] heights, int maxArea, Stack<Integer> indexStack, int index) {
		int area = 0;
		int top = indexStack.pop();
		
		if (indexStack.isEmpty()) {
			area = index * heights[top];
		} else {
			area =  heights[top] * (index - indexStack.peek() - 1);
		}
		maxArea = Math.max(area, maxArea);
		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 })); // 10
	}

}
