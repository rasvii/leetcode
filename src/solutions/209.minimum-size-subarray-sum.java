package solutions;
/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (i < nums.length) {
            sum += nums[i++];

            while (sum >= target) {
                min = Math.min(min, i - j);
                sum -= nums[j++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
// @lc code=end
