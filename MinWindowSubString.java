import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {
	
	public static String minWindowFast(String s, String t) {

		if (s.length() == 0 || t.length() == 0)
			return "";

		Map<Character, Integer> tCharCount = new HashMap<>();
		
		for (int i = 0; i < t.length(); i++) {   // character count map for string "T"
			Integer count = tCharCount.getOrDefault(t.charAt(i), 0);
			tCharCount.put(t.charAt(i),  count + 1);
		}

		int left = 0; int right = 0;  // move with two pointers, left, right from 0

		int minStart = 0;  // holds the startIndex of the string "S"

		int minLength = Integer.MAX_VALUE;  // minimum length of window

		int totalCounts = t.length();  // length of string "T"

		while (right < s.length()) {
			char ch = s.charAt(right);
			
			if (tCharCount.containsKey(ch)) {
				if(tCharCount.get(ch) > 0)
					totalCounts--;
				tCharCount.put(ch, tCharCount.get(ch) - 1);
			}

			right++;  // increment right pointer

			while (totalCounts == 0) {   // check for all characters match
				if (right - left < minLength) {
					minLength = right - left;
					minStart = left;
				}

				if (tCharCount.containsKey(s.charAt(left))) {
					tCharCount.put(s.charAt(left), tCharCount.get(s.charAt(left)) + 1);
					if (tCharCount.get(s.charAt(left)) > 0) {
						totalCounts++;
					}
				}
				left++;   // reduce the windown, move left pointer forward
			}
		}
		if (minLength == Integer.MAX_VALUE)
			return "";

		return s.substring(minStart, minStart + minLength);
	}

	// brute-force solution O(N^3)
	public static String minWindow(String s, String t) {
		int minLength = Integer.MAX_VALUE;
		String minString = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				if (j - i >= t.length()) {
					String substring = s.substring(i, j);
					boolean isPresent = checkMatch(substring, t);
					if (isPresent) {
						if (substring.length() < minLength) {
							minLength = substring.length();
							minString = substring;
						}
					}
				}
			}
		}
		return minString;
	}

	private static boolean checkMatch(String sub, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0));
			map.put(ch, map.get(ch) + 1);
		}
		for (int k = 0; k < sub.length(); k++) {
			char ch = sub.charAt(k);
			if (map.isEmpty())
				return true;
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0)
					map.remove(ch);
			}
		}
		return map.isEmpty();
	}

	public static void main(String[] args) {
		String s = "sshcxyfgecymhhpmjrfjlmiwkaunetxwleajdfrjhrxrymdkdltoxbmjdhwhatfoafzfkqquhnlhcqrfdmwdnkmtrlaueiignjlazdwirhrtzladxygnjugcfiymqgsgpggqjcaclsxmdarcyzpjuxobimnytigkqodzsdedxbscblfclwlhuzkcmychiltyzwzscdxbhpekdlmojaxdbhhphmwpxsnwqposumwbdcognawycvcefltmxqcukrraihtdvrgztuhivggxbkdgwxvtpxozqhzzoueklklgfuocaxbehfkdehztepsxwtymocybojiveyzexbkfixkmelhjabiyuinkmloavywbyvhwysbipnwtzdebgocbwpniadjxbhyaegwdaznpokkppptwdvzckokksvkteivjqtoqubfjnqadhtzmoaoaobngwxabfxmwramlduurmxutqvfhvwhjxusttuwzrixikluqfqhtndmeaulvsugprakkuhjmriueuqubhdvwgjagfndxklmbmzlgixuzhpfbhzfqccnknnqtdvsphhqvgdboaypipvlwwsnzualipebuz";
		String p = "tjiazd";
		System.out.println(minWindow(s, p));      //jlazdwirhrt
		System.out.println(minWindowFast(s, p));  //jlazdwirhrt
	}
}

