
// Given two positive integers, swap them without using "temp" variable
public class SwapWithoutTemp {
  public static void main(String args[]) {
    int a = 10;
    int b = 20;
    swapV1(a, b);
    swapV2(a, b);
  }
  // Solution 1 : Use XOR to swap integers
  private static void swapV1(int x, int y) {
    System.out.println("before swap : x = " + x + ", y = " +y);
    x = x ^ y;   //1010 ^ 10100  = 11110
    y = x ^ y;
    x = x ^ y;
    System.out.println("after  swap : x = " + x + ", y = " +y);
  }
  // Solution 2 : Use Addition
  private static void swapV2(int x, int y) {
    System.out.println("before swap : x = " + x + ", y = " +y);
    x = x + y;
    y = x - y;
    x = x - y;
    System.out.println("after  swap : x = " + x + ", y = " +y);
  }
}
