package solutions;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int start, int remain, int[] nums, List<Integer> tempList, List<List<Integer>> result) {

        if (remain < 0)
            return;
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                tempList.add(nums[i]);
                backtrack(i + 1, remain - nums[i], nums, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// @lc code=end
