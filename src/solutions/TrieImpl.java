package solutions;
/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {

    TrieImpl trie;

    public Trie() {
        trie = new TrieImpl();
    }

    public void insert(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    public boolean startsWith(String prefix) {
        return trie.startsWith(prefix);
    }
}

public class TrieImpl {

    TrieNode root;

    public TrieImpl() {
        this.root = new TrieNode();
    }

    private static class TrieNode {

        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (char letter : word.toLowerCase().toCharArray()) {
            int c = letter - 'a';
            if (curr.children[c] == null) {
                curr.children[c] = new TrieNode();
            }

            curr = curr.children[c];
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (char letter : word.toLowerCase().toCharArray()) {
            int c = letter - 'a';

            if (curr.children[c] == null) {
                return false;
            }

            curr = curr.children[c];
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String word) {
        TrieNode curr = root;

        for (char letter : word.toLowerCase().toCharArray()) {
            int c = letter - 'a';

            if (curr.children[c] == null)
                return false;

            curr = curr.children[c];
        }

        return true;
    }

}
// Map
/*
 * class Trie {
 * 
 * TrieImpl trie;
 * 
 * public Trie() {
 * trie = new TrieImpl();
 * }
 * 
 * public void insert(String word) {
 * trie.insert(word);
 * }
 * 
 * public boolean search(String word) {
 * return trie.search(word);
 * }
 * 
 * public boolean startsWith(String prefix) {
 * return trie.startsWith(prefix);
 * }
 * }
 * 
 * 
 * public class TrieImpl {
 * 
 * TrieNode root;
 * 
 * public TrieImpl() {
 * this.root = new TrieNode();
 * }
 * 
 * private static class TrieNode {
 * 
 * HashMap<Character, TrieNode> children;
 * boolean isEndOfWord;
 * 
 * TrieNode() {
 * children = new HashMap<>();
 * isEndOfWord = false;
 * }
 * }
 * 
 * public void insert(String word) {
 * TrieNode curr = root;
 * 
 * for(char letter : word.toLowerCase().toCharArray()) {
 * if(!curr.children.containsKey(letter)) {
 * curr.children.put(letter, new TrieNode());
 * }
 * 
 * curr = curr.children.get(letter);
 * }
 * 
 * curr.isEndOfWord = true;
 * }
 * 
 * public boolean search(String word) {
 * TrieNode curr = root;
 * 
 * for(char letter : word.toLowerCase().toCharArray()) {
 * 
 * if(!curr.children.containsKey(letter)) {
 * return false;
 * }
 * 
 * curr = curr.children.get(letter);
 * }
 * 
 * return curr.isEndOfWord;
 * }
 * 
 * public boolean startsWith(String word) {
 * TrieNode curr = root;
 * 
 * for(char letter : word.toLowerCase().toCharArray()) {
 * 
 * if(!curr.children.containsKey(letter)) return false;
 * 
 * curr = curr.children.get(letter);
 * }
 * 
 * return true;
 * }
 * }
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
