 /*
 problem : Given an array of numbers that is first strictly increasing and then strictly decreasing, find the maximum number.
 example : input: 1, 2, 3, 4, 5, 4, 3, 2
           output: 5
 Note :  The array should have atleast three elements and retruns Integer.MIN_VALUE incase of not found.
 */
 import java.util.*;

 public class MaximumElement {

  public static void main(String[] args) {
    //int[] arr = {1, 2, 3, 4, 5, 4, 3, 2};
    //int[] arr = {1, 2, 1};
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 6};
    System.out.println("Given Array = " + Arrays.toString(arr));
    System.out.println("Max element = " + findMaxV1(arr));
    System.out.println("Max element = " + findMaxV2(arr)); // more efficient
  }

  /* Solution 1: Brute-force, loop through the array compare previous and next element
     Runtime   : O(N), Space : O(1)
  */
  private static int findMaxV1(int[] arr){
      if(arr == null || arr.length < 3)
          throw new IllegalArgumentException("Array should have atleast 3 elements");

      for(int i = 1; i < arr.length - 1; i++){
        if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
          return arr[i];
        }
      }
      return Integer.MIN_VALUE;  // not found
   }

  /* Solution 2: Do a a binarysearch and get the index of maximum element
     Runtime : O(Log N), Space : O(1)
  */
  private static int findMaxV2(int[] arr){
      if(arr == null || arr.length < 3)
          throw new IllegalArgumentException("Array should have atleast 3 elements");

      int start = 0;
      int end = arr.length - 1;
      
      while(start <= end){
         int mid = (start + end)/2;
         if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
           return arr[mid];
         } else if(arr[mid] > arr[mid - 1]){
           start = mid + 1; // check on right side
         } else {
           end = mid - 1; // check on left side
         }
      }
      return Integer.MIN_VALUE;  // not found
   }

 }
