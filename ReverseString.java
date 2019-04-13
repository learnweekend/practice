package leetcode;

public class ReverseString {

	public static String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		reverse(s, s.length() - 1, sb);
		return sb.toString();
	}

	public static void reverse(String s, StringBuilder sb) {
		if (s == null || s.length() == 0)
			return;
		sb.append(s.charAt(s.length() - 1));
		reverse(s.substring(0, s.length() - 1), sb);
	}

	public static void reverse(String s, int lastIndex, StringBuilder sb) {
		if (lastIndex < 0)
			return;
		sb.append(s.charAt(lastIndex));
		reverse(s, lastIndex - 1, sb);
	}

	public static void main(String[] args) {
		String s = "ravinder";
		System.out.println(reverseString(s));
	}
}
