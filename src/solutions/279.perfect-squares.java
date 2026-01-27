package solutions;
/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
// @lc code=end
