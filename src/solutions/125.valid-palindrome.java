package solutions;
/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();

        if (s.length() == 1)
            return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(right)) == Character.toLowerCase(s.charAt(left))) {
                right--;
                left++;
            } else {
                return false;
            }
        }

        return true;

    }
}
// @lc code=end
