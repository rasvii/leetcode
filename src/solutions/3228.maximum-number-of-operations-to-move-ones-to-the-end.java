package solutions;
/*
 * @lc app=leetcode id=3228 lang=java
 *
 * [3228] Maximum Number of Operations to Move Ones to the End
 */

// @lc code=start
class Solution {
    public int maxOperations(String s) {

        int n = s.length();
        int operations = 0;
        int ones = 0;

        for(int i = 0; i < n; i++) {
            
            if(s.charAt(i) == '1') {
                ones++;
            }
            else if(i > 0 && s.charAt(i-1) == '1') {
                operations += ones;
            }
        }

        return operations;
        
    }
}
// @lc code=end

