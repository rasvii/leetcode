package solutions;
/*
 * @lc app=leetcode id=1984 lang=java
 *
 * [1984] Minimum Difference Between Highest and Lowest of K Scores
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int minimumDifference(int[] nums, int k) {

        Arrays.sort(nums);

        if(k == 1) return 0;

        int left = 0, right = k - 1;
        int result = Integer.MAX_VALUE;

        while(right < nums.length) {
            result = Math.min(result, nums[right] - nums[left]);
            left++;
            right++;
        }

        return result;
        
    }
}
// @lc code=end

