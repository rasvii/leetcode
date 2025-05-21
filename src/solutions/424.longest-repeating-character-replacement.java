package solutions;
/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[126];

        int left = 0, right = 0;
        int maxCount = 0, maxLength = 0;

        while (right < s.length()) {
            char cRight = s.charAt(right);
            count[cRight]++;

            maxCount = Math.max(maxCount, count[cRight]);

            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left)]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
// @lc code=end
