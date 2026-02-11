package solutions;
/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        if(prices.length < 1) return 0;       

        int n = prices.length;

        int[] buy = new int[n+1];
        int[] sell = new int[n+1];

        buy[0] = -prices[0];

        for(int i = 1; i <=n;i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i-1]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i-1] - fee);
        }

        return sell[n];
    }
}
// @lc code=end

