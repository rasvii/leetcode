package solutions;
/*
 * @lc app=leetcode id=1877 lang=java
 *
 * [1877] Minimize Maximum Pair Sum in Array
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int minPairSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length, result = 0;

        for (int i = 0; i < n / 2; i++) {
            result = Math.max(result, nums[n - i - 1] + nums[i]);
        }

        return result;
    }
}
// @lc code=end
