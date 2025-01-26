package solutions;
/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int len = s.length();
        StringBuffer[] rowArr = new StringBuffer[numRows];
        for (int i = 0; i < rowArr.length; i++) {
            rowArr[i] = new StringBuffer();
        }
        int sub = 1;
        int pos = 0;

        for (int i = 0; i < len; i++) {

            rowArr[pos].append(s.charAt(i));

            if (pos == numRows - 1) {
                sub = -1;
            } else if (pos == 0) {
                sub = 1;
            }
            pos += sub;
        }

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < rowArr.length; i++) {
            result.append(rowArr[i]);
        }

        return result.toString();

    }
}
// @lc code=end
