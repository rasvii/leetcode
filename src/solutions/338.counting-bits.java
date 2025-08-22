package solutions;
/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {

        int[] result = new int[n + 1];
        int multiplier = 1;

        for (int i = 1; i <= n; i++) {

            if (multiplier * 2 == i) {
                multiplier *= 2;
            }

            result[i] = result[i - multiplier] + 1;
        }

        return result;
    }
}
// @lc code=end
