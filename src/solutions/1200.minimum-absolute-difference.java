package solutions;
/*
 * @lc app=leetcode id=1200 lang=java
 *
 * [1200] Minimum Absolute Difference
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length -1; i++) {
            minDiff = Math.min(minDiff, arr[i+1] - arr[i]);
        }

        for(int i = 0; i < arr.length -1; i++) {
            if(arr[i+1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }


        return result;
    }
}
// @lc code=end

