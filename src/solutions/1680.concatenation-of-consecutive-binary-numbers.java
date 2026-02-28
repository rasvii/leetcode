package solutions;
/*
 * @lc app=leetcode id=1680 lang=java
 *
 * [1680] Concatenation of Consecutive Binary Numbers
 */

// @lc code=start
class Solution {
    public int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long result = 0;
        int binary = 0;

        for(int i = 1; i <= n; i++) {
            if((i & (i-1)) == 0) binary++;
            result = ((result << binary )+ i) % modulo;
        }

        return (int) result;
    }
}
// @lc code=end

