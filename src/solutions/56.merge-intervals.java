package solutions;
/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

import java.util.ArrayList;
import java.util.Arrays;

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || interval[0] > result.getLast()[1]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end
