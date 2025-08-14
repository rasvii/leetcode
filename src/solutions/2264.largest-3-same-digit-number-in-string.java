package solutions;
/*
 * @lc app=leetcode id=2264 lang=java
 *
 * [2264] Largest 3-Same-Digit Number in String
 */

// @lc code=start
class Solution {
    public String largestGoodInteger(String num) {

        int result = -1;

        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i - 2) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i)) {
                result = Math.max(result, num.charAt(i) - '0');
            }
        }

        if (result == -1)
            return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (48 + result));
        }

        return sb.toString();
    }
}
// @lc code=end
