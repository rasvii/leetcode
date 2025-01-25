/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        int merged[] = new int[length1 + length2];

        int index = 0;

        for (int i = 0; i < length1; i++) {
            merged[index] = nums1[i];
            index++;
        }

        for (int i = 0; i < length2; i++) {
            merged[index] = nums2[i];
        }

        Arrays.sort(merged);

        if (merged.length % 2 == 0) {
            int mid = merged.length / 2;
            return (merged[mid] + merged[mid - 1]) / 2;

        } else {
            int mid = merged.length / 2;
            return merged[mid];
        }
    }
}
// @lc code=end
