
/**
 Reverse a given String
*/
public class StringReverse {

  public static void main(String args[]) {
    String word = "Reverse me";
    String reverse1 = reverse(word);
    String reverse2 = reverse(word, new StringBuilder());
    System.out.println(reverse1);
    System.out.println(reverse2);
  }

 // Solution 1: Using Recursion 
 // Take the last character of the String and concatenate with remaining using recursive call stack.

  private static String reverse(String str) {
      if(str == null || str.length() == 0)
          return "";

      return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
  }

// Solution 2: Using Recursion
// Use StringBuilder object and append, instead of creating a new string for each concatenation.
  
 private static String reverse(String str, StringBuilder sb) {
    if(str == null || str.length() == 0)
        return "";

    sb.append (str.charAt(str.length() - 1));
    reverse(str.substring(0, str.length() - 1), sb);

    return sb.toString();
  }
}
