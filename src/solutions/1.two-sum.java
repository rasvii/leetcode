package solutions;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int subtract = target - nums[i];

            if (numberMap.containsKey(subtract)) {
                return new int[] { i, numberMap.get(subtract) };
            }

            numberMap.put(nums[i], i);
        }

        return new int[] {};
    }
}
// @lc code=end
