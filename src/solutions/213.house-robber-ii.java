package solutions;
/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        return Math.max(findMax(0, nums.length - 2, nums), findMax(1, nums.length - 1, nums));
    }

    private int findMax(int start, int end, int[] nums) {

        int prev1 = 0, prev2 = 0;
        int curr = -1;

        for (int i = start; i <= end; i++) {
            curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}
// @lc code=end
