package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static String largestNumber(int[] nums) {
		String[] asStrings = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			asStrings[i] = "" + nums[i];
		}
		
		Comparator<String> comparator = (a, b) -> (b + a).compareTo(a + b);

		/*
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String str1 = s1 + s2;
				String str2 = s2 + s1;
				return str2.compareTo(str1);
			}
		};
		*/
		Arrays.sort(asStrings, comparator);
		
		if(asStrings[0].equals("0")){
         return "0";
     }

		String largest = new String();
		for (String s : asStrings) {
			largest += s;
		}
		return largest;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		System.out.println(largestNumber(nums));
	}

}
