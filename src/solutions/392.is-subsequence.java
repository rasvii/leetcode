package solutions;
/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int first = 0;
        int second = 0;

        while (first < s.length() && second < t.length()) {
            if (s.charAt(first) == t.charAt(second)) {
                first++;
                second++;
            } else {
                second++;
            }
        }

        if (first == s.length()) {
            return true;
        }

        return false;
    }
}
// @lc code=end
