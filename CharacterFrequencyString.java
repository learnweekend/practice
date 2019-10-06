import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *   Given a String str, return the formatted string based on the following rules.
 *   1. Higher frequency lettr should be come first 
 *   2. If the frequency matches, then characters should be in sorted order.
 *   
 *   Exmple : input : "javacbbxfindcatxdiamond",  output : "aaaadddbbcciinnxxfjmotv"
 *
 */
public class CharacterFrequencyString {
	
	/**
	 * Solution :  Take a frequency map and count the characters occurences
	 * Covert to LinkedList and sort based on values.
	 * Write custom comparator to sort based on characters if frequency matches"
	 * Iterate the list and append the leeters to StringBuilder and return the result as String
	 */
	public static String getFormattedOutput(String str) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1,
						Map.Entry<Character, Integer> o2) {
				if (o2.getValue() - o1.getValue() == 0) {   
					return o1.getKey() - o2.getKey();   // sort characters ASC order
				} else {
					return o2.getValue() - o1.getValue();  // sort count by DESC order
				}
			}
		});

		StringBuilder sb = new StringBuilder();

		for (Map.Entry<Character, Integer> entry : list) {
			int count = entry.getValue() - 1;
			while (count >= 0) {
				sb.append(entry.getKey());
				count--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getFormattedOutput("javacbbxfindcatxdiamond")); // "aaaadddbbcciinnxxfjmotv"
	}
}
