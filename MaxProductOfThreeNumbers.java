import java.util.*;

public class MaxProductOfThreeNumbers {
  public static void main(String[] args){
    //int[] arr = {2, 3, 6, -8, -6, 8, -4, -5};
    //int[] arr = {10, 3, 5, 6, 20};
    int[] arr = {-10, -3, -5, -6, -20}; //-90
    //int[] arr = {1, -4, 3, -6, 7, 0}; // 168
    System.out.println(getHighestProductV1(arr));
    System.out.println(getHighestProductV2(arr));
    System.out.println(getHighestProductV3(arr));
  }
  /* Solution : Brute-force, Runtime : O(N ^ 3), Space : O(1); */
  private static long getHighestProductV1(int[] arr) {
    if(arr == null || arr.length == 0)
      throw new IllegalArgumentException();
    int N = arr.length;
    if(N == 3)
      return arr[0] * arr[1] * arr[2];

    long maxProduct = Long.MIN_VALUE;
    for(int i = 0; i < N - 2; i++) {
      for(int j = i + 1; j < N - 1; j++) {
        for(int k = j + 1; k < N; k++) {
          maxProduct = Math.max(maxProduct, arr[i] * arr[j] * arr[k]);
        }
      }
    }
    return maxProduct;
  }
  /* Solution 2: sort the array and take the maximum of producto of last three elements and
     product of first two element and last element. Runtime : O(N log N), Space : O(1); */
  private static long getHighestProductV2(int[] arr){
    if(arr == null || arr.length == 0)
      throw new IllegalArgumentException();
    int N = arr.length;
    if(N == 3)
      return arr[0] * arr[1] * arr[2];

    Arrays.sort(arr);
    return Math.max(arr[0] * arr[1] * arr[N - 1], arr[N - 1] * arr[N - 2] * arr[N - 3]);
  }
  /* Solution 3: sort the array and take the maximum of producto of last three elements and
     product of first two element and last element. Runtime : O(N log N), Space : O(1); */
   private static long getHighestProductV3(int[] arr) {
     if(arr == null || arr.length == 0)
       throw new IllegalArgumentException();
     int N = arr.length;
     if(N == 3)
       return arr[0] * arr[1] * arr[2];

     int biggest = Integer.MIN_VALUE;
     int secondBiggest = Integer.MIN_VALUE;
     int thirdBiggest = Integer.MIN_VALUE;
     int smallest = Integer.MAX_VALUE;
     int secondSmallest = Integer.MAX_VALUE;

     for(int i = 0; i < N; i++) {
       if(arr[i] > biggest) { // update the 3 biggest numbers
         thirdBiggest = secondBiggest;
         secondBiggest = biggest;
         biggest = arr[i];
       } else if(arr[i] > secondBiggest) { // update the  2nd and third biggest numbers
         thirdBiggest = secondBiggest;
         secondBiggest = arr[i];;
       } else if(arr[i] > thirdBiggest){ // update third biggest number
         thirdBiggest = arr[i];
       }
       if(arr[i] < smallest) {  // update the smallest and secondSmallest
         secondSmallest = smallest;
         smallest = arr[i];
       } else if(arr[i] < secondSmallest) { // update the secondSmallest
         secondSmallest = arr[i];
       }
     }
     return Math.max(smallest * secondSmallest * biggest,  biggest * secondBiggest * thirdBiggest);
   }
}
