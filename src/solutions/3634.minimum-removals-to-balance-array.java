package solutions;
/*
 * @lc app=leetcode id=3634 lang=java
 *
 * [3634] Minimum Removals to Balance Array
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int minRemoval(int[] nums, int k) {

        Arrays.sort(nums);
        int left = 0, right = 0;
        int n = nums.length;
        int maxLen = 0;


        while(right < n) {

            while(right < n && nums[right] <= (long) k * (long) nums[left]) {
                right++;
            }

            maxLen = Math.max(maxLen, right-left);
            left++;
        }

        return n - maxLen;
    }
}
// @lc code=end

