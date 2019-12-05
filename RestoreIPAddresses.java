package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address
 * combinations.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {

	public static List<String> restoreIpAddresses(String input) {
		if (input == null || input.length() == 0 || input.length() < 4 || input.length() > 12) // input validation
			return new ArrayList<String>();

		List<String> res = new ArrayList<>();
		restoreIpAddresses(input, "", 0, 0, res);
		return res;
	}

	private static void restoreIpAddresses(String input, String curS, int index, int segments, List<String> result) {

		if (index == input.length() && segments == 4) { // valid base case
			result.add(curS.substring(0, curS.length() - 1)); // exclude the dot at the end -1
			return;
		}

		if (index == input.length() || segments == 4) // invalid case
			return;

		char c = input.charAt(index);

		if (c == '0') { // add . and increment segment
			restoreIpAddresses(input, curS + c + ".", index + 1, segments + 1, result);
		} else {
			for (int i = 1; i <= 3 && index + i <= input.length(); i++) {
				String str = input.substring(index, index + i);
				int val = Integer.parseInt(str);

				if (val >= 0 && val <= 255)
					restoreIpAddresses(input, curS + val + ".", index + i, segments + 1, result);
				else
					break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135")); //
	}
}
