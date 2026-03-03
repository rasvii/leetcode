package solutions;
/*
 * @lc app=leetcode id=1545 lang=java
 *
 * [1545] Find Kth Bit in Nth Binary String
 */

// @lc code=start
class Solution {
    public char findKthBit(int n, int k) {
        
        String result = helper(n);
        return result.charAt(k - 1);
    }

    public String helper(int n) {
        if (n == 1)
            return "0";

        String s = helper(n - 1);
        s = s + "1" + invertAndReverse(s);

        return s;
    }

    private String invertAndReverse(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        return sb.toString();
    }
}
// @lc code=end

