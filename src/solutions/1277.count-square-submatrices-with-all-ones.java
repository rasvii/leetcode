package solutions;
/*
 * @lc app=leetcode id=1277 lang=java
 *
 * [1277] Count Square Submatrices with All Ones
 */

// @lc code=start
class Solution {
    public int countSquares(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 1) result++;
        }

        for (int i = 1; i < n; i++) {
            if(matrix[0][i] == 1) result++;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }

                result += matrix[i][j];
            }
        }

        return result;

    }
}
// @lc code=end

