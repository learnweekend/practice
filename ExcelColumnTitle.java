package leetcode;

public class ExcelColumnTitle {
	
	/** https://leetcode.com/problems/excel-sheet-column-title/
	 * 
	 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
	 * For example:
	 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
	 */
	public static String excelColumnTitle(int number) {
		if (number < 0)
			throw new IllegalArgumentException("number must be positive");

		StringBuilder sb = new StringBuilder();

		if (number == 0)
			return "";

		while (number > 0) {
			int remainder = number % 26;
			if (remainder == 0) {
				sb.append('Z');
				number = (number / 26) - 1;
			} else {
				number = number / 26;
				sb.append((char) (remainder - 1 + 'A'));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(excelColumnTitle(26)); // Z
		System.out.println(excelColumnTitle(52)); // AZ
		System.out.println(excelColumnTitle(78)); // BZ
		System.out.println(excelColumnTitle(25)); // Y
	}
}
