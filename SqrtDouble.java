package leetcode;

public class SqrtDouble {

	private static String sqrtDouble(double number) {
		boolean isNegative = false;
		
		if (number < 0.0) {
			isNegative = true;
			number = number * -1;
		}
		
		double start = 0;
		double end = number;
		double mid = (start + end) / 2;
		double previousMid = 0;
		double precisionDiff = Math.abs(mid - previousMid);
		double precision = 0.001;

		while ((mid * mid != number) && precisionDiff > precision) {
			if (mid * mid > number) {
				end = mid;
			} else {
				start = mid;
			}
			previousMid = mid; // update the previousMid to mid
			mid = (start + end) / 2;
			precisionDiff = Math.abs(mid - previousMid);
		}
		return mid + (isNegative == true ? "i" : "");
	}

	public static void main(String[] args) {
		System.out.println(sqrtDouble(0.1));
	}
}
