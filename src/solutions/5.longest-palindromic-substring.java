package solutions;
/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        String longestPalindrome = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            String length = isPalindrome(s, i, i + 1);
            longestPalindrome = length.length() > longestPalindrome.length() ? length : longestPalindrome;
            length = isPalindrome(s, i - 1, i + 1);
            longestPalindrome = length.length() > longestPalindrome.length() ? length : longestPalindrome;
        }

        return longestPalindrome;
    }

    private String isPalindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
// @lc code=end
