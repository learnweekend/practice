package leetcode;

/**
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth
 * second-level revision of the second first-level revision.
 * 
 * You may assume the default revision number for each level of a version number to be 0. For
 * example, version number 3.4 has a revision number of 3 and 4 for its first and second level
 * revision number. Its third and fourth level revision number are both 0.
 * 
 * Example 1:
 * 
 * Input: version1 = "0.1", version2 = "1.1" Output: -1
 * 
 * Example 2:
 * 
 * Input: version1 = "1.0.1", version2 = "1" Output: 1
 * 
 * Example 3:
 * 
 * Input: version1 = "7.5.2.4", version2 = "7.5.3" Output: -1
 * 
 * Example 4:
 * 
 * Input: version1 = "1.01", version2 = "1.001" Output: 0 Explanation: Ignoring leading zeroes, both
 * “01” and “001" represent the same number “1”
 *
 */
public class CompareVersions {

	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int size1 = v1.length;
		int size2 = v2.length;

		int index1 = 0;
		int index2 = 0;

		while (index1 < size1 && index2 < size2) {
			int result = compare(v1, v2, index1++, index2++);
			if (result != 0)
				return result;
		}

		while (index1 < size1) {
			if (Integer.valueOf(v1[index1]) != 0)
				return 1;
			index1++;
		}

		while (index2 < size2) {
			if (Integer.valueOf(v2[index2]) != 0)
				return -1;
			index2++;
		}
		return 0;
	}

	private static int compare(String[] v1, String[] v2, int index1, int index2) {
		int value1 = Integer.valueOf(v1[index1]);
		int value2 = Integer.valueOf(v2[index2]);

		if (value1 == value2)
			return 0;
		return value1 > value2 ? 1 : -1;
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("1.1", "1.0")); // 1
		System.out.println(compareVersion("0.1", "1.1")); // -1
		System.out.println(compareVersion("1.0.1", "1")); // 1
		System.out.println(compareVersion("0.1", "1.1")); // -1
		System.out.println(compareVersion("01", "1")); // 0
		System.out.println(compareVersion("1.2", "1.10")); // -1
		System.out.println(compareVersion("1", "0")); // 1
		System.out.println(compareVersion("1.0", "1")); // 0
		System.out.println(compareVersion("1.0.1", "1")); // 1
	}

}
