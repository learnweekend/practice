 /* Problem :  Given an integer number(positive/negative), Compute the number of set bits */
public class ComputeParity {
  public static void main(String[] args){
    int number = 7;
    System.out.println("# of set bits in number " + number + " = " + computeParity(number));
  }
  /* Calculate the number of set bits in a given Integer */
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
}
