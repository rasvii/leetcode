package solutions;
/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int lenght = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lenght++;
            } else {
                if (lenght > 0)
                    return lenght;
            }
        }

        return lenght;

    }
}
// @lc code=end
