package solutions;
/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currNum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (currNum >= 0) {
                currNum += nums[i];
            } else {
                currNum = nums[i];
            }

            if (currNum > maxSum) {
                maxSum = currNum;
            }
        }

        return maxSum;

    }
}
// @lc code=end
