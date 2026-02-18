package solutions;
/*
 * @lc app=leetcode id=693 lang=java
 *
 * [693] Binary Number with Alternating Bits
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {

        if(n == 1) return true;

        int prev = n & 1;

        while(n!=0) {
            n >>= 1;
            int cur = n & 1;
            if(cur == prev) return false;

            prev = cur;
        }

        return true;
        
    }
}
// @lc code=end

