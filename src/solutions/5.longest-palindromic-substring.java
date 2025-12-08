package solutions;
/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start

class Solution {
    public String longestPalindrome(String s) {

        int maxLen = 0, left = 0, right = 0, n = s.length();
        int[] vals = new int[2];

        for (int i = 0; i < n; i++) {

            helper(s, i, i, vals);

            if (vals[1] - vals[0] > maxLen) {
                left = vals[0];
                right = vals[1];
                maxLen = vals[1] - vals[0];
            }

            helper(s, i, i + 1, vals);

            if (vals[1] - vals[0] > maxLen) {
                left = vals[0];
                right = vals[1];
                maxLen = vals[1] - vals[0];
            }
        }

        return s.substring(left, right);

    }

    private void helper(String s, int left, int right, int[] vals) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        vals[0] = left + 1;
        vals[1] = right;
    }
}
/*
 * class Solution {
 * public String longestPalindrome(String s) {
 * 
 * if (s.length() <= 1) {
 * return s;
 * }
 * 
 * String longestPalindrome = s.substring(0, 1);
 * 
 * for (int i = 0; i < s.length(); i++) {
 * String length = isPalindrome(s, i, i + 1);
 * longestPalindrome = length.length() > longestPalindrome.length() ? length :
 * longestPalindrome;
 * length = isPalindrome(s, i - 1, i + 1);
 * longestPalindrome = length.length() > longestPalindrome.length() ? length :
 * longestPalindrome;
 * }
 * 
 * return longestPalindrome;
 * }
 * 
 * private String isPalindrome(String s, int left, int right) {
 * 
 * while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
 * {
 * left--;
 * right++;
 * }
 * 
 * return s.substring(left + 1, right);
 * }
 * }
 */
// @lc code=end
