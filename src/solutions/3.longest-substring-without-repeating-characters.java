package solutions;
/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() < 2) {
            return s.length();
        }

        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int longestLen = 0;

        for(int right = 0; right < s.length(); right++){
            if(charSet.add(s.charAt(right))){
                longestLen = Math.max(longestLen, right - left + 1);
            }
            else{
                while(charSet.contains(s.charAt(right))){
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return longestLen;
    }
}
// @lc code=end
