package leetcode;

public class TrieUsingArray {

	private TrieNode root;

	public TrieUsingArray() {
		this.root = new TrieNode();
	}

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

	/**
	 * Search a given word
	 */
	public boolean search(String word) {
		 TrieNode node = get(root, word, 0);
       if(node == null) return false;
       return node.isWord;
	}

	public boolean startsWith(String prefix) {
		return get(root, prefix, 0) != null;
	}

	private TrieNode get(TrieNode node, String word, int depth) {
		if (node == null)
			return null;

		if (depth == word.length())
			return node;

		char ch = word.charAt(depth);
		
		return get(node.children[ch], word, depth + 1);
	}

	private static class TrieNode {
		private TrieNode[] children;
		private boolean isWord;
		
		public TrieNode() {
			this.children = new TrieNode[128];
		}
	}

	public static void main(String[] args) {
		TrieUsingArray trie = new TrieUsingArray();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
	}

}
