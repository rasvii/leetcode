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
        int currProfit = 0;
        int maxProfit = 0;

        for(int i : prices){
            leastSoFar = Math.min(i, leastSoFar);
            currProfit = i - leastSoFar;
            maxProfit = Math.max(currProfit, maxProfit);
        }

        return maxProfit;

    }
}
// @lc code=end
