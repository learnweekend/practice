 /* Problem :  Given an integer number(positive/negative), Compute the number of set bits */
public class ComputeParity {
  public static void main(String[] args){
    int number = 200;
    System.out.println("# of set bits in number " + number + " = " + computeParity(number));
    System.out.println("# of set bits in number " + number + " = " + computeParityV2(number));
  }
  /* Calculate the number of set bits in a given Integer
    do & with 1 to check if last bit is set or not, then right shift the number.
     Runtime : O(N) where N = number of bits , Space : O(1) */
  private static int computeParity(int number) {
    if(number == 0) return 0;
    if(number == 1) return 1;
    boolean isNegative = false;
    int count = 0;

    if(number < 0) {
      isNegative = true;
      number = -number;
      count = count + 1; // add one addition set bit for negative numbers.
    }
    while(number != 0) {
      if((number & 1) == 1) {  //number & 1 to check if the bit is set
        count++;
      }
      number = number >> 1; // right shift number
    }
    return count;
  }

  /* Calculate the number of set bits in a given Integer
     do & with (number - 1)
     Runtime : O(N) where N = number of SET bits and its more efficient, Space : O(1) */

  private static int computeParityV2(int number) {
    if(number == 0) return 0;
    if(number == 1) return 1;
    boolean isNegative = false;
    int count = 0;

    if(number < 0) {
      isNegative = true;
      number = -number;
      count = count + 1; // add one additional set bit for negative numbers.
    }
    while(number != 0) { // loops only the number of set bits
      count = count + 1;
      number = number & (number - 1);
    }
    return count;
  }
}
