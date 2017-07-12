import java.util.*;
/* Problem :
  Given pivot element (First Element In the array), Partition the array into two parts
  such that the elements to left of pivot are less and elements to the right are larger than pivot.
  The function should return the "pivot" index.
*/
public class TwoWayPartition {
  public static void main(String[] args){
    //int[] arr = {34, 52, 23, 7, 8, 9, 12, 36, -1, -34, -8, 19, 3};
    int[] arr = {3, 1, 2, 12, 5, 6, 4, 10, 43, 52, 7, 9, 8};
    System.out.println(Arrays.toString(arr));
    int partitionIndex = partition(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println("Partition Index = " + partitionIndex + "Pivot Value = " + arr[partitionIndex]);
  }
  /* Solution : Have two pointers one at start and one at the end of the array
     move start pointer forward until element is greater than pivot value.
     move the right pointer backwards until element is less than pivot value.
     swap the start and end pointer elements. make sure the indices are not out of bound.
     Runtime : O(N), Space : O(1) */
  private static int partition(int[] arr){
    int left = 1; // note this
    int right = arr.length - 1;
    int low = 0;

    while(left <= right) {
      while(arr[left] < arr[low] && left <= right)
        left++;  // move start forward
      while(arr[right] > arr[low] && left <= right)
        right--;  // move end backwards
      if(left >= right)  // check of start and end indices crossing
        break;
      swap(arr, left, right);
    }
    swap(arr, low, right); // swap the pivot element with right pointer
    return right;  // right will be the pivot index
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

}
