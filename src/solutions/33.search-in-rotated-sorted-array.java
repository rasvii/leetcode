package solutions;
/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
//Binary search
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, low = 0, high = n - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int rot = low;
        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int realMid = (mid + rot) % n;
            if (nums[realMid] == target)
                return realMid;

            if (nums[realMid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
// @lc code=end
