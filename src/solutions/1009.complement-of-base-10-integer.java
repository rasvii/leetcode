package solutions;
/*
 * @lc app=leetcode id=1009 lang=java
 *
 * [1009] Complement of Base 10 Integer
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int n) {

        if(n == 0) return 1;

        int mask = 1;

        while(mask < n) {
            mask = (mask << 1) + 1;
        }


        return mask ^ n;


        
    }
}
// @lc code=end

