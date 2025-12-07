package solutions;
/*
 * @lc app=leetcode id=1523 lang=java
 *
 * [1523] Count Odd Numbers in an Interval Range
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {

        if (low % 2 == 1 || high % 2 == 1) {
            return ((high - low) / 2) + 1;
        } else {
            return (high - low) / 2;
        }

    }
}
// @lc code=end
