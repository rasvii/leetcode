package solutions;
/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        int leastSoFar = Integer.MAX_VALUE;
        int overallProf = 0;
        int currProf = 0;

        for (int i = 0; i < prices.length; i++) {

            leastSoFar = Integer.min(leastSoFar, prices[i]);

            currProf = prices[i] - leastSoFar;

            overallProf = Integer.max(currProf, overallProf);

        }

        return overallProf;
    }
}
// @lc code=end
