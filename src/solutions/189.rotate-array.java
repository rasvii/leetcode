package solutions;
/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {

        k %= nums.length;

        if (k == 0)
            return;

        if (k < 0) {
            k += nums.length;
        }

        rotate(nums, 0, nums.length - k - 1);
        rotate(nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - 1);

    }

    public void rotate(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
// @lc code=end
