package solutions;
/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;
    }
}

// binary search
// class Solution {
// public int lengthOfLIS(int[] nums) {
// int[] list = new int[nums.length];

// int len = 0;

// for(int n : nums ) {
// if(len == 0 || list[len-1] < n) {
// list[len++] = n;
// }
// else {
// list[binarySearch(list, n, len-1)] = n;
// }
// }

// return len;
// }

// private int binarySearch(int[] list, int num, int listSize) {
// int low = 0, high = listSize;

// while (low < high) {
// int mid = (low + high) / 2;
// if (list[mid] < num) {
// low = mid + 1;
// } else {
// high = mid;
// }
// }

// return low;
// }
// }
// @lc code=end
