package solutions;
/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        
        int total = 0;

        for(int n: nums) {
            total += n;
        }

        if(total % 2 == 1) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int n : nums) {
            for(int sum = target; sum >= n; sum--) {
                dp[sum] = dp[sum] || dp[sum - n];
                if(dp[target]) return true;
            }
        }

        return dp[target];

    }
}
// @lc code=end

