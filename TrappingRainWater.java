/*
  https://leetcode.com/problems/trapping-rain-water/description/
*/

public class TrappingRainWater {

	public static void main(String[] args) {
		
		int[] arr = new int[] { 1, 2, 1, 2};
		
		System.out.println("Volume of Water = " +volumeOfWater(arr)  + " Unit(s)");
	}

	private static int volumeOfWater(int[] height) {
		
		if (height == null || height.length == 0)
			return 0;
		
		int leftMax = 0, rightMax = 0, left = 0, max = 0;
		
		int right = height.length - 1;
		
		while (left < right) {
			leftMax = leftMax > height[left] ? leftMax : height[left];
			rightMax = rightMax > height[right] ? rightMax : height[right];
			max += leftMax < rightMax ? leftMax - height[left++] : rightMax
					- height[right--];
		}
		return max;
	}

}
