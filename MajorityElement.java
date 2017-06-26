/*
 Problem : Majority Element
 Given an array of size n, find the majority element.
 The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
	public static void main(String[] aargs) {
		//int[] a = { 3, 2, 2, 1, 2, 2, 1 };
		//int[] a = {3, 1,1, 2, 2, 1, 2, 2, 1, 1, 1};
		int[] a = {1};
		int majorityElement = findMajorityElement(a);
		System.out.println("majorityElement = " + majorityElement);
	}
	/* Solution : Loop through the array and count the number of elements
	 * Runetime : O(N), Space : O(1)
	 */
	private static int findMajorityElement(int[] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException();
		int majorityElement = arr[0];
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == majorityElement)
				count++; // increment
			else
				count--;
			if (count == 0) {
				majorityElement = arr[i]; // update the majorityElement
				count++; // update count.
			}
		}
		boolean isExists = isMajorityElementExists(arr, majorityElement);
		if (isExists)
			return majorityElement;

		return -1;
	}

	// Helper method to verify majority element
	private static boolean isMajorityElementExists(int[] arr,
			int majorityElement) {
		int count = 0;
		for (int val : arr) {
			if (val == majorityElement)
				count++;
			if (count > arr.length / 2)
				return true;
		}
		return false;
	}
}
