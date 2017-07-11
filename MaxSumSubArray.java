import java.util.*;

public class MaxSumSubArray {
  public static void main(String args[]) {
    //int[] a = {1,-3,2,5,-8};
    //int[] a = {-2, -3, 4, -1, -2, 1, 5, -3 }; // 7
    int[] a = {-2, -3, 4, -1, -2, 1, 8, -3};
    //int[] a = {-15, -2, -3, -4, -5, -10, -100};
    //int[] a = {-6,2,-3,-4,-1,-5,-5}; //2
    System.out.println("array    = " + Arrays.toString(a));
    int[] subArray = findSubArrayWithMaximumSum(a);
    System.out.println("subarray = " + Arrays.toString(subArray));
    System.out.println("max sum,solution1 = " +findMaximumSumSubArrayV1(a));
    System.out.println("max sum,solution2 = " +findMaximumSumSubArrayV2(a));
  }
  /**
  Solution 1: Loop through the array and maintain the current sum and max sum seen so far.
  Runtime   : O(N)
  Space     : O(1)
  */
  private static int findMaximumSumSubArrayV1(int[] arr) {
    int maximumSum = arr[0];
    int currentSum = arr[0];
    int N = arr.length;
    for(int i = 1; i < N; i++) {
      currentSum = Math.max(currentSum + arr[i], arr[i]);
      maximumSum = Math.max(maximumSum, currentSum);
    }
    return maximumSum;
  }
  /**
  Solution 2: Loop through the array and maintain the current sum and max sum seen so far.
  Runtime   : O(N)
  Space     : O(1)
  */
  private static int findMaximumSumSubArrayV2(int[] arr) {
    int maxSum = 0;
    int currSum = 0;
    for(int i = 0; i < arr.length; i++) {
      currSum += arr[i];
      if(currSum < 0) // reset the currSum to '0' when it is -ve.
        currSum = 0;
      else if(currSum > maxSum) { // update the maxsum when currSum in larger
        maxSum = currSum;
      }
    }
    return maxSum;
  }
/**
  This function calculate the maximum sum and also the array start and end indices
  for which the maxSum is arrived.
  sub array which shows the maxsum.
  */
  private static int[] findSubArrayWithMaximumSum(int[] arr) {
    int N = arr.length;
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int currentStartIndex = 0;
    int maxStartIndex = 0;
    int maxEndIndex = 0;

    for(int i = 0; i < N; i++){
      currentSum = currentSum + arr[i];
      if(currentSum < 0) {
        currentSum = 0; // reset the currentSum to '0'
        currentStartIndex = i + 1; //update currentStartIndex when currentSum -ve.
      } else if(currentSum > maxSum){ // only check when currentSum is positive.
        maxSum = currentSum; //update max sum
        maxStartIndex = currentStartIndex; //update maxStartIndex
        maxEndIndex = i; // update the max index when maxSum is updated.
      }
    }
    System.out.println("max sum  = " + maxSum);
    //System.out.println("start    = " + maxStartIndex + ", end = " + maxEndIndex);
    return Arrays.copyOfRange(arr, maxStartIndex, maxEndIndex + 1);
  }
}
