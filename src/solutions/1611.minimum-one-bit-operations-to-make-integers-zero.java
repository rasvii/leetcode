package solutions;
/*
 * @lc app=leetcode id=1611 lang=java
 *
 * [1611] Minimum One Bit Operations to Make Integers Zero
 */

// @lc code=start
class Solution {
    public int minimumOneBitOperations(int n) {

        int multiplier = 1;
        int result = 0;

        while (n > 0) {
            result += n ^ (n - 1) * multiplier;
            multiplier *= -1;
            n &= n - 1;
        }

        return Math.abs(result);
    }
}
// @lc code=end
