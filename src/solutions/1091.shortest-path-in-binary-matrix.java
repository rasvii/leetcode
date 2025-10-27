package solutions;
/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 1)
            return -1;

        int[][] moves = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        int result = 1;
        int n = grid.length;
        grid[0][0] = 1;

        if (n == 1)
            return result;

        while (!q.isEmpty()) {
            int size = q.size();
            result++;

            while (size-- > 0) {

                int[] cur = q.poll();

                for (int[] move : moves) {

                    int row = cur[0] + move[0];
                    int col = cur[1] + move[1];

                    if (row == -1 || col == -1 || row == n || col == n || grid[row][col] == 1)
                        continue;

                    if (row == n - 1 && col == n - 1)
                        return result;

                    grid[row][col] = 1;

                    q.offer(new int[] { row, col });
                }
            }

        }

        return -1;
    }
}
// @lc code=end
