package solutions;
/*
 * @lc app=leetcode id=961 lang=java
 *
 * [961] N-Repeated Element in Size 2N Array
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.add(n)) {
                return n;
            }
        }

        return -1;
    }
}
// @lc code=end
