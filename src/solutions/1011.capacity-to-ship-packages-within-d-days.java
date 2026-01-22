package solutions;
/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0, right = 0;

        for(int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while ( left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;

            for(int w : weights) {
                if( cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }

            if(need > days) left = mid + 1;
            else right = mid;
        }

        return left;
        
    }
}
// @lc code=end

