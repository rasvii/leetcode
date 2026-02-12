package solutions;
/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        int lastDay = days[n-1];
        int[] dp = new int[lastDay + 1];
        int[] passDays = {1, 7, 30};

        boolean[] travelDays = new boolean[lastDay + 1];

        for (int day : days)
            travelDays[day] = true;


        for(int i = 1; i <= lastDay; i++) {
            
            if(!travelDays[i]) {
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = Integer.MAX_VALUE;

            for(int j = 1; j <= costs.length; j++) {
                
                dp[i] = Math.min(dp[Math.max(i - passDays[j-1], 0)] + costs[j-1], dp[i]);
            }
        }


        return dp[lastDay];
        
    }
}
// @lc code=end

