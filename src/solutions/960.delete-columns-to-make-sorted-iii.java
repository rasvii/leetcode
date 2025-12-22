package solutions;
/*
 * @lc app=leetcode id=960 lang=java
 *
 * [960] Delete Columns to Make Sorted III
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] strs) {

        int n = strs.length, wordLen = strs[0].length();
        int result = wordLen - 1, k;
        int[] dp = new int[wordLen];

        for (int j = 0; j < wordLen; j++) {
            dp[j] = 1;

            for (int i = 0; i < j; i++) {

                for (k = 0; k < n; k++) {
                    if (strs[k].charAt(i) > strs[k].charAt(j))
                        break;
                }

                if (k == n && dp[i] + 1 > dp[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }

            result = Math.min(result, wordLen - dp[j]);
        }

        return result;

    }
}
// @lc code=end
