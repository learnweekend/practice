import java.util.*;

public class MoveZerosToEnd {
  public static void main(String args[]) {
    int[] A = {1, 2, 3, 4, 0, 5, 6, 0, 7, 8, 0, 9, 0, 10, 11, 0, 12};
    System.out.println(" array = " + Arrays.toString(A));
    int[] result = moveZerosToEnd(A);
    System.out.println("result = " + Arrays.toString(result));
  }
/*
 Solution 1 : Loop through the array and add if you find non-zero element.
 Runtime    : O(N)
 Space      : O(N) - for result array.
*/
  private static int[] moveZerosToEnd(int[] arr) {
    if(arr == null || arr.length == 0)
      throw new IllegalArgumentException("Input cannot be null or empty!");
    int N = arr.length;
    int[] result = new int[N];
    int start = 0;
    for(int i = 0; i < N; i++) {
      if(arr[i] != 0)
         result[start++] = arr[i];
    }
    return result;
  }
}
