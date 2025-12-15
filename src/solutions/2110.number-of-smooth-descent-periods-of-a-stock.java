package solutions;
/*
 * @lc app=leetcode id=2110 lang=java
 *
 * [2110] Number of Smooth Descent Periods of a Stock
 */

// @lc code=start

class Solution {
    public long getDescentPeriods(int[] prices) {

        int n = prices.length;
        int sequence = 0;
        long result = 1;

        for (int i = 1; i < n; i++) {

            if (prices[i - 1] - prices[i] == 1) {
                sequence++;
            } else {
                sequence = 0;
            }
            result += sequence + 1;
        }

        return result;

    }
}

/*
 * class Solution {
 * public long getDescentPeriods(int[] prices) {
 * 
 * int n = prices.length;
 * long[] dp = new long[n];
 * dp[0] = 1;
 * int increment = 0;
 * 
 * for (int i = 1; i < n; i++) {
 * dp[i] = 1;
 * if (prices[i - 1] - prices[i] == 1) {
 * increment++;
 * } else {
 * increment = 0;
 * }
 * dp[i] += dp[i - 1] + increment;
 * }
 * 
 * return dp[n - 1];
 * 
 * }
 * }
 */

// @lc code=end
