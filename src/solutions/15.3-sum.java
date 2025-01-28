package solutions;
/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > 0)
                break;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0)
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
            }

        }

        return new ArrayList<>(result);

    }
}
// @lc code=end
