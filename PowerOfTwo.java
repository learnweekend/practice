package leetcode;

/**
 * Check whether a number is a power product of 2
 * 
 * https://leetcode.com/problems/power-of-two/description/
 *  Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
	
	//When a number is 2 to the power of k (k≥0), there is only one 1 bit in its binary representation. 
	//As discussed above, a statement (n-1)&n removes the only 1 bit in the number if n is 2k. 
	//Therefore, the Boolean value of the statement n != 0 && (n - 1) & n == 0 indicates whether n is 2k.

	public static boolean isPowerOfTwo(int number) {
		number = number & number - 1; 
		if(number == 0)
			return true;
		
		return false;
	}
	
	public static boolean isPowerOf2(int number) {
		if(number <= 0) return false;
		while(number % 2 == 0) {
			number /= 2;
		}
		return number == 1;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(3)); // f
		System.out.println(isPowerOfTwo(4)); //t
		System.out.println(isPowerOfTwo(8)); //t
		System.out.println(isPowerOfTwo(18)); //f
	}
}
