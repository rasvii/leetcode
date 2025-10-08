package solutions;
/*
 * @lc app=leetcode id=1926 lang=java
 *
 * [1926] Nearest Exit from Entrance in Maze
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int rows = maze.length, cols = maze[0].length;
        int result = 0;
        int[][] moves = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int row, col;

        while (!q.isEmpty()) {
            result++;

            int n = q.size();

            for (int i = 0; i < n; i++) {
                int[] cur = q.poll();

                for (int[] move : moves) {
                    row = cur[0] + move[0];
                    col = cur[1] + move[1];

                    if (row == -1 || row == rows || col == -1 || col == cols)
                        continue;
                    if (maze[row][col] == '+')
                        continue;

                    if (row == 0 || col == 0 || row == rows - 1 || col == cols - 1)
                        return result;

                    maze[row][col] = '+';
                    q.offer(new int[] { row, col });
                }

            }
        }

        return -1;
    }
}
// @lc code=end
