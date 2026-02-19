package solutions;
/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start

class Solution {
    public int countBinarySubstrings(String s) {

        int n = s.length(), result =0;
        int prev = 0, cur = 1;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                cur++;
            }
            else {
                result += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }

        result += Math.min(prev, cur);
        return result;
    }
}
/* 
class Solution {
    public int countBinarySubstrings(String s) {

        int result = 0;
        int i = 0;
        int n = s.length();
        int midIdx = 0;

        while (i < n) {
            int zero = 0, one = 0;
            int loop = 2;

            while (loop-- > 0) {
                if (i < n && s.charAt(i) == '0') {
                    while (i < n && s.charAt(i) == '0') {
                        i++;
                        zero++;
                    }
                } else {
                    while (i < n && s.charAt(i) == '1') {
                        i++;
                        one++;
                    }
                }
                if(loop == 1) midIdx = i;
            }

            int min = Math.min(zero, one);
            result += min;
            i = midIdx;
        }

        return result;

    }
} */
// @lc code=end

