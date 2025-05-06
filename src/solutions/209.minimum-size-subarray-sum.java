package solutions;
/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minSize = Integer.MAX_VALUE, sum = 0, left = 0, right = 0;
        
        while(right < nums.length){
            sum += nums[right];
            right++;
            
            while(sum >= target){
                minSize = Math.min(minSize, right - left);
                sum -= nums[left];
                left++;
            }
        }
        
        
        return minSize == Integer.MAX_VALUE ? 0 : minSize;

    }
}
// @lc code=end
