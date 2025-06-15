package solutions;
/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, boolean[] used, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;

                tempList.add(nums[i]);
                used[i] = true;

                backtrack(nums, tempList, used, result);

                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}
// @lc code=end
