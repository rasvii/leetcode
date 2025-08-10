package solutions;
/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int oneStepBefore = 2, twoStepsBefore = 1;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = result;
        }

        return result;
    }
}
// @lc code=end
