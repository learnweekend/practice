/*
 Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
 Example
 For s = "abacabad", the output should be firstNotRepeatingCharacter(s) = 'c'.
 There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.
 For s = "abacabaabacaba", the output should be firstNotRepeatingCharacter(s) = '_'.
 There are no characters in this string that do not repeat.
 */
 import java.util.*;

 public class FirstNonRepeatingCharacter {

  public static void main(String[] args) {
    String str = "abacabad";
    System.out.println(firstNonRepeatingCharacterV1(str));
    System.out.println(firstNonRepeatingCharacterV2(str));
  }
  /* Solution 1: Using HashMap
  1. Loop the string and check if the character is present in map, if present, increment the count otherwise add it.
  2. After the iteration loop through traverse the string and check the count in the map and return if count is one.
  Runtime : O(N), Need to loop the str TWICE  Space : O(N).
  */
  private static char firstNonRepeatingCharacterV1(String str) {
    if(str == null) return '_';
    Map<Character, Integer> charCountMap = new HashMap<>();
    Set<Character> linkedHashSet = new LinkedHashSet<>();

    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(charCountMap.containsKey(ch)) {
        charCountMap.put(ch, charCountMap.get(ch) + 1); // do not need this step
      } else {
        charCountMap.put(ch, 1);
      }
    }
    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(charCountMap.get(ch) == 1) {
        return ch;
      }
    }
    return '_';
  }
  /* Solution 2:  Using HashMap and LinkedHashSet
  1. Loop the string and check if the character is present in map, if present, remove from "linkedHashSet".
  2. If not present, then add to map and linkedHashSet.
  3. After the iteration the FIRST element in the linkedHashSet will be the firstNonRepeatingCharacter.
  Runtime : O(N), Need to loop the str only ONCE, Space : O(N).
  */
  private static char firstNonRepeatingCharacterV2(String str) {
    if(str == null) return '_';
    Map<Character, Integer> charCountMap = new HashMap<>();
    Set<Character> linkedHashSet = new LinkedHashSet<>();

    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(charCountMap.containsKey(ch)) {
        charCountMap.put(ch, charCountMap.get(ch) + 1); // do not need this step
        linkedHashSet.remove(ch);
      } else {
        charCountMap.put(ch, 1);
        linkedHashSet.add(ch);
      }
    }
    //The first character in the linkedHashSet will be the firstNonRepeatingCharacter.
    Iterator<Character> itr = linkedHashSet.iterator();
    if(itr.hasNext()){
      return itr.next();
    } else {
      return '_';
    }
  }

}
