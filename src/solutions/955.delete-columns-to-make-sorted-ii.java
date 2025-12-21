package solutions;

/*
 * @lc app=leetcode id=955 lang=java
 *
 * [955] Delete Columns to Make Sorted II
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minDeletionSize(String[] strs) {

        int result = Integer.MAX_VALUE;

        int n = strs.length;
        int wordLen = strs[0].length();
        int start = 0;
        Set<Integer> toDelete = new HashSet<>();

        for (int row = 1; row < n; row++) {

            for (int col = 0; col < wordLen; col++) {

                if (toDelete.contains(col) || strs[row - 1].charAt(col) == strs[row].charAt(col))
                    continue;

                if (strs[row - 1].charAt(col) > strs[row].charAt(col)) {
                    toDelete.add(col);
                    row = 0;
                }

                break;
            }
        }

        return toDelete.size();

    }
}
// @lc code=end
