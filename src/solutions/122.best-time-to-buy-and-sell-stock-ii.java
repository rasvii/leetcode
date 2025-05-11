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
        int leastSoFar = Integer.MAX_VALUE;
        int totalProfit = 0;

        for(int n : prices){
            leastSoFar = Math.min(n, leastSoFar);
            int currProfit = n - leastSoFar;

            if(currProfit > 0){
                totalProfit = totalProfit + currProfit;
                leastSoFar = n;
            }
        }
        
        return totalProfit;
    }
}
// @lc code=end
