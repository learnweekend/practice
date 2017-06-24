/*
Note: Write a solution with O(n) time complexity and O(1) additional space complexity,
Given an array a that contains only numbers in the range from 1 to a.length,
find the first duplicate number for which the second occurrence has the minimal index.
In other words, if there are more than 1 duplicated numbers, return the number for which the
second occurrence has a smaller index than the second occurrence of the other number does.
If there are no such elements, return -1.
Example:
For a = [2, 3, 3, 1, 5, 2], the output should be
firstDuplicate(a) = 3.
There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than than
second occurrence of 2 does, so the answer is 3.
For a = [2, 4, 3, 5, 1], the output should be
firstDuplicate(a) = -1
*/
public class FindDuplicatesFrom1ToN {
  public static void main(String args[]) {
    int[] a = {2, 3, 3, 1, 5, 2};
    //int[] a = {2, 4, 3, 5, 1};
    System.out.println(findFirstIndexDuplicateValue(a));
  }
  /* Solution : Flip the sign of integer elements given at that index.
  If the number repeats, check the value at that index, if the value > 0, then flip the value, else return the array value(Abs)
  Runetime : O(N), Space O(1);
  */
  private static int findFirstIndexDuplicateValue(int[] arr) {
    if(arr == null || arr.length == 0)
      throw new IllegalArgumentException();

    for(int i = 0; i < arr.length; i++) {
      int curr = Math.abs(arr[i]);
      if(arr[curr - 1] > 0)  // Note : minus one,because the numbers are from 1 to N, if numbers are from 0 to N - 1, then no minus 1
        arr[curr - 1] = -arr[curr - 1]; // flip the value to negative
      else
        return curr;  // duplicates found
    }
    return - 1;  // duplicates not found
  }
}
