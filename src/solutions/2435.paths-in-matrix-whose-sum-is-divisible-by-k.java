package solutions;
/*
 * @lc app=leetcode id=2435 lang=java
 *
 * [2435] Paths in Matrix Whose Sum Is Divisible by K
 */

// @lc code=start
class Solution {
    public int numberOfPaths(int[][] grid, int k) {

        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        int mod = 1000_000_007;

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int s = 0; s < k; s++) {
                    int modSum = (s + grid[i][j]) % k;
                    if (j > 0)
                        dp[i][j][modSum] += dp[i][j - 1][s];
                    if (i > 0)
                        dp[i][j][modSum] += dp[i - 1][j][s];
                    dp[i][j][modSum] %= mod;
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }

}
// @lc code=end
