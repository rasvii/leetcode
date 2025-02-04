package solutions;
/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {

        int len = needle.length() - 1;
        int startIdx = 0;

        while (len < haystack.length()) {
            if (haystack.substring(startIdx, len + 1).equals(needle)) {
                return startIdx;
            }
            len++;
            startIdx++;
        }

        return -1;

    }
}
// @lc code=end
