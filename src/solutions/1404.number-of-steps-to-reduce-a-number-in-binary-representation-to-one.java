package solutions;
/*
 * @lc app=leetcode id=1404 lang=java
 *
 * [1404] Number of Steps to Reduce a Number in Binary Representation to One
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {

        int n = s.length();
        int carry = 0;
        int ans = 0;

        for (int i = n - 1; i >= 1; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                ans += 2;
                carry = 1;
            } else {
                ans++;
            }
        }

        return ans + carry;
    }
}
// @lc code=end

