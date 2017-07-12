import java.util.*;
/* Problem : Given pivot value (may be or may not present in array. Partition the array into two parts
  such that the elements to left of pivot are less and elements to the right are larger than pivot. */
public class Partition {
  public static void main(String[] args){
    //int[] arr = {3, 1, 2, 12, 5, 6, 4, 10, 43, 52, 7, 9, 8};
    int[] arr = {34, 52, 23, 7, 8, 9, 12, 36, -1, -34, -8, 19, 3};
    System.out.println(Arrays.toString(arr));
    partition(arr, 1);
    System.out.println(Arrays.toString(arr));
  }
  /* Solution : Have two pointers one at start and one at the end of the array
     move start pointer forward until element is greater than pivot value.
     move the right pointer backwards until element is less than pivot value.
     swap the start and end pointer elements. make sure the indices are not out of bound.
     Runtime : O(N), Space : O(1) */
  private static void partition(int[] arr, int pivot){
    int start = 0;
    int end = arr.length - 1;

    while(start <= end) {
      while(arr[start] < pivot && start <= end)
        start++;  // move start forward

      while(arr[end] > pivot && start <= end)
        end--;  // move end backwards

      if(start >= end)  // check of start and end indices crossing
        break;

      swap(arr, start, end);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

}
