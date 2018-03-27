/*
 * https://leetcode.com/problems/palindrome-number/description/
 * Determine whether an integer is a palindrome. Do this without extra space.
	Some hints:
	Could negative integers be palindromes? (ie, -1)
	If you are thinking of converting the integer to string, note the restriction of using extra space.
	You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
	There is a more generic way of solving this problem.
 */
public class PalindromicNumber {
	
	/* Solution 1:  The solution is similar to Reversing the number, 
	 * but check for number > 0 in while loop to avoid integer overflow.
	 * runtime : O(N), space : O(1)
	 */
	public static boolean isPalindromicNumber(int number){
		if(number < 0) return false;
		if(number < 10) return true;
		if(number != 0 && number % 10 == 0) return false;
		int reversed = 0;
		int temp = number;
		
		while(temp > 0) { // Note : > 0, to avoid integer overflow
			reversed = reversed * 10 + temp % 10;
			temp = temp / 10;
		}
		return reversed == number;
	}
	
	/* Solution 2:  Check for the half number of digits.
	 * runtime : O(N), space : O(1)
	 */
	public static boolean isPalindromicNumberV2(int number){
		if(number < 0) return false;
		if(number < 10) return true;
		if(number != 0 && number % 10 == 0) return false;
		
		int reversed = 0;
		int temp = number;
		while(temp > reversed) { 
			reversed = reversed * 10 + temp % 10;
			if(temp == reversed)  // check both are equal
				return true;
			temp = temp / 10;
		}
		return (temp == reversed);
	}

	public static void main(String[] args) {
		System.out.println(isPalindromicNumber(10));
		System.out.println(isPalindromicNumber(121));
		System.out.println(isPalindromicNumberV2(12421));
	}
}
