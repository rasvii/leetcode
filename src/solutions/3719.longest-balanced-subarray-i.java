package solutions;
/*
 * @lc app=leetcode id=3719 lang=java
 *
 * [3719] Longest Balanced Subarray I
 */

import java.util.HashSet;

// @lc code=start
class Solution {
    public int longestBalanced(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0)
                    even.add(nums[j]);
                else
                    odd.add(nums[j]);

                if (even.size() == odd.size()) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}
// @lc code=end

