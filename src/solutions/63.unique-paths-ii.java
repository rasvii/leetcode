package solutions;
/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] paths = new int[width];
        paths[0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[j] = 0;
                } else if (j > 0) {
                    paths[j] = paths[j - 1] + paths[j];
                }
            }
        }

        return paths[width - 1];
    }
}
// @lc code=end
