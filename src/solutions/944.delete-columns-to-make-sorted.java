package solutions;
/*
 * @lc app=leetcode id=944 lang=java
 *
 * [944] Delete Columns to Make Sorted
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] strs) {

        int n = strs.length;
        int wordLen = strs[0].length();

        int result = 0;

        for (int i = 0; i < wordLen; i++) {

            for (int j = 1; j < n; j++) {

                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}
// @lc code=end
