/**
 Given an Integer array, rotate it left by k times.
*/
import java.util.*;
public class ArrayRotation {
  public static void main(String args[]) {
    int[] intArr = {1, 2, 3, 4, 5};
    int k = 3;
    rotateV1(intArr, k);
    System.out.println(Arrays.toString(intArr));
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    rotateV2(list, k);
    //rotateBruteForce(intArr, k);
  }
  /*
    Solution 0: brute-force, take a new array and copy the elements from K to N-1
    and copy the elements from  0 to K - 1
    Runtime : O(N)
    Space   : O(N)
  */
  private static int[] rotateBruteForce(int[] arr, int k) {
    if(arr == null || arr.length <= 1)
       return arr;

    int  N = arr.length;
    int[] result = new int[N];
    if (k > N)
      k = k % N;
    int index = 0;

    for(int i = k; i < N; i++) {
      result[index] = arr[i];
      index++;
    }
    for(int i = 0; i < k; i++) {
      result[index] = arr[i];
      index++;
    }
    return result;
  }
  /*
    Solution 1: reverse the first half (from 0 to k)
    reverse the second half (from k to end)
    reverse the entire array
    Runtime : O(N)
    Space   : O(1)
  */
  private static void rotateV1(int[] arr, int numOfRotations) {
    if(arr == null || arr.length <= 1)
       return;
    int N = arr.length;
    if(numOfRotations == N) // if #of rotations = array length, no change in original array.
      return;
    numOfRotations = numOfRotations % N;
    reverse(arr, 0, numOfRotations - 1); // reverse index from 0 to k - 1
    reverse(arr, numOfRotations, N - 1); //reverse index from k to length - 1
    reverse(arr, 0, N - 1);  //reverse the entire array
  }
  //helper method to reverse the array.
  private static void reverse(int[] arr, int start, int end) {
      for(int i = start, j = end; i < j; i++, j--)
        swap(arr, i, j);
    }
    // helper method to swap
  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  /*
    Solution 2: Remove K elements from start of list and add at the end
    Runtime : O(k)
    Space   : O(1)
  */
  private static void rotateV2(List<Integer> list, int k) {
    if(list == null || list.size() <= 1)
      return;
    for(int i = 0; i < k; i++) {
      int val = list.remove(0);
      list.add(val);
    }
    System.out.println(list);
  }

}
