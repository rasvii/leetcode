package solutions;
/*
 * @lc app=leetcode id=837 lang=java
 *
 * [837] New 21 Game
 */

// @lc code=start
class Solution {
    public double new21Game(int n, int k, int maxPts) {

        if (k == 0 || n >= k - 1 + maxPts)
            return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0, result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                windowSum += dp[i];
            } else {
                result += dp[i];
            }

            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }

        return result;
    }
}
// @lc code=end
