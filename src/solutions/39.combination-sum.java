package solutions;
/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int start, int remain, int[] nums, List<Integer> tempList, List<List<Integer>> result) {

        if (remain < 0)
            return;
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(i, remain - nums[i], nums, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// @lc code=end
