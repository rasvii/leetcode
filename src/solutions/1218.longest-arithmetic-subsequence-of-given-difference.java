package solutions;
/*
 * @lc app=leetcode id=1218 lang=java
 *
 * [1218] Longest Arithmetic Subsequence of Given Difference
 */

import java.util.HashMap;

// @lc code=start
class Solution {
    public int longestSubsequence(int[] arr, int difference) {

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 1;

        for(int i = 0; i < n; i++) {
            int prev = arr[i] - difference;

            if(map.containsKey(prev)) {
                map.put(arr[i], map.get(prev) + 1);
            }
            else {
                map.put(arr[i], 1);
            }

            result = Math.max(result, map.get(arr[i]));
        }

        return result;
        
    }
}
// @lc code=end

