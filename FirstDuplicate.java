/*
Note: Write a solution with O(n) time complexity and O(1) additional space complexity.
Given an array a that contains only numbers in the range from 1 to a.length,
find the first duplicate number for which the second occurrence has the minimal index.
In other words, if there are more than 1 duplicated numbers, return the number for which
the second occurrence has a smaller index than the second occurrence of the other number does.
If there are no such elements, return -1.
Example :
For a = [2, 3, 3, 1, 5, 2], the output should be
firstDuplicate(a) = 3.
There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than than
second occurrence of 2 does, so the answer is 3.
For a = [2, 4, 3, 5, 1], the output should be
firstDuplicate(a) = -1.
*/
public class FirstDuplicate {
  public static void main(String[] args) {
    //int[] arr = {2, 4, 3, 5, 1}; // -1
    //int[] arr = {2, 3, 3, 1, 5, 2}; // 3
    //int[] arr = {1, 2, 3, 4, 5, 6, 1, 5}; // 1
    int[] arr = {1, 2, 3, 4, 5, 6, 5, 1}; // 5
    System.out.println("First Duplicate = " + firstDuplicate(arr));
  }
  /* 1. take the abs value of arr[i].  2. Check the element value at  index: arr[value - 1]
     3. If the element value is  > 0, then change the value to -ve. 4. Otherwise return the current element value;
       Runtime : O(N), space : O(1).
   */
  private static int firstDuplicate(int[] arr){
    if(arr == null)
        return -1; // return -1 or error when array is null
    for(int i = 0; i < arr.length; i++){
      int current = Math.abs(arr[i]);  // Note : Take the abs value of arr[i].
      if(arr[current - 1] > 0) { // -1 because array index starts 0, but the elements starts from 1.
         arr[current - 1] = -arr[current - 1]; // change the sign of the number (to -ve)
      } else {
        return current; // the value will be the duplicated element
      }
    }
    return -1;
  }
}
