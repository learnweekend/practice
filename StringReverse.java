/**
 Reverse a given String
*/
public class StringReverse {
  public static void main(String args[]) {
    String word = "Reverse me";
    String reverse1 = reverseV1(word);
    String reverse2 = reverseV2(word);
    String reverse3 = reverseV3(word, new StringBuilder());
    System.out.println(reverse1);
    System.out.println(reverse2);
    System.out.println(reverse3);
  }
  // Solution 1: Iterative approach - swapping the characters
  // Swap the first with last character and so on...
  // Runtime  : O(N)
  // Space    : O(1)
  private static String reverseV1(String theStr) {
		if(theStr == null || theStr.length() == 0)
			throw new IllegalArgumentException("Original String cannot be null or Empty");
		if(theStr.length() == 1)  return theStr;
		char[] charArr = theStr.toCharArray();
		int j = charArr.length - 1;

		for(int i = 0; i < charArr.length/2; i++, j--) {
			swap(charArr, i, j);
		}
		return new String(charArr);
	}

 // Solution 2: Using Recursion
 // Take the last character of the String and concatenate with remaining using recursive call stack.
 // Runtime  : O(N)
 // Space    : O(1) - uses call stack.
  private static String reverseV2(String str) {
      if(str == null || str.length() == 0)
          return "";
      return str.charAt(str.length() - 1) + reverseV2(str.substring(0, str.length() - 1));
  }
 // Solution 3: Using Recursion
 // Use StringBuilder object and append, instead of creating a new string for each concatenation.
 // Runtime  : O(N)
 // Space    : O(N)
 private static String reverseV3(String str, StringBuilder sb) {
    if(str == null || str.length() == 0)
        return "";
    sb.append (str.charAt(str.length() - 1));
    reverseV3(str.substring(0, str.length() - 1), sb);
    return sb.toString();
  }

  private static void swap(char[] chars, int src, int dest) {
		char temp = chars[src];
		chars[src] = chars[dest] ;
		chars[dest] = temp;
	}
}
