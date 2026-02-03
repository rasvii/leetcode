package solutions;
/*
 * @lc app=leetcode id=3637 lang=java
 *
 * [3637] Trionic Array I
 */

// @lc code=start
class Solution {
    public boolean isTrionic(int[] nums) {

        int n = nums.length;

        int i = 1;

        while(i < n && nums[i] > nums[i-1]) {
            i++;
        }

        if(i == 1 || i >= n-1) return false;
        int p = i;

        while(i < n && nums[i] < nums[i-1]) {
            i++;
        }

        if(i == p && i >= n-1) return false;

        int q = i;

        while(i < n && nums[i] > nums[i-1]) {
            i++;
        }

        if(i <= n-1 || i == q) return false;

        return true;
        
    }
}
// @lc code=end

