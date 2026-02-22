package solutions;
/*
 * @lc app=leetcode id=868 lang=java
 *
 * [868] Binary Gap
 */

// @lc code=start
class Solution {
    public int binaryGap(int n) {

        while((n & 1) == 0) {
            n >>= 1;
        }

        if(n == 1) return 0;

        int result = 0;
        int gap = 0;

        while(n != 0) {
            
            if((n & 1) == 1) {
                result = Math.max(result, gap + 1);
                gap = 0;
            }
            else {
                gap++;
            }

            n >>= 1;
        }


        return result;
        
    }
}
// @lc code=end

