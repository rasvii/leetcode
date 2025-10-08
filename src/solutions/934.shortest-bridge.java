package solutions;
/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q, visited, moves);
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }

        }

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {

                int[] cur = q.poll();

                for (int[] move : moves) {

                    int row = cur[0] + move[0];
                    int col = cur[1] + move[1];

                    if (row == -1 || row == grid.length || col == -1 ||
                            col == grid[0].length || visited[row][col])
                        continue;

                    if (grid[row][col] == 1)
                        return steps;

                    visited[row][col] = true;
                    q.offer(new int[] { row, col });
                }
            }

            steps++;
        }

        return -1;
    }

    private void dfs(int[][] grid, int row, int col, Queue<int[]> q, boolean[][] visited, int[][] moves) {

        if (row == -1 || row == grid.length || col == -1 || col == grid[0].length || visited[row][col]
                || grid[row][col] == 0)
            return;

        visited[row][col] = true;
        q.offer(new int[] { row, col });

        for (int[] move : moves) {
            dfs(grid, row + move[0], col + move[1], q, visited, moves);
        }

    }
}
// @lc code=end
