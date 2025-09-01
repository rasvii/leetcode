package solutions;
/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int result = 0;
        int[] last = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= last[1]) {
                last = intervals[i];
            } else {
                result++;
            }
        }

        return result;

    }
}
// @lc code=end
