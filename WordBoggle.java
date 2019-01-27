package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBoggle {
	
	/**
	 *  Runtime : O(N * M * 8 ^ s) | space : O(N  * M + ws)
	 *  where s = length of longest word, w = number of words
	 */
	public static List<String> wordBoggle(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();  // final result
		Set<String> finalWords = new HashSet<>(); // to store the unique words
		boolean[][] visited = new boolean[board.length][board[0].length]; // to mark the visited cells

		SuffixTree suffixTree = new SuffixTree();  // add the words to the trie
		for (String word : words) 
			suffixTree.addWord(word);
		
		for (int i = 0; i < board.length; i++)   // iterate through every cell and explore
			for (int j = 0; j < board[0].length; j++) 
				explore(i, j, board, suffixTree.root, visited, finalWords);
				
		result = new ArrayList<>(finalWords);  // convert the set to list
		return result;
	}

	private static void explore(int i, int j, char[][] board, TrieNode trie, boolean[][] visited,
			Set<String> finalWords) {

		if (visited[i][j])  // if the cell is visited, then ignore it
			return;

		char letter = board[i][j];  // get the char at the current cell

		if (!trie.children.containsKey(letter))  // if the starting letter is not present in Trie, ignore it
			return;

		visited[i][j] = true;  // mark the cell as visited

		TrieNode trieNode = trie.children.get(letter);  // get the node at guven character

		if (trieNode.isWord)   // check if the node is end of word
			finalWords.add(trieNode.word);  // add the word to the final result

		List<int[]> neighbors = getNeighbors(i, j, board);  //get the neighbors and explore
		for (int[] neighbor : neighbors) 
			explore(neighbor[0], neighbor[1], board, trieNode, visited, finalWords);

		visited[i][j] = false;  // unmark the visited cell.
	}

	private static List<int[]> getNeighbors(int i, int j, char[][] board) {
		List<int[]> neighbors = new ArrayList<>();
		
		if (i > 0 && j > 0) {
			neighbors.add(new int[] { i - 1, j - 1 });
		}
		if (i > 0 && j < board[0].length - 1) {
			neighbors.add(new int[] { i - 1, j + 1 });
		}
		if (i < board.length - 1 && j < board[0].length - 1) {
			neighbors.add(new int[] { i + 1, j + 1 });
		}
		if (i < board.length - 1 && j > 0) {
			neighbors.add(new int[] { i + 1, j - 1 });
		}
		if (i > 0) {
			neighbors.add(new int[] { i - 1, j });
		}
		if (i < board.length - 1) {
			neighbors.add(new int[] { i + 1, j });
		}
		if (j > 0) { 
			neighbors.add(new int[] { i, j - 1 });
		}
		if (j < board[0].length - 1) {
			neighbors.add(new int[] { i, j + 1 });
		}
		return neighbors;
	}

	public static void main(String[] args) {

		char[][] board = new char[][] 
			{ 
				{ 't', 'h', 'i', 's', 'i', 's', 'a' }, 
				{ 's', 'i', 'm', 'p', 'l', 'e', 'x' },
				{ 'b', 'x', 'x', 'x', 'x', 'e', 'b' }, 
				{ 'x', 'o', 'g', 'g', 'l', 'x', 'o' },
				{ 'x', 'x', 'x', 'D', 'T', 'r', 'a' }, 
				{ 'R', 'E', 'P', 'E', 'A', 'd', 'x' },
				{ 'x', 'x', 'x', 'x', 'x', 'x', 'x' }, 
				{ 'N', 'O', 'T', 'R', 'E', '-', 'P' },
				{ 'x', 'x', 'D', 'E', 'T', 'A', 'E' }, 
			};
				
		String[] words = new String[] { "this", "is", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED" };

		System.out.println(wordBoggle(board, words));
	}

	private static class SuffixTree {
		private TrieNode root;

		public SuffixTree() {
			root = new TrieNode();
		}

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
			curr.word = word;
		}
	}

	private static class TrieNode {
		private Map<Character, TrieNode> children;
		private boolean isWord;
		private String word;

		public TrieNode() {
			this.children = new HashMap<>();
			this.isWord = false;
		}
	}
}
