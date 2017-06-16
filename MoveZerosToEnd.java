/*
Modify the array by moving all the zeros to the end (right side).
The order of other elements doesn’t matter. Let’s have an example.
For array [1, 2, 0, 3, 0, 1, 2], the program can output [1, 2, 3, 1, 2, 0, 0].
*/
import java.util.*;
public class MoveZerosToEnd {
  public static void main(String args[]) {
    //int[] A = {1, 2, 3, 4, 0, 5, 6, 0, 7, 8, 0, 9, 0, 10, 11, 0, 12};
    int[] A = {1, 2, 0, 3, 0, 1, 2};
    System.out.println(" array     = " + Arrays.toString(A));
    System.out.println();
    int[] result = moveZerosToEndV1(A);
    System.out.println("Solution 1 = " + Arrays.toString(result));

    //int[] A2 = {1, 2, 3, 4, 0, 5, 6, 0, 7, 8, 0, 9, 0, 10, 11, 0, 12};
    int[] A2 = {1, 2, 0, 3, 0, 1, 2};
    moveZerosToEndV2(A2);
    System.out.println("Solution 2 = " + Arrays.toString(A2));

    //int[] A3 = {1, 2, 3, 4, 0, 5, 6, 0, 7, 8, 0, 9, 0, 10, 11, 0, 12};
    int[] A3 = {1, 2, 0, 3, 0, 1, 2};
    moveZerosToEndV3(A3);
    System.out.println("Solution 3 = " + Arrays.toString(A3));
  }
/*
 Solution 1 : Loop through the array and add if you find non-zero element.
 Runtime    : O(N)
 Space      : O(N) - for result array.
*/
  private static int[] moveZerosToEndV1(int[] arr) {
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
  /*
   Solution 2 : Loop through the array and add if you find non-zero element.
   Note : The order of the elements remains same.
   Runtime    : O(N)
   Space      : O(1)
  */
  private static void moveZerosToEndV2(int[] a) {
    if(a == null || a.length == 0)
      throw new IllegalArgumentException("Input cannot be null or empty!");
    int arrIndex = 0;
    for(int i = 0; i < a.length; i++) {
        if(a[i] != 0)
          a[arrIndex++] = a[i];
     }
     for(int i = arrIndex; i < a.length; i++)
        a[i] = 0;
  }
  /*
   Solution 3 : Loop through the array. Have two pointers one at start and another one at end
   Move start pointer forward and check for zero, if found swap with non-zero element at end
   Note : check for start and end indices
   Note : The order of the elements changes here.
   Runtime    : O(N)
   Space      : O(1)
  */
  private static void moveZerosToEndV3(int[] a) {
    if(a == null || a.length == 0)
      throw new IllegalArgumentException("Input cannot be null or empty!");
    int start = 0;
    int end = a.length - 1;
    while(start <= end) {   // Note : start <= end
        if(a[start] == 0) {
          while(start < end && a[end] == 0)  // NOT start <= end
              end--;
          swap(a, start, end);
          end--;
        }
        start++;
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
