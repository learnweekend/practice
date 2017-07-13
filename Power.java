/* Problem :  Write a function to calculate the power (x ^ y) where y >= 0 in O(long N) time */
public class Power {
  public static void main(String[] args){
    int x = 2;
    int y = -2;
    System.out.println(powerV1(x, y));
    System.out.println(powerV2(x, y));
    System.out.println(powerV3(x, y));
  }
  /* Brute-Force Solution:, Runtime : O(N); Space : O(1) */
  private static long powerV1(int x, int y) {
    if(x == 0) return 0;
    if(y == 0) return 1;
    if(y == 1) return x;
    long result = 1;
    for(int i = 0; i < y; i++) {
      result = result * x;
    }
    return result;
  }
  /* Recursive Solution : Runtime O(log n), space : O(N) */
  private static long powerV2(int x, int y) {
    if(x == 0) return 0;
    if(y == 0) return 1;
    if(y == 1) return x;
    long result = 1;
    result = powerV2(x, y/2);
    if(y % 2 == 0)
      return result * result;
    else
      return x * result * result;
  }
  /* Iterative Solution : Runtime O(log n), space : O(1) */
  private static long powerV3(int x, int y) {
    if(x == 0) return 0;
    if(y == 0) return 1;
    if(y == 1) return x;
    long result = 1;
    long power = x;

    while(y != 0) {
      if( (y & 1) == 1) {
        result *= power;
      }
      y = y >> 1;
      power *= power;
    }
    return result;
  }

}
