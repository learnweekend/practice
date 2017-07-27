/*
 problem : Given an array of numbers that is first strictly increasing and then strictly decreasing, find the maximum number.
 example : input: 1, 2, 3, 4, 5, 4, 3, 2
           output: 5
 Note :  Consider all possible corner cases for input. return -1 if input is null or empty
 */
 public class MaximumElement {
  /* Solution 1: Brute-force, loop through the array compare current with next element in array.
     Runtime   : O(N), Space : O(1)
  */
   private static int findMaxV1(int[] arr){
      if(arr == null || arr.length == 0)
          return -1;
      for(int i = 0; i < arr.length - 1; i++){
        if(arr[i] > arr[i + 1]) {
          return arr[i];
        }
      }
     return arr[arr.length - 1]; // last element will be maximum, since the array is sorted
   }
  /* Solution 2: Do a a binarysearch and get the index of maximum element
     Runtime : O(Log N), Space : O(1)
  */
   private static int findMaxV2(int[] arr) {
	if (arr == null || arr.length == 0) return -1;
	if (arr.length == 1) return arr[0];
	if (arr.length == 2)
	    return arr[0] > arr[1] ? arr[0] : arr[1];
        if(arr[0] > arr[1]) 
	    return arr[0]; // this is to take care when array is sorted decreasing order
	int start = 0;
	int end = arr.length - 1;
	int mid = 0;
	while (start <= end) {
	   mid = start + (end - start) / 2;
          // To make sure the mid (md < end) is not out of range when all elements are in increasing order
	   if (mid < end && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
	       return arr[mid]; // found the max
           } else if (arr[mid] > arr[mid - 1]) {
	       start = mid + 1; // check on right side
	   } else {
	       end = mid - 1; // check on left side
	   }
	}
	return arr[mid]; // Note : since "mid" is at start or end when input is completely sorted asc or desc.
   }

   public static void main(String[] args) {
    int[] A = null; // -1
    int[] B = new int[0]; // - 1
    int[] C = { 1 }; // 1
    int[] D = { 1, 2 }; // 2
    int[] E = { 2, 1 }; // 2
    int[] F = {1, 2, 1}; // 2
    int[] G = { 1, 3, 4, 7, 9, 6, 4, 2, 1 }; // 9
    int[] H = { 1, 3, 4, 7, 9 }; // 9
    int[] I = { 9, 6, 4, 2, 1 }; //9
    int[] J = {1, 2, 3, 4, 5, 6, 7, 8, 6}; // 8
    System.out.println(findMaxV1(A) + " and " + findMaxV2(A) );
    System.out.println(findMaxV1(B) + " and " + findMaxV2(B) );
    System.out.println(findMaxV1(C) + " and " + findMaxV2(C) );
    System.out.println(findMaxV1(D) + " and " + findMaxV2(D) );
    System.out.println(findMaxV1(E) + " and " + findMaxV2(E) );
    System.out.println(findMaxV1(F) + " and " + findMaxV2(F) );
    System.out.println(findMaxV1(G) + " and " + findMaxV2(G) );
    System.out.println(findMaxV1(H) + " and " + findMaxV2(H) );
    System.out.println(findMaxV1(I) + " and " + findMaxV2(I) );
    System.out.println(findMaxV1(J) + " and " + findMaxV2(J) );
  }

 }
