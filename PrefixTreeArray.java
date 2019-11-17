package leetcode;

public class PrefixTreeArray {

	/** Initialize your data structure here. */
	private TrieNode root;

	public PrefixTreeArray() {
		this.root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;

		for (char ch : word.toCharArray()) {
			TrieNode child = curr.children[ch];
			if (child == null) {
				child = new TrieNode();
				curr.children[ch] = child;
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
		TrieNode curr = node.children[ch];
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
		private TrieNode[] children;

		public TrieNode() {
			this.children = new TrieNode[128];
		}
	}

	public static void main(String[] args) {
		PrefixTreeArray trie = new PrefixTreeArray();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}
}
