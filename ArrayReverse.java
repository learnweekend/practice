// Given an integer array, write an efficient method to reverse the array.
import java.util.*;

public class ArrayReverse {
  public static void main(String args[]) {
    int[] arr = {1, 2, 3, 4, 5};
    reverseV1(arr, 0, arr.length - 1); //from index 0 to 4
    //reverseV2(arr, 0, arr.length - 1); //from index 0 to 4
    System.out.println(Arrays.toString(arr));
  }

  private static void reverseV1(int[] arr, int start, int end) {
    if(arr == null || arr.length <= 1)
        return;
    for(int i = 0, j = end; i < j; i++, j--)
      swap(arr, i, j);
  }

  private static void reverseV2(int[] arr, int start, int end) {
    if(arr == null || arr.length <= 1)
        return;
    while(start <= end) {
      swap(arr, start, end);
      start++;
      end--;
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
