/*
  Problem : ThreeSum
  Given an integer array (unsorted), return indices of three elements
  such that sum of three elements = 0
*/
import java.util.*;
public class ThreeSum {
  public static void main(String args[]) {
    int[] A = {4, 3, -1, 2, -2, 10};
    //int[] A = {0, -1, 2, -3, 1};
    int sum = 0;
    System.out.println("Solution 1, indices = " + Arrays.toString(get3SumTargetIndicesV1(A, sum)));
    System.out.println("Solution 2, indices = " + Arrays.toString(get3SumTargetIndicesV2(A, sum)));
    System.out.println("Solution 3, indices = " + Arrays.toString(get3SumTargetIndicesV3(A, sum)));
  }
 // Solution 1 : brute-force
 // Runtime : O(N^3),  Space : O(1)
  private static int[] get3SumTargetIndicesV1(int[] a, int targetSum) {
    if(a == null || a.length < 3)
      throw new IllegalArgumentException("Invalid input array!");
    int N = a.length;
    for(int i = 0; i < N - 2; i++) {
      for(int j = i+1; j < N - 1; j++) {
        for(int k = j + 1; k < N ; k++) {
          if(a[i] + a[j] + a[k] == targetSum) {
            //System.out.println("array values sum to 0 = " + a[i] + "," + a[j] + "," + a[k]);
            return new int[]{i, j, k};
          }
        }
      }
    }
    return null;
  }
/*
  Solution 2: Sort the array  O(n log n)
  Loop through the array and use two sum problem on sorted array. o(n^2).
  Runtime : O(N^2)
  Space   : O(1)
*/
  private static int[] get3SumTargetIndicesV2(int[] a, int targetSum) {
    if(a == null || a.length < 3)
      throw new IllegalArgumentException("Invalid input array!");
    int N = a.length;
    Arrays.sort(a);
    for(int i = 0; i < N; i++) {
      int start = i + 1;
      int end = N - 1;

      while(start < end) {
        int sum = a[i] + a[start] + a[end];
        if( sum == targetSum) {
          //System.out.println("array values sum to 0 = " + a[i] + "," + a[start] + "," + a[end]);
          return new int[]{i, start, end};
        } else if(sum < targetSum)
              start++;
          else {
            end--;
          }
      }
    }
    return null;
  }
  /*
  Solution 2: Sort the array
  Have two pointer one at start and one at end
  Runtime : O(N^2)
  Space   : O(N)
  */
  private static int[] get3SumTargetIndicesV3(int[] a, int targetSum) {
    if(a == null || a.length == 0)
      throw new IllegalArgumentException("Input cannot be null or empty..");
    int N = a.length;
    for(int i = 0; i < N; i++) {
      int sum =  targetSum - a[i];
      int[] twoSum = checkIfTwoSumExists(a, sum);
      if(twoSum != null && twoSum.length > 0)
          return new int[]{i, twoSum[0], twoSum[1]};
    }
    return null;
  }
  // helper method to solve TwoSum problem using extra memory
  private static int[] checkIfTwoSumExists(int[] a, int targetSum) {
    if(a == null || a.length == 0)
      throw new IllegalArgumentException("Input cannot be null or empty..");
    Map<Integer, Integer> indexMap = new HashMap<>();

    for(int i = 0; i < a.length; i++) {
      if(indexMap.containsKey(targetSum - a[i]))
          return new int[] {indexMap.get(targetSum - a[i]), i};
      else
         indexMap.put(a[i], i);
    }
    return null;
  }
}
