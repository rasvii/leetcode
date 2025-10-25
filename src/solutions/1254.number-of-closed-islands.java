package solutions;
/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] status = new int[m][n];

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) {
                dfs(grid, 0, j);
            }

            if (grid[m - 1][j] == 0) {
                dfs(grid, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 0) {
                dfs(grid, i, n - 1);
            }
        }

        int result = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;

    }

    private void dfs(int[][] grid, int i, int j) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length)
            return;
        if (grid[i][j] == 1 || grid[i][j] == -1)
            return;

        grid[i][j] = -1;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    private void dfsClosedIsland(int[][] grid, int i, int j) {
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)
            return;
        if (grid[i][j] == 1 || grid[i][j] == -1 || grid[i][j] == 2)
            return;

        grid[i][j] = 2;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
// @lc code=end
