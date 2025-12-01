package solutions;
/*
 * @lc app=leetcode id=2141 lang=java
 *
 * [2141] Maximum Running Time of N Computers
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public long maxRunTime(int n, int[] batteries) {

        Arrays.sort(batteries);

        long sum = 0;

        for (int b : batteries) {
            sum += b;
        }

        int k = 0, nb = batteries.length - 1;

        while (batteries[nb - k] > sum / (n - k)) {
            sum -= batteries[nb - k++];
        }

        return sum / (n - k);
    }
}
// @lc code=end
