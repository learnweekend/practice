
/* Problem : Print all subsets of given a "string" or "array" */

import java.util.*;

public class Subsets {
  public static void main(String[] args){
    String str = "abcd";
    subsetsV1(str);

    char[] charArr = {'a', 'b', 'c', 'd'};
    subsetsV2(charArr);

    int[] intArr = {1, 2, 3, 4};
    List<List<Integer>> subsets = subsetsV3(intArr);
    for(List<Integer> subset : subsets){
      System.out.println(subset);
    }
  }
  /*  Solution 1 : Recursive, prints all subsets of a given string
      Runtime    : O(2^N), Space : O(1) */
  private static void subsetsV1(String str){
    if(str == null || str.length() == 0) return;
    subsetsV1("", str);
  }

  private static void subsetsV1(String prefix, String str){
    System.out.println(prefix);
    for(int i = 0; i < str.length(); i++) {
      subsetsV1(prefix + str.charAt(i), str.substring(i + 1));
    }
  }
  /*  Solution 2 : Recursive, prints all subsets of a given string
      Runtime    : O(2^N), Space : O(N) */
  private static void subsetsV2(char[] charArr){
    if(charArr == null || charArr.length == 0) return;
    String str = new String(charArr);
    subsetsV2("", str);
  }
  private static void subsetsV2(String prefix, String str){
    System.out.println(Arrays.toString(prefix.toCharArray()));
    for(int i = 0; i < str.length(); i++) {
      subsetsV2(prefix + str.charAt(i), str.substring(i + 1));
    }
  }
  /*  Solution 3 : Recursive, prints all subsets of a given string
      Runtime    : O(2^N), Space : O(N) */
   private static List<List<Integer>> subsetsV3(int[] intArr) {
    if(intArr == null || intArr.length == 0) throw new IllegalArgumentException();
    int N = intArr.length;
    int maxSubsets = 1 << N;  //2^length of array
    List<List<Integer>> subsets = new ArrayList<>(); // to store results

    for(int i = 0; i < maxSubsets; i++) {
       List<Integer> subset = new ArrayList<>();

       for(int j = 0; j < N; j++) {
        if ( (i & (1 << j)) > 0) {
           subset.add(intArr[j]);
        }
      }
      subsets.add(subset);
    }
    return subsets;
   }

}
