/**
 Given input string as brackets (Parentheses only).
 Output : Return true if it is valid parenthesis or false
*/
import java.util.Stack;

public class ParenthesesMatch {
  public static void main(String args[]) {
    String parenthesis = "()()";
    boolean isValid1 = validateparenthesis(parenthesis);
    boolean isValid2 = validateparenthesisV2(parenthesis);
    System.out.println(isValid1);
    System.out.println(isValid2);
  }

  // Solution 1 : Have one counter for each open parenthesis (+1 for open and -1 for close);
  // total sum should be 0 for valid and non-zero for invalid
  // Runtime : O(N)
  // Space   : O(1)
  private static boolean validateparenthesisV2(String theStr) {
    if(theStr == null || theStr.length() == 0)
        throw new IllegalArgumentException();
    int count = 0;

    for(int i = 0; i < theStr.length(); i++) {
      char ch = theStr.charAt(i);

     if(ch == '(' || ch == ')')
        count += getCharValue(ch);
      else
        return false;  // invalid input characters other than '(' or ')'
    }
      return (count == 0 ? true : false);
  }

  private static int getCharValue(char c) {
    if(c == '(')
      return 1;
    if(c == ')')
      return -1;

   return 0;
  }

  // Solution 2 : Have additional memory (stack) to store open parenthesis
  // pop from stack when we see a close parenthesis
  // make sure the stack is empty for valid parenthesis.
  // Runtime : O(N)
  // Space   : O(N)
  private static boolean validateparenthesis(String theStr) {
    if(theStr == null || theStr.length() == 0)
        throw new IllegalArgumentException();

    Stack<Character> stack = new Stack<>();

    for(int i = 0; i < theStr.length() ; i++) {
      char c = theStr.charAt(i);
      if(c == '(') {
        stack.push(c);
      } else if(c == ')') {
        if(stack.isEmpty() || stack.pop() != '(')
          return false;
      } else {
        return false; // invalid input characters other than '(' or ')'
      }
    }
    if(!stack.isEmpty())
      return false;

    return true;
  }
}
