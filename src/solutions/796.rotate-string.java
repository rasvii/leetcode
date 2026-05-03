package solutions;
/*
 * @lc app=leetcode id=796 lang=java
 *
 * [796] Rotate String
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.equals(goal)) return true;

        if(s.length() != goal.length()) return false;

        int n = s.length();

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == goal.charAt(0)) {
                String temp = s.substring(i, n) + s.substring(0, i);

                if(temp.equals(goal)) return true;
            }
        }

        return false;
    }
}
// @lc code=end

