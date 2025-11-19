package solutions;
/*
 * @lc app=leetcode id=2154 lang=java
 *
 * [2154] Keep Multiplying Found Values by Two
 */

// @lc code=start

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int findFinalValue(int[] nums, int original) {

        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        while (numbers.contains(original)) {
            original *= 2;
        }

        return original;

    }
}
// @lc code=end
