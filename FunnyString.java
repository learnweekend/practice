/*
 problem :  Funny String from HackerRank
 https://www.hackerrank.com/challenges/funny-string?h_r=internal-search
 */
public class FunnyString {
  public static void main(String[] args){
    String s1 = "bcxz";
    String s2 = "acxz";
    System.out.println(checkFunnyString(s1));
    System.out.println(checkFunnyString(s2));
  }

  private static String checkFunnyString(String str){
    String reverseStr = new StringBuffer(str).reverse().toString();
    for(int i = 1; i < str.length() - 1; i++){
      int iStr0 = getIntValue(str.charAt(i));
      int iStr1 = getIntValue(str.charAt(i - 1));
      int rStr0 = getIntValue(reverseStr.charAt(i));
      int rStr1 = getIntValue(reverseStr.charAt(i - 1));

      if(Math.abs(iStr0 - iStr1) != Math.abs(rStr0 - rStr1))
          return "Not Funny";
    }
    return "Funny";
  }

  private static int getIntValue(char ch){
    return (int)(ch - '0');
  }
}
