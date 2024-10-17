package solutions;

/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean isPositive = (dividend < 0) == (divisor < 0);
        System.out.println(isPositive);

        long dd = Math.abs((long) dividend);
        long dv = Math.abs((long) divisor);

        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            if (isPositive) {
                return (int) dd;
            }
            return (int) -dd;
        }

        long result = 0;

        while (dd >= dv) {
            long tmp = dv;
            long mul = 1;

            while (dd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }

            result += mul;
            dd -= tmp;
        }

        if (!isPositive) {
            result = -result;
        }

        return (int) result;
    }
}
// @lc code=end
