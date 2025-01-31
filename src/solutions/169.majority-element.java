package solutions;
/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {

        int ans = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (ans != nums[i]) {
                count--;// if meet different value,count--
            } else { // if meet the same value, count++
                count++;
            }
            // if the current best ans is no longer the majority
            // i.e. it's count is not larger than i / 2
            if (count == 0) {
                count = 1;
                ans = nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end
