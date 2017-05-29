import java.util.*;
/**
Given an integer array and a pivot value (pivot), partition the array
into two parts such that the elements to left of pivot are less and elements to
the right are larger than pivot.
*/
public class ArrayPartitionV2 {
  public static void main(String args[]) {
    int[] arr = {3, 1,2,12, 5, 6, 4, 10, 43, 52, 7, 9, 8};
    int pivotValue = 11;
    System.out.println("original array   = " +Arrays.toString(arr));
    System.out.println("partition pivot  = " + pivotValue);
    partition(arr, pivotValue);
    System.out.println("after partition  = " +Arrays.toString(arr));
  }

  private static void partition(int[] arr, int pivot) {
    int left = 0;
    int high = arr.length - 1;
    int right = arr.length - 1;

    shuffle(arr);

    while(left <= right) {
      while(arr[left] < pivot && left < high)
          left++;
      while(pivot < arr[right] && right > 0)
          right--;
      if(left >= right)
        break;
      swap(arr, left, right);
    }
  }
  // random shuffle
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
