package leetcode;

import java.util.HashMap;
import java.util.Map;

/**'https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word)
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z
 * or .. A . means it can represent any one letter.
 * 
 * Example:
 * 
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false search("bad") -> true
 * search(".ad") -> true search("b..") -> true
 * 
 * Note: You may assume that all words are consist of lowercase letters a-z.
 */
class WordDictionary {
	
	private TrieNode root;
	
   /** Initialize your data structure here. */
   public WordDictionary() {
       root = new TrieNode();
   }
   
   /** 
    * Adds a word into the data structure. 
    */
	public void addWord(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = curr.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				curr.children.put(ch, node);
			}
			curr = node;
		}
		curr.isWord = true;
	}

   /** Returns if the word is in the data structure. 
    * A word could contain the dot character '.' to represent any one letter. 
    */
	public boolean search(String word) {
		TrieNode curr = root;
		return search(curr, 0, word);
	}
	
	/** 
	 * Search the full word with . (eny character match).
	 * Recursive solution
	 */
	private boolean search(TrieNode node, int start, String word) {
		if (start == word.length()) {
			return node.isWord;
		}
		char ch = word.charAt(start);
		if (ch == '.') {
			for (char c : node.children.keySet()) {
				return search(node.children.get(c), start + 1, word);
			}
		} else {
			if (node.children.get(ch) == null)
				return false;
			else
				return search(node.children.get(ch), start + 1, word);
		}
		return false;
	}
	
   private static class TrieNode {
   		private Map<Character, TrieNode> children;
   		private boolean isWord;
   		
   		public TrieNode() {
   			this.children = new HashMap<>();
   			this.isWord = false;
   		}
   }
   
   public static void main(String[] args) {
		WordDictionary dictionary = new WordDictionary();
		dictionary.addWord("bad");
		dictionary.addWord("dad");
		dictionary.addWord("mad");
		System.out.println(dictionary.search("pad")); //-> false
		System.out.println(dictionary.search("bad")); //-> true
		System.out.println(dictionary.search(".ad")); // -> true
		System.out.println(dictionary.search("b..")); // -> true
	}
}
