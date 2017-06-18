/*
Given an array of integers, find the maximum possible sum you can get from one of its contiguous subarrays.
The subarray from which this sum comes must contain at least 1 element.
Example: For inputArray = [-2, 2, 5, -11, 6], the output should be arrayMaxConsecutiveSum2(inputArray) = 7.
The contiguous subarray that gives the maximum possible sum is [2, 5], with a sum of 7
*/
public  class ArrayMaxConsecutiveSum {
  public static void main(String[] args){
    int[] a = { -2, 2, 5, -11, 6}; // 7
    //int[] a = {11, -2, 1, -4, 5, -3, 2, 2, 2}; // 14
    System.out.println(findMaxConsecutiveSum(a));
    System.out.println(findMaxConsecutiveSumV2(a));
  }
 /* Solution : Assign first element to currSum and maxSum
  Loop through the array and calculate max of (currSum + nextElement, nextElement)
  Calculate the max of (maxSum, currSum) and assign maxSum  if currSum > maxSum
  Runtime : O(N),  Space   : O(1)
 */
  private static int findMaxConsecutiveSum(int[] arr) {
    if(arr == null || arr.length == 0)
        throw new IllegalArgumentException();
    int currSum = arr[0];
    int maxSum = arr[0];

    for(int i = 1; i < arr.length; i++) {   // start at i = 1
      currSum = Math.max(currSum + arr[i], arr[i]);
      maxSum = Math.max(maxSum, currSum);

      if(currSum > maxSum)
        maxSum = currSum;
      }
    return maxSum;
  }

  private static int findMaxConsecutiveSumV2(int[] arr) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;

    for(int i = 0; i < arr.length; i++){
      if(currSum <= 0)
        currSum = arr[i];
      else
        currSum = currSum + arr[i];

      if(currSum > maxSum)
        maxSum = currSum;
    }
    return maxSum;
  }
}
