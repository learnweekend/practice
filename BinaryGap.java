/*
Problem : BinaryGap
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones
at both ends in the binary representation of N. For example, number 9 has binary representation 1001 and contains
a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps:
one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary
gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
*/
public class BinaryGap {
  public static void main(String args[]) {
    int number = 529; //1041; //9; 20;
    int maxBinaryGap = getMaxBinaryGap(number);
    System.out.println("Maximum binary gap of number " + number + " (" +Integer.toBinaryString(number) +") = " +maxBinaryGap);
  }
/*
Solution 1: Do a bitwise & with 1 and check if the result is 0 or 1. Right shift the number to get next bit
Runtime : O(Log N) -> number of bits, Space : O(1)
*/
  private static int getMaxBinaryGap(int number) {
    if(number <= 0)
      throw new IllegalArgumentException("Number cannot be negative...or zero");
      int gap = 0;
      int maxGap = 0;
      int count = 0;
    while(count == 0) { //continue from right until we get 1
      count = number & 1;
      number = number >> 1;
    }
     count = 0;
     while(number > 0) { // loop until number > 0
       count = number & 1;
       if(count == 0) {
         gap = gap + 1;  // increment gap when result is zero
         if(maxGap < gap)
            maxGap = gap;  //update the maxGap
       } else {
         gap = 0; // reset the gap to 0 when the result is 1
       }
      number = number >> 1;
     }
     return maxGap;
  }
}
