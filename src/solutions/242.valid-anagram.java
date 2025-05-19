package solutions;
/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabetCount = new int[126];

        for (char c : t.toCharArray()) {
            alphabetCount[c]++;
        }

        for (char c : s.toCharArray()) {
            if (alphabetCount[c] == 0)
                return false;

            alphabetCount[c]--;
        }

        return true;
    }
}
// @lc code=end
