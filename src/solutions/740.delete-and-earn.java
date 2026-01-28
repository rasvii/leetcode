package solutions;
/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] count = new int[n];
        for (int num : nums) {
            count[num] += num;
        }

        int take = 0, skip = 0;

        for (int i = 0; i < n; i++) {
            int takei = count[i] + skip;
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }

        return Math.max(take, skip);

    }
}
// @lc code=end
