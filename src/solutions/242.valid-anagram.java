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

        int[] alphabetCount = new int[26];

        for (char c : t.toCharArray()) {
            alphabetCount[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            if (alphabetCount[c - 'a'] == 0)
                return false;

            alphabetCount[c - 'a']--;
        }

        return true;

    }
}
// @lc code=end
