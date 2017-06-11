/*
  Problem: WeirdCase  - convert a given string to weirdcase character String.
  Write a function toWeirdCase (weirdcase in Ruby) that accepts a string, and returns  the same string with all
  even indexed characters in each word upper cased, and all odd indexed characters in each word lower cased.
  The indexing just explained is zero based, so the zero-ith index is even, therefore that character should be
  upper cased. The passed in string will only consist of alphabetical characters and spaces(' ').
  Spaces will only be present if there are multiple words. Words will be separated by a single space(' ').
*/
public class WeirdCase {
  public static void main(String args[]) {
    String str = "I am converted to weird case string";
    String result = convertToWeirdCase(str);
    System.out.println("WeirdCase = " + result);
  }
/*
  Solution 1:Loop through the String and get the characters at each index. Convert them to upper or lower based on char position.
    Runtime : O(N) - the number of characters in the input string.
    Space : O(1), only since we need to create a new String.

    Solution 2 : Split the given String on space character and process the words.
    Runtime : O(N) and Space : O(N)
*/
  private static String convertToWeirdCase(String input) {
    if(input == null || input.length() == 0)
          throw new IllegalArgumentException("Input String cannot be empty or null");
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for(int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if(ch == ' ') {
        sb.append(ch);
        count = 0;  // reset the count and go to next character
        continue;
      }
      if(count % 2 == 0) {
        sb.append(Character.toUpperCase(ch)); // convert to upper case
        count++;
      } else {
        sb.append(Character.toLowerCase(ch)); // convert to lower case
        count++;
      }
    }
    return sb.toString();
  }
}
