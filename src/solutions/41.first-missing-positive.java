package solutions;
/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int i = 0;
        while (i < n) {
            int curr = nums[i];
            int correctIdx = curr - 1;

            if (curr > 0 && curr <= n && nums[correctIdx] != curr) {
                swap(nums, curr - 1, i);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] == i + 1)
                continue;
            return i + 1;
        }

        return n + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
// @lc code=end
