package solutions;
/*
 * @lc app=leetcode id=757 lang=java
 *
 * [757] Set Intersection Size At Least Two
 */

// @lc code=start

import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        List<Integer> result = new ArrayList<>();

        result.add(intervals[0][1] - 1);
        result.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            if (result.getLast() < intervals[i][0]) {
                result.add(intervals[i][1] - 1);
                result.add(intervals[i][1]);
            } else if (result.getLast() >= intervals[i][0] && result.get(result.size() - 2) < intervals[i][0]) {
                if (result.getLast() == intervals[i][1]) {
                    int lastIndex = result.size() - 1;
                    result.set(lastIndex, result.get(lastIndex) - 1);
                    result.add(intervals[i][1]);
                } else {
                    result.add(intervals[i][1]);
                }
            }
        }

        return result.size();

    }
}
// @lc code=end
