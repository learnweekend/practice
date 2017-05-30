
/**
  Create a function that reverses all the words in a string.
  Example :  input --> The cat is red
             output -> red is cat The
*/
public class ReverseWords {
  public static void main(String args[]) {
    String str = "The cat is red";
    System.out.println("original      = " +str);
    String reverseWords1 = reverseWordsV1(str);
    String reverseWords2 = reverseWordsV2(str);
    System.out.println("reverseWords1 = " +reverseWords1);
    System.out.println("reverseWords2 = " +reverseWords2);
  }
  // Solution 1 : Use the split function on white space delimiter
  //              and print the words from end of string array.
  // Runtime    : O(N)
  // Space      : O(N)
  private static String reverseWordsV1(String theStr) {
    if(theStr == null || theStr.length() == 0)
        throw new IllegalArgumentException("Invalid input");
    String[] words = theStr.split("\\s+");
    StringBuilder sb = new StringBuilder();

    for(int i = words.length - 1; i >= 0; i--) {
      sb.append(words[i]);
      sb.append(" ");
    }
    return sb.toString();
  }
  // Solution 2:  This approach doesn't uses split function.
  // Loop through the array from end and when you see a white space
  // get the substring from white space and print.
  // Runtime   : O(N)
  // Space     : O(N) as need to return new string.
  private static String reverseWordsV2(String theStr) {
    if(theStr == null || theStr.length() == 0)
        throw new IllegalArgumentException("Invalid input");
    StringBuilder sb = new StringBuilder();
    int N = theStr.length();
    int temp = N;

    for(int i = N - 1; i > 0; i--) {
      char ch = theStr.charAt(i);
      if(ch == ' ') {
        sb.append(theStr.substring(i, temp));
        temp = i;
      }
    }
    sb.append(" " +theStr.substring(0, temp));
    return sb.toString().trim();
  }
}
