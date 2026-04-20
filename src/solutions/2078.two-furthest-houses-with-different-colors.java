package solutions;
/*
 * @lc app=leetcode id=2078 lang=java
 *
 * [2078] Two Furthest Houses With Different Colors
 */

import java.util.*;

// @lc code=start
class Solution {
    public int maxDistance(int[] colors) {

        Set<Integer> seen = new HashSet<>();
        int n = colors.length;
        int result = 0;

        for(int i = 0; i < n; i++) {

            if(seen.contains(colors[i])) {
                continue;
            }

            for(int j = n-1; j > i; j--) {
                if(colors[j] != colors[i]) {
                    result = Math.max(result, j - i);
                }
            }

            seen.add(colors[i]);
        }

        return result;
        
    }
}
// @lc code=end

