package solutions; /*
                   * @lc app=leetcode id=7 lang=java
                   *
                   * [7] Reverse Integer
                   */

// @lc code=start
class Solution {
    public int reverse(int x) {

        int result = 0;

        while (x != 0) {
            if ((long) result * 10 + x % 10 > Integer.MAX_VALUE || (long) result * 10 + x % 10 < Integer.MIN_VALUE) {
                return 0;

            }

            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result;

    }
}
// @lc code=end
