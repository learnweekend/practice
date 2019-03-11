package leetcode;

/** https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 */
public class ExcelColumnNumber {

	public static int excelColumnNumber(String title) {
		int result = 0;

		for (int i = 0; i < title.length(); i++) {
			result += (title.charAt(i) - 64) * Math.pow(26, title.length() - 1 - i);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(excelColumnNumber("AB"));
		System.out.println(excelColumnNumber("AZ"));
	}
}
