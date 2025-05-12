package solutions;
/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int even = isPalindrome(s, i, i + 1);
            int odd = isPalindrome(s, i - 1, i + 1);
            result = even + odd + 1 + result;
        }

        return result;
    }

    private int isPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }

        return count;
    }
}

// Brute force
/*
 * class Solution {
 * public int countSubstrings(String s) {
 * int result = 0;
 * 
 * for(int i = 0; i < s.length(); i++){
 * for(int j = i; j < s.length(); j++){
 * if(isPalindrome(s, i, j)) result++;
 * }
 * }
 * 
 * return result;
 * }
 * 
 * private boolean isPalindrome(String s, int left, int right){
 * while(left < right){
 * if(s.charAt(left++) != s.charAt(right--)) return false;
 * }
 * 
 * return true;
 * }
 * }
 */
// @lc code=end
