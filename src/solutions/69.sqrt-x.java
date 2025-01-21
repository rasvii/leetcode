package solutions;
/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        int start = 1, end = x;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid * mid == x) {
                return mid;
            } else if ((long) mid * mid > (long) x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return Math.round(end);
    }
}
// @lc code=end
