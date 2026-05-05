package solutions;
/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums, target, 0, 0);
        return result;
    }

    private void calculate(int[] nums, int target, int idx, int sum) {

        if(idx == nums.length) {
            if(sum == target) {
                result++;
            }
        }
        else {
            calculate(nums, target, idx+1, sum + nums[idx]);

            calculate(nums, target, idx+1, sum - nums[idx]);
        }
    }
}
// @lc code=end

