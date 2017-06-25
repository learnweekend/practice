/*
 Problem : Fibonacci series
*/
import java.util.*;
public class Fibonacci {
  public static void main(String[] args){
    int number = 25;
    int[] fSeries = fibonacciV1(number);
    System.out.println("fibonacci series     = " + Arrays.toString(fSeries));
    System.out.println(number + "th Fibonacci value = " +fibonacciV2(number));
  }
 /* Solution : Using memoization
    Runtime : 0(N), Space : O(N)
 */
  private static int[] fibonacciV1(int number) {
    if(number < 1)
      throw new IllegalArgumentException();

    int[] result = new int[number + 1];
    result[0] = 0;
    result[1] = 1;

    for(int i = 2; i <= number; i ++) {  // note i <= number
      result[i] = result[i - 1] + result[i - 2];
    }
    return result;
  }
  /* Solution : Memory optimized Solution
     Runtime : 0(N), Space : O(1)
  */
  private static int fibonacciV2(int number) {
    if(number < 1)
      throw new IllegalArgumentException();
    int prevOne = 0;
    int prevTwo = 1;
    int curr = 1;

    for(int i = 2; i <= number; i++) {
      curr = prevOne + prevTwo;
      prevOne = prevTwo;
      prevTwo = curr;
    }
    return curr;
  }
}
