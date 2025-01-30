package solutions;
/*
 * @lc app=leetcode id=1768 lang=java
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {

        int longerLength = Math.max(word1.length(), word2.length());
        int shorterWordLength = Math.min(word1.length(), word2.length());

        String longWord = word1;
        if (word2.length() > word1.length()) {
            longWord = word2;
        }

        StringBuffer result = new StringBuffer();

        int i = 0;

        while (i < shorterWordLength) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }

        if ((longerLength - i) != 0) {
            while (i < longWord.length()) {
                result.append(longWord.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}
// @lc code=end
