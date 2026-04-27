package solutions;
/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {

        int[] count = new int[126];

        for(char c : t.toCharArray()) {
            count[c]++;
        }

        int remaining = t.length(), left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, resultleft = 0;

        while(right < s.length()) {

            char cr = s.charAt(right);
            count[cr]--;

            if(count[cr] >= 0) remaining--;

            right++;

            while(remaining == 0) {
                if(right - left < minLen) {
                    resultleft = left;
                    minLen = right - left;
                }

                count[s.charAt(left)]++;
                if(count[s.charAt(left)] > 0) remaining++;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(resultleft, minLen + resultleft);
    }
}
// @lc code=end
