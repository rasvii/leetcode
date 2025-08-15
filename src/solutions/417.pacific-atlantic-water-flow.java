package solutions;
/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    int[][] moves = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] arctic = new boolean[rows][cols];

        for (int i = 0; i < cols; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, rows - 1, i, Integer.MIN_VALUE, arctic);
        }

        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, cols - 1, Integer.MIN_VALUE, arctic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && arctic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, int prev, boolean[][] visited) {

        if (row < 0 || row >= heights.length || col < 0 ||
                col >= heights[0].length || visited[row][col])
            return;
        if (heights[row][col] < prev)
            return;

        visited[row][col] = true;

        for (int[] move : moves) {
            dfs(heights, row + move[0], col + move[1], heights[row][col], visited);
        }
    }
}
// @lc code=end
