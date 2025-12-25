package solutions;
/*
 * @lc app=leetcode id=3075 lang=java
 *
 * [3075] Maximize Happiness of Selected Children
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        int n = happiness.length;

        Arrays.sort(happiness);

        long result = 0;
        int minus = 0;

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            int temp = happiness[i] - minus;

            if (temp <= 0) {
                break;
            }

            result += temp;

            k--;
            minus++;

        }

        return result;
    }
}
// @lc code=end
