package solutions;
/*
 * @lc app=leetcode id=1513 lang=java
 *
 * [1513] Number of Substrings With Only 1s
 */

// @lc code=start
class Solution {
    public int numSub(String s) {

        int result = 0, n = s.length();
        int mod = (int) 1e9 + 7;
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '1') {
                count++;
                result = (result + count) % mod;
            } else {
                count = 0;
            }

        }

        return result;
    }
}

/*
 * class Solution {
 * public int numSub(String s) {
 * 
 * long result = 0, n = s.length();
 * int mod = (int)1e9 + 7;
 * 
 * 
 * for (int i = 0; i < n; i++) {
 * 
 * if (s.charAt(i) == '1') {
 * 
 * int count = 0;
 * 
 * while (i < n && s.charAt(i) == '1') {
 * i++;
 * count++;
 * }
 * 
 * System.out.println(count);
 * 
 * while (count > 0) {
 * result = (result + count) % mod;
 * count--;
 * }
 * }
 * }
 * 
 * return (int) result % mod;
 * }
 * }
 */
// @lc code=end
