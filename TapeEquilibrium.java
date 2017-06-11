/*
Problem :  TapeEquilibrium
A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
For example, consider array A such that:
Input:  int[] arr = {3, 1, 2, 4, 3};
output : 1,
Explanation:
  P = 1, difference = |3 − 10| = 7
  P = 2, difference = |4 − 9| = 5
  P = 3, difference = |6 − 7| = 1
  P = 4, difference = |10 − 3| = 7
*/
public class TapeEquilibrium {
  public static void main(String args[]) {
    //int[] arr = {3, 1, 2, 4, 3}; // 1
    int[] arr = {-1000, 1000}; // 2000
    int minDiff = minDifference(arr);
    System.out.println(minDiff);
  }
 /*
Solution:Calculate the sum of total elements, loop through the array and Calculate the left sum as we move forward.
         calculate right sum ( total - left), take the min abs value of left - right.
         Runtim : O(N) , Space  : O(1)
 */
  private static int minDifference(int[] arr) {
    int totalSum = 0;
    for(int i = 0; i < arr.length; i++) {
      totalSum += arr[i];
    }
    int leftSum = 0;
    int minDiff = Integer.MAX_VALUE;
    for(int i = 0; i < arr.length - 1; i++) { // do not consider the last element.
      leftSum += arr[i];
      int rightSum = totalSum - leftSum;
      int diff = Math.abs(rightSum - leftSum);
      if(diff < minDiff)
          minDiff = diff;
    }
      return minDiff;
  }
}
