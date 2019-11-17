package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PrefixTreeMap {

	/** Initialize your data structure here. */
	private TrieNode root;

	public PrefixTreeMap() {
		this.root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;

		for (char ch : word.toCharArray()) {
			TrieNode child = curr.children.get(ch);
			if (child == null) {
				child = new TrieNode();
				curr.children.put(ch, child);
			}
			curr = child;
		}
		curr.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = search(root, word, 0);
		if (node == null)
			return false;
		return node.isWord;
	}

	private static TrieNode search(TrieNode node, String word, int depth) {
		if (depth == word.length())
			return node;
		char ch = word.charAt(depth);
		TrieNode curr = node.children.get(ch);
		if (curr == null) {
			return null;
		}
		return search(curr, word, depth + 1);
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		return search(root, prefix, 0) != null;
	}

	private static class TrieNode {
		private boolean isWord;
		private Map<Character, TrieNode> children;

		public TrieNode() {
			this.children = new HashMap<>();
		}
	}

	public static void main(String[] args) {
		PrefixTreeMap trie = new PrefixTreeMap();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}
}
