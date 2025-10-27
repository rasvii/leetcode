package solutions;
/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int res = dfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, res);
                }
            }
        }

        return maxArea;

    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length)
            return 0;
        if (grid[i][j] == 0 || visited[i][j])
            return 0;

        visited[i][j] = true;

        int result = 1 + dfs(grid, i + 1, j, visited) +
                dfs(grid, i - 1, j, visited) +
                dfs(grid, i, j + 1, visited) +
                dfs(grid, i, j - 1, visited);

        return result;
    }
}
// @lc code=end
