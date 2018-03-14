package com.leetcode;
/**
 * https://leetcode.com/problems/plus-one/description/
 */
import java.util.Arrays;

public class PlusOne {
	/**
	 * Solution 1. if the input is empty or null, add one and return
	 * 2. check, if the last digit != 9, then add one to last digit and update the last digit and return the array
	 * 3. else move forward, add carry to 1 and add it to last digit.
	 * 4. Take the modulo and update the digits value;
	 * 5. update the carry value;
	 */
	
	public static int[] plusOne(int[] digits) {
		
		if(digits == null || digits.length == 0)
			return new int[] {1};
		
		if(digits[digits.length - 1] != 9) {
			digits[digits.length - 1] = digits[digits.length - 1] + 1;
			return digits;
		}
		int carry = 1;
		for(int i = digits.length - 1; i >= 0; i--) {
			int value = digits[i] + carry;
			digits[i] = value % 10;
			carry = value >= 10 ? 1 : 0;
		}
		if(carry == 1) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] digits = {1, 0, 0, 0};
		System.out.println(Arrays.toString(plusOne(digits))); // 1001
		System.out.println(Arrays.toString(plusOne(new int[] {1, 4, 5, 6}))); //1457
		System.out.println(Arrays.toString(plusOne(new int[] {1, 0, 9, 9}))); //1100
		System.out.println(Arrays.toString(plusOne(new int[] {9,9,9,9}))); // 10000
	}

}
