 /*
  problem : Reverse Words
  Given an input string, reverse the string word by word.
  For example,  Given s = "the sky is blue",  return "blue is sky the".
  */

  public class ReverseWords {
    public static void main(String[] args) {
      String str = "the sky is blue";
      System.out.println("Reverse words = " + reverseWordsV1(str));
      System.out.println("Reverse words = " + reverseWordsV2(str));
    }

    public static String reverseWordsV1(String s) {
      String[] strArr = s.split("\\s+");
		  StringBuilder builder = new StringBuilder();
		  for (int i = strArr.length - 1; i >= 0; i--) {
			    builder.append(strArr[i]).append(" ");
		  }
		  return builder.toString().trim();
    }

    public static String reverseWordsV2(String s) {
      if(s == null) return null;
      String[] words = s.split("\\s+");
      int start = 0;
      int end = words.length - 1;

      while(start <= end) {
        swap(words, start, end);
        start++;
        end--;
      }
      StringBuilder sb = new StringBuilder();
      for(String str : words){
        sb.append(str);
        sb.append(" ");
    }
    return sb.toString().trim();
   }

    public static void swap(String[] words, int i, int j){
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
  }
