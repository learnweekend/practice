import java.util.*;

public class MergeTwoSortedArrays {
  public static void main(String[] args){
    //int[] arr1 = {1, 4, 7, 9, 10, 18};
    //int[] arr2 = {2, 5, 6, 8, 11};
    int[] arr1 = {1, 4, 7, 8, 10};
    int[] arr2 = {2, 3, 9};
    int[] result = mergeTwoSortedArrays(arr1, arr2);
    System.out.println(Arrays.toString(result));
    mergeTwoSortedArraysInPlace(arr1, arr2);
  }
  /* Solution 1 : Uses extra memory to store the result array.
     Runtime    : O(mn)
     Space      : O(1)
    */
  private static int[] mergeTwoSortedArrays(int[] a1, int[] a2){
    if(a1 == null || a1.length == 0)
      return a2;
    if(a2 == null || a2.length == 0)
      return a1;

    int i = 0; // startIndex of array1
    int j = 0; // startIndex of array2
    int k = 0; // startIndex of result array
    int[] result = new int[a1.length + a2.length];

    while(i < a1.length && j < a2.length) {
      if(a1[i] < a2[j])
        result[k++] = a1[i++]; // increment i pointer in a1
      else
        result[k++] = a2[j++]; // increment j pointer in a2
    }
    while(i < a1.length)  // copy remaining elements from a1
      result[k++] = a1[i++];

    while(j < a2.length) // copy remaining elements from a2
      result[k++] = a2[j++];

    return result;
  }
  /* Solution 2 : In place sorting, keep the input length same as original arrays
     Runtime : O(mn)
     Space   : O(1)
    */
  private static void mergeTwoSortedArraysInPlace(int[] a1, int[] a2){
    if(a1 == null || a1.length == 0)
      return;
    if(a2 == null || a2.length == 0)
      return;

    int i = 0; // startIndex of array1
    int j = 0; // startIndex of array2
    int k = 0; // startIndex of result array (array1)

    while(i < a1.length) {
      if(a1[i] < a2[0])
        a1[k++] = a1[i++];
      else
        swapAndArrange(a1, a2, i, 0); // swap array1 element from array2 and re-arrange the array2 in sorted order
    }
    System.out.println(Arrays.toString(a1));
    System.out.println(Arrays.toString(a2));
  }

  /* Helper method to check swap and maintain array2 in sorted order using insertion sorted */
  private static void swapAndArrange(int[] a1, int[] a2, int index1, int index2){
    int temp = a1[index1];  // swapping
    a1[index1] = a2[index2];
    a2[index2] = temp;

    for(int i = 1; i < a2.length; i++) { // insertion sort
      if(a2[i] < a2[i - 1]){
        temp = a2[i - 1];
        a2[i - 1] = a2[i];
        a2[i] = temp;
      }
    }
  }

}
