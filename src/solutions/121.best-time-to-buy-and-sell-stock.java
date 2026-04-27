package solutions;
/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        int result = 0, minSoFar = Integer.MAX_VALUE;

        for(int n: prices) {
            if(n < minSoFar) {
                minSoFar = n;
            }

            result = Math.max(result, n - minSoFar);
        }

        return result;
    }
}
// @lc code=end
