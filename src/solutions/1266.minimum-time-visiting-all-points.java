package solutions;
/*
 * @lc app=leetcode id=1266 lang=java
 *
 * [1266] Minimum Time Visiting All Points
 */

// @lc code=start
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int result = 0;

        for(int i = 1; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];

            int x1 = points[i-1][0];
            int y1 = points[i-1][1];

            result += Math.max(Math.abs(x2-x1), Math.abs(y2-y1));

        }

        return result;
        
    }
}
// @lc code=end

