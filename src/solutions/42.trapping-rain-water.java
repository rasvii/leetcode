package solutions;
/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {

        int n = height.length;

        if (n <= 2)
            return 0;

        int left = 0, right = n - 1;
        int maxRight = 0, maxLeft = 0;

        int totalWater = 0;

        while (left < right) {

            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }

                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }

                right--;

            }
        }

        return totalWater;

    }
}
// @lc code=end
