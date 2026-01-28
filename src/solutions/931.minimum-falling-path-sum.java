package solutions;
/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        for (int i = 1; i < m; i++) {

            for (int j = 0; j < n; j++) {

                matrix[i][j] += Math.min(matrix[i - 1][j],
                        Math.min(matrix[i - 1][Math.max(0, j - 1)], matrix[i - 1][Math.min(j + 1, n - 1)]));

            }
        }

        return Arrays.stream(matrix[m - 1]).min().getAsInt();

    }
}
// @lc code=end
