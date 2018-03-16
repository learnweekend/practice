/**
 https://leetcode.com/problems/two-sum/description/
 Problem : Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
import java.util.*;
public class TwoSum {
 /*
 Solution 1: Loop through the array and store the values in Set.
 Check if (targetSum - value) exists in the Set and return true if exists or false.
  Runtime : O(N), Space   : O(N) - set to store array elements.
*/
  private static boolean checkIfTwoSumExists(int[] a, int targetSum) {
      if(a == null || a.length == 0)
        throw new IllegalArgumentException("Input cannot be null or empty..");
      Set<Integer> elementSet = new HashSet<>();
      for(int value : a) {
        if(elementSet.contains(targetSum - value))
            return true;
        else
            elementSet.add(value);
      }
      return false;
  }
  /*
   Solution 2: Use extra memory to store value and index in a HashMap
   Returns the indices where the targetSum matches, null if not present
   Runtime : O(N), Space   : O(N) - map to store value and index.
  */
  private static int[] checkIfTwoSumExistsV2(int[] a, int targetSum) {
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
  /*
   Solution 3: Sort the initial array.
   Have two pointers one at start and another at end, check sum if matches with targetSum and move pointers based on sum
   When the sum matches..return the indices.
   Runtime : O(N Long N)  // sorting,  Space   : O(1)
  */
    private static int[] checkIfTwoSumExistsV3(int[] a, int targetSum) {
      if(a == null || a.length == 0)
        throw new IllegalArgumentException("Input cannot be null or empty.."); 
      Arrays.sort(a);
      int start = 0;
      int end = a.length - 1;
      while(start < end) {
        int sum = a[start] + a[end];
        if(sum == targetSum) {
          return new int[] {start, end};
        } else if(sum < targetSum) {
            start++;
        } else {
          end--;
        }
      }
      return null;
    }
  
   public static void main(String[] args){
    int[] A = {8, 4, 1, 13, 43,  87, 53, 12, 5};
    int sum = 14;
    //int[] A = {7, 4, -1, 13, -43,  87, 53, 12, 5};
    //int sum = 6;
    //int[] A = {5 ,1};
    //int sum = 6;
    System.out.println("is targetSum exists  = " + checkIfTwoSumExists(A, sum));
    System.out.println("array indices        = " + Arrays.toString(checkIfTwoSumExistsV2(A, sum)));
    System.out.println("sorted array indices = " +Arrays.toString(checkIfTwoSumExistsV3(A, sum)));
  }
}
