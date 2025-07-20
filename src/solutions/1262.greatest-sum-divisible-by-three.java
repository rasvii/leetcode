package solutions;
/*
 * @lc app=leetcode id=1262 lang=java
 *
 * [1262] Greatest Sum Divisible by Three
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int a : nums) {
            for (int i : Arrays.copyOf(dp, dp.length)) {
                int remainder = (i + a) % 3;
                dp[remainder] = Math.max(dp[remainder], i + a);
            }
        }

        return dp[0];
    }
}
// @lc code=end
