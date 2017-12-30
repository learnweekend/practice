package math;

 /*
  * Given a number x, determine whether the given number is Armstrong number or not. 
  * A positive integer of n digits is called an Armstrong number of order n (order is number of digits) if.
  * 153 is an Armstrong number. 1*1*1 + 5*5*5 + 3*3*3 = 153
  * Input : 1634, output : true - 1*1*1*1 + 6*6*6*6 + 3*3*3*3 + 4*4*4*4 = 1634
  */
public class Armstrong {
	
	private static boolean isArmstrong(int number) {
		int originalVal = number;
		int length = String.valueOf(number).length();
		if(number < 0) throw new IllegalArgumentException();
		int myvalue = 0;
		
		while(number > 0) {
			int remainder = number % 10;
			myvalue += power(remainder, length);
			number = number / 10;		
		}
		return (myvalue == originalVal);
	}
	
	private static int power(int x, int y) {
		if( y == 0 ) return 1;
		if (y == 1) return x;
		if(x == 0) return 0;
		
		if(y % 2 == 0) {
			int result = power(x, y/2);
			return result * result;
		}
		else {
			int result = power(x, y/2);
			return x * result * result;
		}
	}

	public static void main(String[] args) {
		System.out.println(isArmstrong(153));
		System.out.println(isArmstrong(371));
		System.out.println(isArmstrong(1634));
		System.out.println(isArmstrong(1253));
	}

}
