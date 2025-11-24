package solutions;
/*
 * @lc app=leetcode id=1018 lang=java
 *
 * [1018] Binary Prefix Divisible By 5
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {

        int binary = 0;
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            binary = ((binary << 1) | nums[i]) % 5;

            if (binary == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;

    }
}
// @lc code=end
