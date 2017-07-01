import java.util.*;

public class MergeTwoSortedArrays {
  public static void main(String[] args){
    int[] arr1 = {1, 4, 7, 9, 10, 18};
    int[] arr2 = {2, 5, 6, 8, 11};
    int[] result = mergeTwoSortedArrays(arr1, arr2); // 1,2,4,5,7,8
    System.out.println(Arrays.toString(result));
  }

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
}
