/**
  Problem :  Cacluate the Power
*/

public class Power {
	
	/**
	 * Solution 1 : brute-force
	 * runtime : o(N), space : O(1)
	 */
	private static double powV1(double x, int n){
		if(n < 0) return 1/x * powV1(1/x, - n - 1); // when n is negative
		
		double result = 1;
		if(x == 0) return 0;
	    if(n == 0) return 1;
	    if(n == 1) return x;
		
		while(n-- > 0)
			result *= x;
		
		return result;
	}
	
	/**
	 * Solution 2 : efficient
	 * runtime : o(log n), space : O(1)
	 */
	private static double powV2(double x, int n){
		if(n < 0) return 1/x * powV2(1/x, -(n + 1)); // when n is negative
		
		if(x == 0) return 0;
	    if(n == 0) return 1;
	    if(n == 1) return x;
		
		double temp = powV2(x, n/2);
		if(n % 2 == 0) 
			return temp * temp;
		else
			return x * temp * temp;
	}
	
	/* Iterative Solution : Runtime O(log n), space : O(1) */
  
	  private static long powV3(int x, int y) {
		if(y < 0) return -1; // not supported
	    if(x == 0) return 0;
	    if(y == 0) return 1;
	    if(y == 1) return x;
	    long result = 1;
	    long power = x;

	    while(y != 0) {
	      if( (y & 1) == 1) {
	        result = result * power;
	      }
	      y = y >> 1;
	      power = power * power;
	    }
	    return result;
  }

	public static void main(String[] args) {
		System.out.println(powV1(2, -5));
		System.out.println(powV2(2, -5));
		System.out.println(powV3(2, 5));
		System.out.println();
		System.out.println(powV1(3, 4));
		System.out.println(powV2(3, 4));
		System.out.println(powV3(3, 4));
		System.out.println();
		System.out.println(powV1(4, 3));
		System.out.println(powV2(4.0, 3));
		System.out.println(powV3(4, 3));
	}
}
