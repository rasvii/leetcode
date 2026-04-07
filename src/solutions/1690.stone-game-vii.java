package solutions;
/*
 * @lc app=leetcode id=1690 lang=java
 *
 * [1690] Stone Game VII
 */

// @lc code=start
class Solution {
    public int stoneGameVII(int[] stones) {

        int n= stones.length;
        int[] dp = new int[n];

        for(int i = n-2; i >= 0; i--){
            int total = stones[i];

            for(int j = i+1; j < n; j++) {
                total += stones[j];
                dp[j] = Math.max(total - stones[i] - dp[j], total - stones[j] - dp[j-1]);
            }
        }

        return dp[n-1];
        
    }
}
// @lc code=end

