package solutions;
/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {

        int n = chars.length;

        if(n == 1) return n;

        int result = 0;
        int i = 0;

        while(i < n) {
            int count = 0;
            char letter = chars[i];

            while(i < n && chars[i] == letter) {
                count++;
                i++;
            }

            chars[result++] = letter; 

            if(count > 1) {
                for(char c : String.valueOf(count).toCharArray()) {
                    chars[result++] = c;
                }
            }

        }

        return result;
    }
}
// @lc code=end

