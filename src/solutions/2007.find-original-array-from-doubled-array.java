package solutions;
/*
 * @lc app=leetcode id=2007 lang=java
 *
 * [2007] Find Original Array From Doubled Array
 */

import java.util.Map;
import java.util.TreeMap;

// @lc code=start
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }

        Map<Integer, Integer> freq = new TreeMap<>();
        int[] result = new int[changed.length / 2];
        int index = 0;

        for (int i : changed) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for (int i : freq.keySet()) {
            if (freq.get(i) > freq.getOrDefault(i * 2, 0)) {
                return new int[0];
            }

            for (int j = 0; j < freq.get(i); j++) {
                result[index++] = i;
                freq.put(2 * i, freq.get(2 * i) - 1);
            }
        }

        return result;

    }
}
// @lc code=end
