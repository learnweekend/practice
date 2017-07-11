public class Palindrome{
  public static void main(String args[]){
    //String inputStr = "Madam, I'm Adam";
    String inputStr = "aaaav";
		//String inputStr = "Step on no pets";
		//String inputStr = "Was it a cat I saw?";
		boolean isPalindrome = isPalindrome(inputStr);
		System.out.println(isPalindrome);
  }
  /* Solution :  Have two pointers one at start and another one at end of String.
  Move the pointer forward and backward until you get the valid character (ignore spaces and specical characters and digits).
  Compare the values at two pointers for equality(ignore case), return false if they are not equal.
  Continue until we reach the end of the array.
  Runtime : O(N), Space : O(1) */
  private static boolean isPalindrome(String str){
    if(str == null || str.length() == 0) return true;
    int start = 0;
    int end = str.length() - 1;

    while(start < end){
      //move start pointer forward until see a valid character
      while(!Character.isLetterOrDigit(str.charAt(start)) && start < end)
        start++;
      //move end pointer backward until see a valid character
      while(!Character.isLetterOrDigit(str.charAt(end)) && start < end)
        end--;
      //compare the characters at both pointer ignore case.
      if(str.toLowerCase().charAt(start) != str.toLowerCase().charAt(end))
        return false;

      start++;
      end--;
    }
    return true;
  }
}
