package solutions;
/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 */

import java.util.HashMap;

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        int result = 2;

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);

                result = Math.max(result, dp[i].get(diff));

            }
        }

        return result;

    }
}
// @lc code=end

