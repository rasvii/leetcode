package solutions;
/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    // 2D array
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    // 1D Array - We only need the values of current and prev row to calculate the
    // paths.
    public int uniquePathsSol2(int m, int n) {

        int[] paths = new int[n];

        for (int i = 0; i < n; i++) {
            paths[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[j] = paths[j - 1] + paths[j];
            }
        }

        return paths[n - 1];
    }
}
// @lc code=end
