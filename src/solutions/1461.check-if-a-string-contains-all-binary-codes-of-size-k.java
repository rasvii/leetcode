package solutions;
/*
 * @lc app=leetcode id=1461 lang=java
 *
 * [1461] Check If a String Contains All Binary Codes of Size K
 */

import java.util.HashSet;

// @lc code=start
class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        HashSet<String> strings = new HashSet<>();
        int n = s.length(), right = k;

        while(right <= n) {
            strings.add(s.substring(right - k, right));
            right++;
        }

        System.out.println(strings.size());

        return strings.size() == Math.pow(2, k);
    }
}
// @lc code=end

