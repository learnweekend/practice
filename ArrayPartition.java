/**
Given an Integer array,  partition the array to 2 parts with some pivot
such that elements to the left are less than pivot and elements on right
are larger than pivot. Assume elements in the array are unique.
*/
import java.util.*;
public class ArrayPartition {
  public static void main(String args[]) {
    int[] arr = {3, 1,2,12, 5, 6, 4, 10, 43, 52, 7, 9, 8};
    System.out.println("before partition : " +Arrays.toString(arr));
    int pivotIndex = partition(arr, 0, arr.length - 1);
    System.out.println("pivot value      : " + arr[pivotIndex]);
    System.out.println("after partition  : " +Arrays.toString(arr));
  }
/**
    Solution 1:
    1. Shuffle the array for randomness.
    2. Have one pointer at start and one at end.
    3. Swap the elements and move pointer forward and backward
       after comparision with pivot element.
    4. Swap the pivot with current pointer position.
    Runtime : O(N)
    Space   : O(1)
*/
  private static int partition(int[] arr, int low, int high) {
    if(arr == null || arr.length <= 1)
      return 0;
    shuffle(arr);  // shuffle the array for randomness
    int left = low;
    int right = high + 1;

    while(left <= right) {
      while(arr[++left] < arr[low]) {
        if(left == high)
          break;
      }
      while(arr[--right] > arr[low]) {
       if(right == low)
         break;
      }
      if(left >= right)
        break;
      swap(arr, left, right);
    }
    swap(arr, low, right);
    return right;
  }
  //shuffle the array
  private static void shuffle(int[] arr) {
    if(arr == null || arr.length <= 1)
      return;
    Random random = new Random();
    int N = arr.length;
    for(int i = 0; i < N; i++) {
      int randomInt = random.nextInt(i + 1);  //+1 to avoid error when i = 0
      swap(arr, i, randomInt);
    }
  }
  //swap the elements in the array.
  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
