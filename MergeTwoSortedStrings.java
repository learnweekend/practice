/*
 Problem :  Given two sorted strings, merge them to a new string in sorted order.
 */
import java.util.*;

public class MergeTwoSortedStrings {
  public static void main(String[] args){
    String s1 = "aelpp";
    String s2 = "eggloo";
    String result = mergeTwoSortedStrings(s1, s2);
    System.out.println(result);
  }

  private static String mergeTwoSortedStrings(String s1, String s2){
    if(s1 == null) return s2;
    if(s2 == null) return s1;
    StringBuilder sb = new StringBuilder();
    int i = 0; // startIndex of s1
    int j = 0; // startIndex of s2

    while(i < s1.length() && j < s2.length()) {
      if(s1.charAt(i) < s2.charAt(j))
        sb.append(s1.charAt(i++)); // increment i pointer in s1
      else
        sb.append(s2.charAt(j++)); //increment j pointer in s2
    }
    while(i < s1.length())  // copy remaining elements from s1
        sb.append(s1.charAt(i++));

    while(j < s2.length())  // copy remaining elements from s2
        sb.append(s2.charAt(j++));

    return sb.toString();
  }
}
