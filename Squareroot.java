/*
  Problem : Given an Integer (positive or negative), write a function which returns the
  squareroot of a given number
  */
import java.util.*;

public class Squareroot {
  
  /**
	 * Solution 1 : Brute-Force
	 * 1. Start with initial value of i as 1 and result 1.
	 * 2. calculate the result ( i * i) until the result is <= number
	 * runtime : O(N), space : O(1);
	 */
	private static int sqrtV1(int number){
		if(number == 0 || number == 1) // base case.
			return number;
		int i = 1;
		int result = 1;
	  while(result <= number){  // check if result <= number
			if(result == number)
				 return i; // return the square root - perfect square.
			i++;
			result = i * i; 
		}
		return i - 1; // return the floor of the number (for non perfect squares).
	}
	/**
	 * Solution : efficient (binary search)
	 * 1. have start - 0 and end = number.
	 * 2. calculate the mid = start + (end-start)/2
	 * 3. divide the number of calculation based on left or right.
	 * 4. Note : Take the min of (start and end) when not a perfect square.
	 * runtime : O(log n), space : O(1);
	 */
    private static int sqrt(int x){
       int start = 1;
       int end = x;
       while(start <= end) {
            int mid = start + (end - start)/2;
            if(mid  == x/mid) // NOTE: don't use (mid * mid = x)
                return mid;
            if( mid < x/mid)
                start = mid + 1;
            else 
                end = mid - 1;
        }
       return end; // take the minimum of start and end
    } 
 
  /* 
     The following uses a precesion to a given value
      Solution 3: Use divide and concur (binary search) approach to solve this problem. 
      runtime : O(long n), space : O(1)
  */
  private static String squareroot(int number){
    boolean isNegative = false;
    if(number < 0) {
      isNegative = true;
      number = number * -1;
    }
    double start = 0;
    double end = number;
    double mid = (start + end)/2;
    double previousMid = 0;
    double precisionDiff = Math.abs(mid - previousMid);
    double precision = 0.001;
    int count = 0;

    while((mid * mid != number) && precisionDiff > precision) {
      if(mid * mid > number) {
          end = mid;
      } else {
          start = mid;
      }
      previousMid = mid;  // update the previousMid to mid
      mid = (start + end)/2;
      precisionDiff = Math.abs(mid - previousMid);
    }
    return mid + (isNegative == true ? "i" : "");
  }
  
   public static void main(String[] args){
    int number = 1;
    System.out.println("square root of number " + number + " is = " +squareroot(number));
  }

}
