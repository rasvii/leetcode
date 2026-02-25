package solutions;
/*
 * @lc app=leetcode id=1356 lang=java
 *
 * [1356] Sort Integers by The Number of 1 Bits
 */

import java.util.*;

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {

        Map<Integer, List<Integer>> map = new TreeMap<>();


        for(int n : arr) {
            int count = Integer.bitCount(n);

            map.computeIfAbsent(count, k -> new ArrayList<>()).add(n);
        }


        int[] result = new int[arr.length];
        int i = 0;

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet() ) {
            List<Integer> nums = entry.getValue();
            Collections.sort(nums);

            for(int n : nums){
                result[i] = n;
                i++;
            }
        }

        return result;
        
    }
}
// @lc code=end

