/*
 problem : Given a string array, return the longest common prefix in all strings
  return "" empty string if not found
*/
 public class LongestCommonPrefix {
  public static void main(String[] args){
    String[] arr = {"geeksforgeeks", "geezer", "geek", "geeks"}; // gee
    //String[] arr = {"apple", "ape", "april"}; // ap
    System.out.println(getLongestCommonPrefixV1(arr));
    System.out.println(getLongestCommonPrefixV2(arr));
  }
 /*
  Solution 1 : Get the minimum string length in the input array.
  take the first character from min String and check the prefix on all other strings
  if string matches, continue searching for next character, return longest prefix found so far if the character doesn't matches
  Runtime :O(k.N) where k = length of minimum string, N = number of strings in array., Space : O(K)- to store the prefix.
  Note : The problem with the above approach is one extra loop to get the minimum length string in input array.
  */
  private static String getLongestCommonPrefixV1(String[] arr){
    if(arr == null || arr.length == 0) return "";
    int count = 0;
    String minString = arr[0];
    int minStrLength = arr[0].length();

    for(String s : arr){ // loop to get min string length in the array.
      if(s.length() < minStrLength) {
        minStrLength = s.length();
        minString = s;
      }
    }
    while(count < minStrLength) { // loop until minString length.
      char ch = minString.charAt(count);
      for(String s : arr){
        if(s.charAt(count) != ch){
          return minString.substring(0, count);
        }
      }
      count++;
    }
    return minString.substring(0, count);
  }
  /*
   Solution 2 : Take the first character from first String and check the prefix on all other strings
   if string matches, continue searching for next character, return longest prefix found so far if the character doesn't matches
   Runtime :O(k.N) where k = length of minimum string, N = number of strings in array., Space : O(K)- to store the prefix.
   Note : Add a check for index (shouldn't more then str length). This doesn't need extra loop.
   */
  private static String getLongestCommonPrefixV2(String[] arr){
    if(arr == null || arr.length == 0) return "";
    int index = 0;
    while(index < arr[0].length()){
      char ch = arr[0].charAt(index);
      for(int i = 1; i < arr.length; i++) {
        if(index >= arr[i].length() || arr[i].charAt(index) != ch){
          return arr[0].substring(0, index);
        }
      }
      index++;
    }
    return arr[0];
  }
 }
