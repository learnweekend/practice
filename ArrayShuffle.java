// Shuffle (random) the given integer array.
import java.util.*;

public class ArrayShuffle {
  public static void main(String args[]) {
      int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      shuffle(arr);
      System.out.println(Arrays.toString(arr));
  }
  /**
  Solution 1: Loop through the array,
  Calculate the random number upto the index and swap the element with random number
  Runtime : O(N)
  Space   : O(1)
  */
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
  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
