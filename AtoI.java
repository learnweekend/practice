/*
 problem : Implement atoi to convert a string to an integer.
 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 and interprets them as a numerical value.
 The string can contain additional characters after those that form the integral number,
 which are ignored and have no effect on the behavior of this function.
 If the first sequence of non-whitespace characters in str is not a valid integral number,
 or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 If no valid conversion could be performed, a zero value is returned.
 If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

 public class AtoI {
   public static void main(String[] args) {
     System.out.println("int value = " + atoi(" -0012a42")); // -12
     System.out.println("int value = " + atoi("1")); // 1
     System.out.println("int value = " + atoi("+234654")); // 234654
     System.out.println("int value = " + atoi("-2147483648")); //-2147483648
     System.out.println("int value = " + atoi("-9223372036854775809")); // -2147483648
     System.out.println("int value = " + atoi("-2147483647")); // -2147483647
     System.out.println("int value = " + atoi("2147483648")); // 2147483647
   }

   public static int atoi(String str) {
     if(str == null) return 0;
     str = str.trim(); // remove any leading white spaces
     if(str.length() == 0) return 0;

     int isPositive = 1;
     long result = 0L;
     int startIndex = 0;

     if(str.startsWith("+") || str.startsWith("-"))
         startIndex++; // increment the startIndex if + or - is present

     if(str.startsWith("-"))
         isPositive = -1;

     for(int i = startIndex; i < str.length(); i++) {
       char ch = str.charAt(i);

       if(ch >= '0' && ch <= '9'){  // make sure the char is valid digit
         result = result * 10 + ch - '0'; // calculate the int value

         if(result * isPositive >= Integer.MAX_VALUE)
             return Integer.MAX_VALUE;

         if(result * isPositive <= Integer.MIN_VALUE)
             return Integer.MIN_VALUE;
       } else {
         break;
       }
     }
     return (int) result * isPositive;
   }
 }
