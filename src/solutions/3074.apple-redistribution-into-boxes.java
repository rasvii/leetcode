package solutions;
/*
 * @lc app=leetcode id=3074 lang=java
 *
 * [3074] Apple Redistribution into Boxes
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        Arrays.sort(capacity);

        int appleCount = 0;

        for (int a : apple) {
            appleCount += a;
        }

        int result = 0;
        int cap = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            cap += capacity[i];
            result++;

            if (cap >= appleCount)
                break;
        }

        return result;

    }
}
// @lc code=end
