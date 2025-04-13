package solutions;
/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

import java.util.HashMap;
import java.util.HashSet;

// @lc code=start
class Solution {
    // public boolean containsNearbyDuplicate(int[] nums, int k) {

    // HashMap<Integer, Integer> distinctNums = new HashMap<>();

    // for (int i = 0; i < nums.length; i++) {

    // if (distinctNums.containsKey(nums[i]) && Math.abs(distinctNums.get(nums[i]) -
    // i) <= k) {
    // return true;
    // }

    // distinctNums.put(nums[i], i);
    // }

    // return false;

    // }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> distinctNums = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > k) {
                distinctNums.remove(nums[i - k - 1]);
            }

            if (!distinctNums.add(nums[i]))
                return true;
        }

        return false;

    }
}
// @lc code=end
