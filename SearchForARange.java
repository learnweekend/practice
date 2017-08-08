/*
 problem : Search for a range
 Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4]

 https://leetcode.com/problems/search-for-a-range/description/
 */
import java.util.*;

 public class SearchForARange {
   public static void main(String[] args) {
     int[] arr = {5, 7, 7, 8, 8, 10};
     int target = 8;
     int[] range = searchForARange(arr, target);
     System.out.println(Arrays.toString(range));
   }

   public static int[] searchForARange(int[] arr, int target){
     if(arr == null) return new int[]{-1, -1};
 		 int startIndex = binarySearch(arr, target - 0.5);

     if(startIndex >= arr.length || arr[startIndex] != target){ // check for index out of range
 			   return new int[]{-1, -1};
 		 }
 		 int endIndex = binarySearch(arr, target + 0.5); //note this.

 		 return new int[]{startIndex, endIndex - 1}; //  end index is (less 1).
   }

   /* Solution : use binary search, runtime : O(log N), Space : O(1) */

   private static int binarySearch(int[] arr, double target){
     int start = 0;
     int end = arr.length - 1;
     while(start <= end){
       int mid = (start + end)/2;
       if(target > arr[mid]){
         start = mid + 1; // make sure to update start and end pointers
       } else {
         end = mid - 1;
       }
     }
     return start; // note ...returnstart
   }
 }
