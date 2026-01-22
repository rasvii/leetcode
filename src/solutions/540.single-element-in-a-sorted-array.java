package solutions;
/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && nums[mid - 1] == nums[mid])) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];

    }
}
// @lc code=end

