package solutions;
/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

import java.util.HashSet;

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> values = new HashSet<>();
        int left, right, ans = 0;

        for (int n : nums) {
            values.add(n);
        }

        for (int n : nums) {
            // if (!values.contains(n)) {
            left = n - 1;
            right = n + 1;
            while (values.remove(left)) {
                left--;
            }
            while (values.remove(right)) {
                right++;
            }
            ans = Math.max(ans, right - left - 1);
            // } else {
            // continue;
            // }

        }

        return ans;

    }

    /*
     * public int longestConsecutive(int[] nums) {
     * 
     * HashMap<Integer, Integer> map = new HashMap<>();
     * int maxLength = 0;
     * 
     * for( int num : nums ) {
     * 
     * int left = map.getOrDefault(num - 1, 0);
     * int right = map.getOrDefault(num + 1, 0);
     * 
     * int sum = left + right + 1;
     * 
     * map.put(num, sum);
     * 
     * maxLength = Math.max(maxLength, sum);
     * 
     * if(left > 0) map.put(num - left, sum);
     * if(right > 0) map.put(num + right, sum);
     * }
     * 
     * return maxLength;
     * }
     */
}
// @lc code=end
