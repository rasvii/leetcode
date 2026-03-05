package solutions;
/*
 * @lc app=leetcode id=1758 lang=java
 *
 * [1758] Minimum Changes To Make Alternating Binary String
 */

// @lc code=start
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int oneStart = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) != '1')
                    oneStart++;
            } else {
                if (s.charAt(i) != '0')
                    oneStart++;
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) != '0')
                    result++;
            } else {
                if (s.charAt(i) != '1')
                    result++;
            }
        }

        return Math.min(result, oneStart);
    }
}
// @lc code=end

