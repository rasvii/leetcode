package solutions;
/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

import java.util.HashSet;
import java.util.Hashtable;

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> values = new HashSet<>();
        int left, right, ans = 0;

        for (int n : nums) {
            values.add(n);
        }

        for (int n : nums) {
            // if (!values.contains(n)) {
            left = n - 1;
            right = n + 1;
            while (values.remove(left)) {
                left--;
            }
            while (values.remove(right)) {
                right++;
            }
            ans = Math.max(ans, right - left - 1);
            // } else {
            // continue;
            // }

        }

        return ans;

    }
}
// @lc code=end
