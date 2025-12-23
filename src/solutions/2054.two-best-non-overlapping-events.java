package solutions;
/*
 * @lc app=leetcode id=2054 lang=java
 *
 * [2054] Two Best Non-Overlapping Events
 */

import java.util.*;

// @lc code=start
class Solution {
    public int maxTwoEvents(int[][] events) {

        List<int[]> times = new ArrayList<>();

        for (int[] event : events) {
            // 1 denotes start time
            times.add(new int[] { event[0], 1, event[2] });
            // 0 denotes end time
            times.add(new int[] { event[1] + 1, 0, event[2] });
        }

        times.sort((a, b) -> a[0] == b[0]
                ? Integer.compare(a[1], b[1])
                : Integer.compare(a[0], b[0]));

        int ans = 0, maxValue = 0;

        for (int[] timeValue : times) {
            if (timeValue[1] == 1) {
                // Start time: Calculate the maximum sum
                ans = Math.max(ans, timeValue[2] + maxValue);
            } else {
                // End time: Update the maximum value seen so far
                maxValue = Math.max(maxValue, timeValue[2]);
            }
        }

        return ans;
    }
}
// @lc code=end
