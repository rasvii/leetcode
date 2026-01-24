package solutions;
/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0, high = nums.length - 1;

        for (int n : nums) {
            low = Math.max(low, n);
            high += n;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            int need = 1, cur = 0;

            for (int n : nums) {
                if (cur + n > mid) {
                    cur = 0;
                    need++;
                }

                cur += n;
            }

            if (need > k) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return low;

    }
}
// @lc code=end
