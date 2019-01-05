package leetcode;

/**
 * https://leetcode.com/problems/power-of-four/description/
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 */
public class PowerOfFour {
	// Runtime : Log (N)
	public static boolean powerOf4(int number) {
		if (number < 1)
			return false;
		while (number % 4 == 0) {
			number /= 4;
		}
		return number == 1;
	}
	
	// The idea is that power of 4 has one's digit of 4, 6 only and 
	// power of 4 is also a power of 2
	// 4 ^ 0 = 1, 4^2 = 16, 4 ^3 = 64
	public static boolean powerOfFour(int num) {
		int one = num % 10;
		return (num == 1) || (((num & (num - 1)) == 0) && (one == 4 || one == 6)); 
	}

	public static void main(String[] args) {
		System.out.println(powerOf4(28)); //f
		System.out.println(powerOf4(256)); //t
		System.out.println(powerOf4(64)); //t
		System.out.println(powerOf4(27)); //f
	}
}
