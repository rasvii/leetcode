package solutions;
/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a,b) -> Integer.compare(a[0], b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 1;

        for(int i = 1; i < n; i++) {
            dp[i] = 1;

            for(int j = i-1; j >=0; j--) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
        
    }
}
// @lc code=end

