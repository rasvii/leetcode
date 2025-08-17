package solutions;
/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;

        for (int n : nums) {
            if (jump < 0) {
                return false;
            } else if (n > jump) {
                jump = n;
            }

            jump -= 1;
        }

        return true;
    }
}
// @lc code=end
