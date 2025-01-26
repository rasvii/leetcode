package solutions;
/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int totalLength = x + y;

        int left = 0;
        int right = x;

        while (left <= right) {
            int midX = (left + right) / 2;
            int midY = ((totalLength + 1) / 2) - midX;

            int maxLeftX = midX == 0 ? Integer.MIN_VALUE : nums1[midX - 1];
            int maxLeftY = midY == 0 ? Integer.MIN_VALUE : nums2[midY - 1];

            int minRightX = midX == x ? Integer.MAX_VALUE : nums1[midX];
            int minRightY = midY == y ? Integer.MAX_VALUE : nums2[midY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if (totalLength % 2 == 0) {
                    int sum = Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY);
                    return ((double) sum / 2.0);
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = midX - 1;
            } else {
                left = midX + 1;
            }
        }
        throw new IllegalArgumentException();

    }
}
// @lc code=end
