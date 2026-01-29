package solutions;
/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length, n=matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            result = Math.max(dp[0][i], result);
            
        }

        for(int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1: 0;
            result = Math.max(dp[i][0], result);
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') continue;
                int min = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                dp[i][j] = min == 0 ? 1 : min + 1;
                result = Math.max(result, dp[i][j]);
            }
        }


        return result * result;
        
    }
}
// @lc code=end

