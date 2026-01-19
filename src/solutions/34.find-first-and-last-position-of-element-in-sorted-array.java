package solutions;
/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        int low = 0, high = n - 1;
        int[] result = {-1, -1};
        
        while(low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        if(n == 0 || nums[low] != target) {
            return result;
        }

        result[0] = low;

        low = 0;
        high = n -1;

        while (low < high) {
            int mid = low + ((high - low) + 1) / 2;

            if(target < nums[mid]) {
                high = mid -1;
            }
            else {
                low = mid;
            }
        }

        result[1] = low;

        return result;
    }
}
// @lc code=end

