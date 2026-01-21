package solutions;
/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {

        if(num < 2) return true;

        int low = 0, high = num/2;

        while(low < high) {
            int mid = low + (high - low) / 2;
            long square = (long)mid * (long)mid;
            if(square < num) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return low * low == num ? true : false;
        
    }
}
// @lc code=end

