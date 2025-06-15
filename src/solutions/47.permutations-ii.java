package solutions;
/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

import java.util.*;

// @lc code=start
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, boolean[] used, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
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
