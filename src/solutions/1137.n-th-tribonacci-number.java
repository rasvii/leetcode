package solutions;
/*
 * @lc app=leetcode id=1137 lang=java
 *
 * [1137] N-th Tribonacci Number
 */

// @lc code=start
class Solution {

    int[] cache = new int[38];

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else if (cache[n] != 0) {
            return cache[n];
        }

        return cache[n] = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
    }
}
// @lc code=end
