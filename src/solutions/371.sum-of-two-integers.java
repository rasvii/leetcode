package solutions;
/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {

        if ((a & b) == 0) {
            return a ^ b;
        }

        int carry = 0;

        while (b != 0) {
            carry = (a & b);
            a = a ^ b;
            b = carry << 1;
        }

        return a;

    }
}
// @lc code=end
