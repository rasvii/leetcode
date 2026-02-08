package solutions;
/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length < 1) return 0;       

        int n = prices.length;

        int[] buy = new int[n+1];
        int[] sell = new int[n+1];

        buy[1] = -prices[0];

        for(int i = 2; i <= n; i++) {
            int price = prices[i-1];
            buy[i] = Math.max(buy[i-1], sell[i-2] - price);
            sell[i] = Math.max(sell[i-1], buy[i-1] + price);
        }

        return sell[n];
    }
}
// @lc code=end

