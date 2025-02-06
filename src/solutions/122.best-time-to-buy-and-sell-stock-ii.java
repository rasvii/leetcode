package solutions;
/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    // First LC medium that I solved totally by myself. No solution look-ups!!!
    // Plus the runtime beats 100% java solutions and memory usage beats 83.47%!!
    public int maxProfit(int[] prices) {

        int totalProfit = 0;
        int leastSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            leastSoFar = Math.min(prices[i], leastSoFar);
            int currentProfit = prices[i] - leastSoFar;

            if (currentProfit <= 0) {
                currentProfit = 0;
            } else {
                leastSoFar = prices[i];
                totalProfit += currentProfit;
            }
        }

        return totalProfit;

    }
}
// @lc code=end
