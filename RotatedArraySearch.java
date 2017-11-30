package com.all;


/**
 Problem : Search in rotated sorted array.
*/
public class RotatedArraySearch {
  public static void main(String[] args) {
  	  System.out.println(searchLinear(new int[]{5, 1, 3}, 1));
      System.out.println(searchLinear(new int[]{60, 70, 10, 20, 30, 40, 50}, 10));
      System.out.println(searchLinear(new int[]{3, 1}, 3));

      System.out.println(search(new int[]{5, 1, 3}, 1));
      System.out.println(search(new int[]{60, 70, 10, 20, 30, 40, 50}, 10));
      System.out.println(search(new int[]{3, 1}, 3));
  }

 // Brute force solution : do the linear search, runtime O(N), space : O(1)
  private static int searchLinear(int[] arr, int target){
  	if(arr == null || arr.length == 0)
  		return -1;
  	for(int i = 0; i < arr.length; i++){
  		if(target == arr[i])
  			return i;
  	}
  	return -1;
  }

   /* solution : binarysearch, runtime : O(log n), space : O(1)
   	1. calculate the mid
	2. check if left part is sorted or right part is sorted
    3. based on target key search left array or right array
    4. repeat the above process. 
    5. runtime : O(log n), space : O(1)
    */ 
  private static int search(int[] arr, int target){
  	if(arr == null || arr.length == 0)
  		return -1;

  	int start = 0;
  	int end = arr.length - 1;

  	while(start <= end){
  		int mid = start + ((end - start)/2);

  		if(target == arr[mid])  // target element found
  			return mid;

  		if(arr[start] <= arr[mid]) { // left is sorted

  			if(target >= arr[start] && target <= arr[mid]) {
  				end = mid - 1; // search on left side
  			} else {
  				start = mid + 1;  // search on right side
  			}
  		} else {   //right is sorted

  			if(target >= arr[mid] && target <= arr[end]) {
  				start = mid + 1;  // search on right
  			} else {
  				end = mid - 1; // search on left
  			}
  		}
  	}
  	return -1;
  }

}