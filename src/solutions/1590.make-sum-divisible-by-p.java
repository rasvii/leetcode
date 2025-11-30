package solutions;
/*
 * @lc app=leetcode id=1590 lang=java
 *
 * [1590] Make Sum Divisible by P
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {

        int n = nums.length;
        int remainder = 0;

        for (int num : nums) {
            remainder = (remainder + num) % p;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        map.put(0, -1);
        int result = n;

        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            map.put(cur, i);
            int want = (cur - remainder + p) % p;
            result = Math.min(result, i - map.getOrDefault(want, -n));
        }

        return result < n ? result : -1;
    }
}
// @lc code=end
