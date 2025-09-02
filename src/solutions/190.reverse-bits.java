package solutions;
/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
class Solution {
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n >>= 1;
            result = (result << 1) | bit;
        }

        return result;
    }
}
// @lc code=end
