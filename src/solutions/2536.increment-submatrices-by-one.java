package solutions;
/*
 * @lc app=leetcode id=2536 lang=java
 *
 * [2536] Increment Submatrices by One
 */

// @lc code=start
class Solution {
    // TC: O(q + n^2)
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] diff = new int[n + 1][n + 1];

        for (int[] query : queries) {
            int r1 = query[0], c1 = query[1], r2 = query[2], c2 = query[3];

            diff[r1][c1]++;
            diff[r2 + 1][c1]--;
            diff[r1][c2 + 1]--;
            diff[r2 + 1][c2 + 1]++;
        }

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int above = i > 0 ? mat[i - 1][j] : 0;
                int left = j > 0 ? mat[i][j - 1] : 0;
                int diag = i > 0 && j > 0 ? mat[i - 1][j - 1] : 0;

                mat[i][j] = diff[i][j] + above + left - diag;
            }
        }

        return mat;
    }
}

// First brute force attempt
/*
 * class Solution {
 * public int[][] rangeAddQueries(int n, int[][] queries) {
 * 
 * int[][] mat = new int[n][n];
 * 
 * 
 * for(int[] query : queries) {
 * 
 * for(int i = query[0]; i <= query[2]; i++) {
 * for(int j = query[1]; j <= query[3]; j++) {
 * mat[i][j]++;
 * }
 * }
 * }
 * 
 * 
 * return mat;
 * }
 * }
 */
// @lc code=end
