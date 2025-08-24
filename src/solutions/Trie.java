/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {

    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        trie.insertAll(words);

        int row = board.length, col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, "", trie);
            }
        }

        return result.stream().collect(Collectors.toList());
    }

    public void dfs(char[][] board, int row, int col, String str, Trie trie) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length)
            return;

        char c = board[row][col];

        if (c == '#')
            return;

        str += c;
        board[row][col] = '#';

        if (!trie.startsWith(str)) {
            board[row][col] = c;
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }

        dfs(board, row + 1, col, str, trie);
        dfs(board, row - 1, col, str, trie);
        dfs(board, row, col + 1, str, trie);
        dfs(board, row, col - 1, str, trie);

        board[row][col] = c;
    }

}

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }

    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (char letter : word.toCharArray()) {
            if (curr.children[letter - 'a'] == null)
                return false;
            curr = curr.children[letter - 'a'];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char letter : prefix.toCharArray()) {
            if (curr.children[letter - 'a'] == null)
                return false;

            curr = curr.children[letter - 'a'];
        }

        return true;
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (char letter : word.toCharArray()) {
            int c = letter - 'a';

            if (curr.children[c] == null) {
                curr.children[c] = new TrieNode();
            }

            curr = curr.children[c];
        }

        curr.isEndOfWord = true;
    }

    public void insertAll(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }
}

// optimized
/*
 * class Solution {
 * 
 * Set<String> result = new HashSet<>();
 * 
 * public List<String> findWords(char[][] board, String[] words) {
 * 
 * Trie trie = new Trie();
 * trie.insertAll(words);
 * 
 * int row = board.length, col = board[0].length;
 * 
 * for(int i = 0; i < row; i++) {
 * for(int j = 0; j < col; j++) {
 * dfs(board, i, j, trie.root);
 * }
 * }
 * 
 * return result.stream().collect(Collectors.toList());
 * }
 * 
 * 
 * public void dfs(char[][] board, int row, int col, TrieNode trie) {
 * if(row < 0 || col < 0 || row == board.length || col == board[0].length)
 * return;
 * 
 * char c = board[row][col];
 * 
 * if(c == '#' || trie== null || trie.children[c - 'a'] == null) return;
 * 
 * trie = trie.children[c - 'a'];
 * 
 * if (trie.word != null) {
 * result.add(trie.word);
 * trie.word = null;
 * }
 * 
 * board[row][col] = '#';
 * 
 * dfs(board, row+1, col, trie);
 * dfs(board, row-1, col, trie);
 * dfs(board, row, col+1, trie);
 * dfs(board, row, col-1, trie);
 * 
 * board[row][col] = c;
 * }
 * 
 * }
 * 
 * 
 * 
 * public class Trie {
 * 
 * TrieNode root;
 * 
 * public Trie() {
 * root = new TrieNode();
 * }
 * 
 * 
 * 
 * public void insert(String word) {
 * TrieNode curr = root;
 * 
 * for(char letter : word.toCharArray()) {
 * int c = letter - 'a';
 * 
 * if(curr.children[c] == null) {
 * curr.children[c] = new TrieNode();
 * }
 * 
 * curr = curr.children[c];
 * }
 * 
 * curr.word = word;
 * }
 * 
 * public void insertAll(String[] words) {
 * for(String word: words) {
 * insert(word);
 * }
 * }
 * }
 * 
 * class TrieNode {
 * TrieNode[] children;
 * String word;
 * 
 * public TrieNode() {
 * children = new TrieNode[26];
 * word = null;
 * }
 * }
 */

// @lc code=end
