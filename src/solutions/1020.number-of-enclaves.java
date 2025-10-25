package solutions;
/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] grid) {

        int count = 0;
        int m = grid.length, n = grid[0].length;
        int[][] status = new int[m][n];

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }

            if (grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }

        int result = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;

    }

    private void dfs(int[][] grid, int i, int j) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length)
            return;
        if (grid[i][j] == 0 || grid[i][j] == -1)
            return;

        grid[i][j] = -1;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
// @lc code=end
