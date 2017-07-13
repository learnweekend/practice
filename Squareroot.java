/*
  Problem : Given an Integer (positive or negative), write a function which returns the
  squareroot of a given number
  */
import java.util.*;

public class Squareroot {
  public static void main(String[] args){
    int number = 1;
    System.out.println("square root of number " + number + " is = " +squareroot(number));
  }
  /* Solution 1: Use divide and concur (binary search) approach to solve this problem. */
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
    //double precision = 0.001;
    int count = 0;

    while(mid * mid != number) { // && precisionDiff > precision) {
      System.out.println(++count);
      if(mid * mid > number) {
          end = mid;
      } else {
          start = mid;
      }
      previousMid = mid;  // update the previousMid to mid
      mid = (start + end)/2;
      //precisionDiff = Math.abs(mid - previousMid);
    }
    return mid + (isNegative == true ? "i" : "");
  }

}
