/*
Problem : Missing Element in an Array
A zero-indexed array A consisting of N different integers is given.
The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
Goal is to find that missing element.
For example, given array A such that:
 Input : int[] A = {2, 3, 1, 5 };   Output : 4
*/
public class MissingElement {
  public static void main(String args[]) {
    int[] A = {2, 3, 1, 5};
    int N = 5;
    int missingElement = findMissingElement(A);
    System.out.println("Missing Element = " +missingElement);
  }
 /* Solution : 1) Take the XOR of acutal input array.
            2) Take the expected XOR of the array (which includes missing element)
            3) Return the XOR of actualXor and expectedXor
  Runtime : O(N),  Space : O(1)
 */
  private static int findMissingElement(int[] A) {
    //if(A == null || A.length == 0)
      //throw new IllegalArgumentException("Input cannot be null or empty..");
    int actualXor = 0;
    for(int i = 0; i < A.length; i++)
      actualXor ^= A[i];

    int expectedXor = 0;
    for(int i = 1; i <= A.length + 1; i++)
      expectedXor ^= i;

    return expectedXor ^ actualXor;
  }
}
