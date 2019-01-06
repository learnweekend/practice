package leetcode;

/**
 * https://leetcode.com/problems/add-digits/description/
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
  For example:
  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
  Follow up:
  Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
	/*
	 *  Brute force solution 1 : 
	 *  1. return the number if number < 10
	 *  2. add the digits of a given number.
	 *  3. repeat the above step 2 until the number is < 10
	 *  Runtime : O(N)
	 */
	public static int addDigits(int num) {
		if (num < 10) // base case, return if num < 10
			return num;
		while (num >= 10) { // repeat if num >= 10
			num = getSumOfDigits(num);
		}
		return num;
	}
	/*
	 *  Utility method to add the digits given integer number 
	 */
	private static int getSumOfDigits(int number) {
		int result = 0;
		if (number < 10)
			return number;

		while (number != 0) {
			int remainder = number % 10;
			result += remainder;
			number = number / 10;
		}
		return result;
	}
	/**
	 *  Solution 2:  
	 *  1. if the num is zero then return 0
	 *  2. if num % 9 == 0 then return 9 else return num % 9
	 *  Runtime : O(1), Space : O(1)
	 */
	public static int addDigitsV1(int num) {
		if (num == 0)
			return 0;
		return num % 9 == 0 ? 9 : num % 9;
	}
	/**
	 *  Solution 3:
	 *  1. return the number if number < 10
	 *  2. add the digits of a given number.
	 *  3. repeat the above step 2 until the number is < 10
	 *  Runtime : O(1)
	 */
	public static int addDigitsV2(int num) {
		return 1 + (num - 1) % 9;
	}

	public static void main(String[] args) {
		System.out.println("Solution -------1---------");
		System.out.println(addDigits(1234)); //1
		System.out.println(addDigits(65763));//9
		System.out.println(addDigits(62593706));//2
		System.out.println(addDigits(715380160));//4
		System.out.println(addDigits(24725)); //2
		
		System.out.println("Solution -------v1---------");
		System.out.println(addDigitsV1(1234)); //1
		System.out.println(addDigitsV1(65763));//9
		System.out.println(addDigitsV1(62593706));//2
		System.out.println(addDigitsV1(715380160));//4
		System.out.println(addDigitsV1(24725)); //2
		
		System.out.println("Solution -------v2---------");
		System.out.println(addDigitsV2(1234)); //1
		System.out.println(addDigitsV2(65763));//9
		System.out.println(addDigitsV2(62593706));//2
		System.out.println(addDigitsV2(715380160));//4
		System.out.println(addDigitsV2(24725)); //2
	}
}
